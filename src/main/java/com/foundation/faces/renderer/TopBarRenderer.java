/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import com.foundation.faces.component.DropdownMenuComponent;
import com.foundation.faces.component.MenuSectionComponent;
import com.foundation.faces.component.TopBarComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "Menu", rendererType = "TopBar")
public class TopBarRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = writer = context.getResponseWriter();
        TopBarComponent topBar = (TopBarComponent) component;
        if (topBar.isFixed() || topBar.isContainToGrid() || topBar.isSticky()) {
            writer.startElement("div", component);
            writer.writeAttribute("class", buildDivStyleClass(topBar), null);
            writer.startElement("nav", null);
        } else {
            writer.startElement("nav", component);
        }
        writer.writeAttribute("id", topBar.getClientId(context), null);
        writer.writeAttribute("class", buildNavStyleClass(topBar), null);
        if (topBar.getStyle() != null) {
            writer.writeAttribute("style", topBar.getStyle(), null);
        }
        writer.writeAttribute("role", "navigation", null);
        writer.writeAttribute("data-topbar", "", null);

        encodeTitleArea(writer, topBar);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        MenuSectionRenderer menuSectionRenderer = new MenuSectionRenderer();
        DropdownMenuRenderer dropdownMenuRenderer = new DropdownMenuRenderer();
        MenuLinkRenderer menuLinkRenderer = new MenuLinkRenderer();
        List<UIComponent> innerComponents = component.getChildren();
        if (!innerComponents.isEmpty()) {
            List<MenuSectionComponent> rightSections = new ArrayList<>();
            writer.startElement("section", null);
            writer.writeAttribute("class", "top-bar-section", null);
            System.out.println("size " + innerComponents.size());
            boolean leftSectionStarted = false;
            for (UIComponent innerComponent : innerComponents) {
                leftSectionStarted = startOrCloseLeftSectionIfNeeded(writer, innerComponent, leftSectionStarted);
                if (innerComponent instanceof MenuSectionComponent) {
                    menuSectionRenderer.encodeBegin(context, innerComponent);
                    menuSectionRenderer.encodeChildren(context, innerComponent);
                    menuSectionRenderer.encodeEnd(context, innerComponent);
                } else if (innerComponent instanceof DropdownMenuComponent) {
                    dropdownMenuRenderer.encodeBegin(context, innerComponent);
                    dropdownMenuRenderer.encodeChildren(context, innerComponent);
                    dropdownMenuRenderer.encodeEnd(context, innerComponent);
                } else if (innerComponent instanceof ButtonComponent) {
                    menuLinkRenderer.encodeEnd(context, innerComponent);
                }
            }
            writer.endElement("section");
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        TopBarComponent topBar = (TopBarComponent) component;
        writer.endElement("nav");
        if (topBar.isFixed() || topBar.isContainToGrid() || topBar.isSticky()) {
            writer.endElement("div");
        }
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    private String buildDivStyleClass(TopBarComponent topBar) {
        StringJoiner styleClass = new StringJoiner(" ");
        if (topBar.isFixed()) {
            styleClass.add("fixed");
        }
        if (topBar.isContainToGrid()) {
            styleClass.add("contain-to-grid");
        }
        if (topBar.isSticky()) {
            styleClass.add("sticky");
        }

        return styleClass.toString();
    }

    private String buildNavStyleClass(TopBarComponent topBar) {
        StringJoiner styleClass = new StringJoiner(" ");
        styleClass.add("top-bar");
        if (topBar.getStyleClass() != null) {
            styleClass.add(topBar.getStyleClass());
        }
        return styleClass.toString();
    }

    private void encodeTitleArea(ResponseWriter writer, TopBarComponent topBar) throws IOException {
        writer.startElement("ul", null);
        writer.writeAttribute("class", "title-area", null);
        writer.startElement("li", null);
        writer.writeAttribute("class", "name", null);
        writer.startElement("h1", null);
        writer.startElement("a", null);
        writer.writeAttribute("href", topBar.getHomeLink(), null);
        writer.write(topBar.getHome());
        writer.endElement("a");
        writer.endElement("h1");
        writer.endElement("li");
        writer.startElement("li", null);
        writer.writeAttribute("class", "toggle-topbar menu-icon", null);
        writer.startElement("a", null);
        writer.writeAttribute("href", "", null);
        writer.startElement("span", null);
        writer.write("Menu");
        writer.endElement("span");
        writer.endElement("a");
        writer.endElement("li");
        writer.endElement("ul");
    }

    /**
     *
     * @param writer
     * @param nextComponentToBeEncoded
     * @param leftSectionStarted
     * @return new value of startNewLeftSection flag.
     * @throws IOException
     */
    private boolean startOrCloseLeftSectionIfNeeded(ResponseWriter writer, UIComponent nextComponentToBeEncoded, boolean leftSectionStarted) throws IOException {
        if (nextComponentToBeEncoded instanceof DropdownMenuComponent
                || nextComponentToBeEncoded instanceof ButtonComponent) {
            if (!leftSectionStarted) {
                writer.startElement("ul", null);
                writer.writeAttribute("class", "left", null);
                leftSectionStarted = true;
            }
        } else if (leftSectionStarted) {
            writer.endElement("ul");
            leftSectionStarted = false;
        }
        return leftSectionStarted;
    }
}
