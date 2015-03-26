/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.renderer;

import com.foundation.faces.component.TopBarComponent;
import java.io.IOException;
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
        ResponseWriter writer = context.getResponseWriter();
        TopBarComponent topBar = (TopBarComponent) component;
        if(topBar.isFixed() || topBar.isContainToGrid() || topBar.isSticky()){
            writer.startElement("div", component);
            StringJoiner styleClass = new StringJoiner(" ");
            if(topBar.isFixed()){
                styleClass.add("fixed");
            }
            if(topBar.isContainToGrid()){
                styleClass.add("contain-to-grid");
            }
            if(topBar.isSticky()){
                styleClass.add("sticky");
            }
            writer.writeAttribute("class", styleClass.toString(), null);
            writer.startElement("nav", null);
        } else{
            writer.startElement("nav", component);
        }
        writer.writeAttribute("class", "top-bar", null);
        writer.writeAttribute("role", "navigation", null);
        writer.writeAttribute("data-topbar", "", null);
        
        encodeTitleArea(writer, topBar);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        TopBarComponent topBar = (TopBarComponent) component;
        writer.endElement("nav");
        if(topBar.isFixed() || topBar.isContainToGrid() || topBar.isSticky()){
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
        writer.endElement("ul");
    }
}
