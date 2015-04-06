package org.foundation.faces.renderer;

import org.foundation.faces.component.ButtonUI;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Alternative renderer for {@link ButtonUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Menu", rendererType = "MenuLink")
public class MenuLinkRenderer extends Renderer{

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonUI link = (ButtonUI) component;
        LinkRenderer linkRenderer = new LinkRenderer();
        writer.startElement("li", link);
        if(link.getActive()){
            writer.writeAttribute("class", "active", null);
        }
        linkRenderer.encodeEnd(context, component);
        writer.endElement("li");
    }
    
}
