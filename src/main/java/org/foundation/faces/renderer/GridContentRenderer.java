package org.foundation.faces.renderer;

import org.foundation.faces.component.GridContentUI;
import org.foundation.faces.util.RendererUtil;
import java.io.IOException;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Renderer for {@link GridContentUI}
 *
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Grid", rendererType = "GridContent")
public class GridContentRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        GridContentUI gridContent = (GridContentUI) component;
        writer.startElement("div", component);
        writer.writeAttribute("class", buildStyleClass(gridContent), "styleClass");
        if(gridContent.getStyle() != null){
            writer.writeAttribute("style", gridContent.getStyle(), "style");
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        RendererUtil.encodeAllChildren(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("div");
    }

    private Object buildStyleClass(GridContentUI gridContent) {
        StringJoiner styleClass = new StringJoiner(" ");
        styleClass.add("grid-content");
        if (gridContent.getStyleClass() != null) {
            styleClass.add(gridContent.getStyleClass());
        }
        return styleClass.toString();
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
