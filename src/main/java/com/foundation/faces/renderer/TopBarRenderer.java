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
            writer.writeAttribute("class", styleClass.toString(), null);
            writer.startElement("nav", null);
        } else {
            writer.startElement("nav", component);
        }
        writer.writeAttribute("class", "top-bar", null);
        writer.writeAttribute("role", "navigation", null);
        writer.writeAttribute("data-topbar", "", null);

        encodeTitleArea(writer, topBar);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        MenuSectionRenderer menuSectionRenderer = new MenuSectionRenderer();
        DropdownMenuRenderer dropdownMenuRenderer = new DropdownMenuRenderer();
        LinkRenderer linkRenderer = new LinkRenderer();
        List<UIComponent> innerComponents = component.getChildren();
        if (!innerComponents.isEmpty()) {
            List<MenuSectionComponent> rightSections = new ArrayList<>();
            writer.startElement("section", null);
            writer.writeAttribute("class", "top-bar-section", null);
            System.out.println("size " + innerComponents.size());
//            boolean createLeftSection = createLeftSection((TopBarComponent) component);
//            if (createLeftSection) {
//                writer.startElement("ul", null);
//                writer.writeAttribute("class", "left", null);
//            }
            boolean startNewLeftSection = true;
            for (UIComponent innerComponent : innerComponents) {
                if (innerComponent instanceof DropdownMenuComponent
                        || innerComponent instanceof ButtonComponent) {
                    if (startNewLeftSection) {
                        writer.startElement("ul", null);
                        writer.writeAttribute("class", "left", null);
                        startNewLeftSection = false;
                    }
                } else if (!startNewLeftSection) {
                    writer.endElement("ul");
                    startNewLeftSection = true;
                }

                if (innerComponent instanceof MenuSectionComponent) {
                    menuSectionRenderer.encodeBegin(context, innerComponent);
                    menuSectionRenderer.encodeChildren(context, innerComponent);
                    menuSectionRenderer.encodeEnd(context, innerComponent);
                } else if (innerComponent instanceof DropdownMenuComponent) {
                    dropdownMenuRenderer.encodeBegin(context, innerComponent);
                    dropdownMenuRenderer.encodeChildren(context, innerComponent);
                    dropdownMenuRenderer.encodeEnd(context, innerComponent);
                } else if (innerComponent instanceof ButtonComponent) {
                    writer.startElement("li", null);
                    linkRenderer.encodeEnd(context, innerComponent);
                    writer.endElement("li");
                }
            }
//            if (createLeftSection) {
//                writer.endElement("ul");
//            }
//            if (!rightSections.isEmpty()) {
//                writer.startElement("ul", null);
//                writer.writeAttribute("class", "right", null);
//                for (MenuSectionComponent rs : rightSections) {
//                    menuSectionRenderer.encodeBegin(context, rs);
//                    menuSectionRenderer.encodeChildren(context, rs);
//                    menuSectionRenderer.encodeEnd(context, rs);
//                }
//                writer.endElement("ul");
//            }
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

    private boolean createLeftSection(TopBarComponent topBar) {
        for (UIComponent innerComponent : topBar.getChildren()) {
            if (innerComponent instanceof ButtonComponent
                    || innerComponent instanceof DropdownMenuComponent) {
                return true;
            }
            if (innerComponent instanceof MenuSectionComponent) {
                MenuSectionComponent menuSection = (MenuSectionComponent) innerComponent;
                if (menuSection.getAlignment() == null || menuSection.getAlignment().equals("left")) {
                    return true;
                }
            }
        }
        return false;
    }
}
