package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
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
@FacesRenderer(componentFamily = "Button", rendererType = "SplitButton")
public class SplitButtonRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        buttonRenderer.encodeBegin(context, component);
        writer.startElement("span", null);
        writer.writeAttribute("data-dropdown", "drop", null);
        writer.endElement("span");
        buttonRenderer.encodeEnd(context, component);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("ul", null);
        writer.writeAttribute("id", "drop", null);
        writer.writeAttribute("class", "f-dropdown", null);
        writer.writeAttribute("data-dropdown-content", "", null);
        List<UIComponent> innerComponents = component.getChildren();
        LinkRenderer linkRenderer = new LinkRenderer();
        for(UIComponent innerComponent : innerComponents){
            if(innerComponent instanceof ButtonComponent){
                writer.startElement("li", null);
                linkRenderer.encodeBegin(context, (ButtonComponent) innerComponent);
                linkRenderer.encodeEnd(context, (ButtonComponent) innerComponent);
                writer.endElement("li");
            }
        }
        writer.endElement("ul");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
