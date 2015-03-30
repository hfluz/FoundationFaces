package com.foundation.faces.renderer;

import com.foundation.faces.component.GridRowUI;
import com.foundation.faces.util.RendererUtil;
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
@FacesRenderer(componentFamily = "GridRow", rendererType = "GridRow")
public class GridRowRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        GridRowUI gridRow = (GridRowUI) component;
        writer.startElement("div", gridRow);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        for (UIComponent innerComponent : component.getChildren()) {
            if (innerComponent.getRendererType() != null) {
                Renderer renderer = RendererUtil.getRenderer(context, component);
                renderer.encodeBegin(context, component);
                renderer.encodeChildren(context, component);
                renderer.encodeEnd(context, component);
            } else {
                innerComponent.encodeAll(context);
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
