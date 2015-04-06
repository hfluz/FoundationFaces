package org.foundation.faces.renderer;

import org.foundation.faces.component.ButtonUI;
import org.foundation.faces.component.MenuSectionUI;
import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Renderer for {@link MenuSectionUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Menu", rendererType = "MenuSection")
public class MenuSectionRenderer extends Renderer{

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        MenuSectionUI menuSection = (MenuSectionUI) component;
        writer.startElement("ul", menuSection);
        writer.writeAttribute("id", menuSection.getClientId(context), null);
        if(menuSection.getAlignment() == null || menuSection.getAlignment().equals("right")){
            writer.writeAttribute("class", "right", null);
        } else {
            writer.writeAttribute("class", "left", null);
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        List<UIComponent> innerComponents = component.getChildren();
        MenuLinkRenderer menuLinkRenderer = new MenuLinkRenderer();
        for(UIComponent innerComponent : innerComponents){
            if(innerComponent instanceof ButtonUI){
                menuLinkRenderer.encodeEnd(context, innerComponent);
            } 
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("ul");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
