package org.foundation.faces.renderer;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundation.faces.component.TabUI;
import org.foundation.faces.component.TabsUI;

/**
 * Renderer for {@link TabsUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Tab", rendererType = "Tabs")
public class TabsRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        TabsUI tabs = (TabsUI) component;
        writer.startElement("div", tabs);
        writer.writeAttribute("zf-tabs", "", null);
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
        writer.endElement("div");
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
