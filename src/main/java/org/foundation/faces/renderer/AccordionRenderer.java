package org.foundation.faces.renderer;

import java.io.IOException;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundation.faces.component.AccordionUI;
import org.foundation.faces.component.TabUI;

/**
 * Renderer for {@link AccordionUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Tab", rendererType = "Accordion")
public class AccordionRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        AccordionUI accordion = (AccordionUI) component;
//        writer.startElement("div", accordion);
//        writer.writeAttribute("ng-app", "foundation.accordion", null);
        writer.startElement("zf-accordion", accordion);
        if (accordion.getStyleClass() != null) {
            writer.writeAttribute("class", accordion.getStyleClass(), null);
        }
        if (accordion.getStyle() != null) {
            writer.writeAttribute("style", accordion.getStyle(), null);
        }
        if (!accordion.getAutoOpen()) {
            writer.writeAttribute("auto-open", "false", null);
        }
        if (accordion.getMultiOpen()) {
            writer.writeAttribute("multi-open", "true", null);
        } else if (accordion.getCollapsible()) {
            writer.writeAttribute("collapsible", accordion.getCollapsible(), null);
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        TabRenderer tabRenderer = new TabRenderer();
        for(UIComponent innerComponent : component.getChildren()){
            if(innerComponent instanceof TabUI){
                tabRenderer.encodeBegin(context, innerComponent);
                tabRenderer.encodeChildren(context, innerComponent);
                tabRenderer.encodeEnd(context, innerComponent);
            }
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("zf-accordion");
//        writer.endElement("div");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
