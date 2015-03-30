package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonUI;
import com.foundation.faces.component.DropdownMenuUI;
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
@FacesRenderer(componentFamily = "Menu", rendererType = "DropdownMenu")
public class DropdownMenuRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        DropdownMenuUI menuSection = (DropdownMenuUI) component;
        writer.startElement("li", menuSection);
        writer.writeAttribute("id", menuSection.getClientId(context), null);
        writer.writeAttribute("class", "has-dropdown", null);
        encodeSectionLink(writer, menuSection);
    }

    private void encodeSectionLink(ResponseWriter writer, DropdownMenuUI menuSection) throws IOException {
        writer.startElement("a", null);
        writer.write(menuSection.getLabel());
        writer.endElement("a");
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        List<UIComponent> innerComponents = component.getChildren();
        MenuLinkRenderer menuLinkRenderer = new MenuLinkRenderer();
        writer.startElement("ul", null);
        writer.writeAttribute("class", "dropdown", null);
        for (UIComponent innerComponent : innerComponents) {
            if (innerComponent instanceof ButtonUI) {
                menuLinkRenderer.encodeEnd(context, (ButtonUI) innerComponent);
            }
        }
        writer.endElement("ul");
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("li");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
