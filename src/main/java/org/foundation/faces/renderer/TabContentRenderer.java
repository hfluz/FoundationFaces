package org.foundation.faces.renderer;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundation.faces.component.TabContentUI;

/**
 * Renderer of {@link TabContentUI}
 *
 * @author hfluz
 * @since 0.0.2
 */
@FacesRenderer(componentFamily = "Tab", rendererType = "TabContent")
public class TabContentRenderer extends Renderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        TabContentUI tabContent = (TabContentUI) component;
        writer.startElement("div", tabContent);
        writer.writeAttribute("zf-tab-content", "", null);
        writer.writeAttribute("target", tabContent.getTarget(), null);
        writer.endElement("div");
    }
}
