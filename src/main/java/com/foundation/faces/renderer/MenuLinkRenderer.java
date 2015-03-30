package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "Menu", rendererType = "MenuLink")
public class MenuLinkRenderer extends Renderer{

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonComponent link = (ButtonComponent) component;
        LinkRenderer linkRenderer = new LinkRenderer();
        writer.startElement("li", link);
        if(link.getActive()){
            writer.writeAttribute("class", "active", null);
        }
        linkRenderer.encodeEnd(context, component);
        writer.endElement("li");
    }
    
}
