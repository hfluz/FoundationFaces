package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import com.foundation.faces.component.MenuSectionComponent;
import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "Menu", rendererType = "MenuSection")
public class MenuSectionRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        MenuSectionComponent menuSection = (MenuSectionComponent) component;
        writer.startElement("section", component);
        writer.startElement("ul", null);
        String allowedOptions = "left right";
        if(menuSection.getAlignment() != null && allowedOptions.contains(menuSection.getAlignment())){
            writer.writeAttribute("class", menuSection.getAlignment(), "alignement");
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        List<UIComponent> innerComponents = component.getChildren();
        LinkRenderer linkRenderer = new LinkRenderer();
        for(UIComponent innerComponent : innerComponents){
            if(innerComponent instanceof ButtonComponent){
                writer.startElement("li", null);
                linkRenderer.encodeEnd(context, (ButtonComponent) innerComponent);
                writer.endElement("li");
            }
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("ul");
        writer.endElement("section");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
