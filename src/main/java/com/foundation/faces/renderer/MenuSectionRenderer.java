package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import com.foundation.faces.component.DropdownMenuComponent;
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
public class MenuSectionRenderer extends Renderer{

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        MenuSectionComponent menuSection = (MenuSectionComponent) component;
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
        DropdownMenuRenderer dropdownMenuRenderer = new DropdownMenuRenderer();
        for(UIComponent innerComponent : innerComponents){
            if(innerComponent instanceof ButtonComponent){
                menuLinkRenderer.encodeEnd(context, innerComponent);
            } else if(innerComponent instanceof DropdownMenuComponent){
                dropdownMenuRenderer.encodeBegin(context, innerComponent);
                dropdownMenuRenderer.encodeChildren(context, innerComponent);
                dropdownMenuRenderer.encodeEnd(context, innerComponent);
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
