package org.foundation.faces.renderer;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundation.faces.component.AccordionUI;
import org.foundation.faces.component.TabUI;
import org.foundation.faces.component.TabsUI;
import org.foundation.faces.util.RendererUtil;

/**
 * Renderer of {@link TabUI}
 *
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Tab", rendererType = "Tab")
public class TabRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        TabUI tab = (TabUI) component;
        if (component.getParent() == null) {
            //@todo throw exception
        } else {
            if (component.getParent() instanceof AccordionUI) {
                writer.startElement("zf-accordion-item", component);
            }
            if (component.getParent() instanceof TabsUI) {
                writer.startElement("div", component);
                writer.writeAttribute("zf-tab", "", null);
            }
        }
        writer.writeAttribute("title", tab.getTitle(), "title");
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.encodeAllChildren(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        if (component.getParent() instanceof AccordionUI) {
            writer.endElement("zf-accordion-item");
        } else if (component.getParent() instanceof TabsUI) {
            writer.endElement("div");
        }
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
