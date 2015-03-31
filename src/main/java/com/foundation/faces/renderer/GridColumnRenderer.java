package com.foundation.faces.renderer;

import com.foundation.faces.component.GridColumnUI;
import com.foundation.faces.util.GridRange;
import com.foundation.faces.util.RendererUtil;
import java.io.IOException;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "GridColumn", rendererType = "GridColumn")
public class GridColumnRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        GridColumnUI gridColumn = (GridColumnUI) component;
        writer.startElement("div", gridColumn);
        writer.writeAttribute("class", buildStyleClass(gridColumn), "styleClass");
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
        super.encodeEnd(context, component); //To change body of generated methods, choose Tools | Templates.
    }

    private Object buildStyleClass(GridColumnUI gridColumn) {
        StringJoiner styleClass = new StringJoiner(" ");
        if (gridColumn.getStyleClass() != null) {
            styleClass.add(gridColumn.getStyleClass());
        }
        if (gridColumn.getSmallCentered()) {
            styleClass.add("small-centered");
        }
        if (gridColumn.getMediumCentered()) {
            styleClass.add("medium-centered");
        }
        if (gridColumn.getLargeCentered()) {
            styleClass.add("large-centered");
        }
        if (gridColumn.getMediumUncentered()) {
            styleClass.add("medium-uncentered");
        }
        if (gridColumn.getLargeUncentered()) {
            styleClass.add("large-uncentered");
        }
        if (gridColumn.getSmallOffset() != null && GridRange.validate(gridColumn.getSmallOffset())) {
            styleClass.add("small-offset-" + gridColumn.getSmallOffset());
        }
        if (gridColumn.getMediumOffset() != null && GridRange.validate(gridColumn.getMediumOffset())) {
            styleClass.add("medium-offset-" + gridColumn.getMediumOffset());
        }
        if (gridColumn.getLargeOffset() != null && GridRange.validate(gridColumn.getLargeOffset())) {
            styleClass.add("large-offset-" + gridColumn.getLargeOffset());
        }
        if (gridColumn.getSmallWidth() != null && GridRange.validate(gridColumn.getSmallWidth())) {
            styleClass.add("small-" + gridColumn.getSmallWidth());
        }
        if (gridColumn.getMediumWidth() != null && GridRange.validate(gridColumn.getMediumWidth())) {
            styleClass.add("medium-" + gridColumn.getMediumWidth());
        }
        if (gridColumn.getLargeWidth() != null && GridRange.validate(gridColumn.getLargeWidth())) {
            styleClass.add("large-" + gridColumn.getLargeWidth());
        }
        if (gridColumn.getSmallPull() != null && GridRange.validate(gridColumn.getSmallPull())) {
            styleClass.add("small-pull-" + gridColumn.getSmallPull());
        }
        if (gridColumn.getMediumPull() != null && GridRange.validate(gridColumn.getMediumPull())) {
            styleClass.add("medium-pull-" + gridColumn.getMediumPull());
        }
        if (gridColumn.getLargePull() != null && GridRange.validate(gridColumn.getLargePull())) {
            styleClass.add("large-pull-" + gridColumn.getLargePull());
        }
        if (gridColumn.getSmallPush() != null && GridRange.validate(gridColumn.getSmallPush())) {
            styleClass.add("small-push-" + gridColumn.getSmallPush());
        }
        if (gridColumn.getMediumPush() != null && GridRange.validate(gridColumn.getMediumPush())) {
            styleClass.add("medium-push-" + gridColumn.getMediumPush());
        }
        if (gridColumn.getLargePush() != null && GridRange.validate(gridColumn.getLargePush())) {
            styleClass.add("large-push-" + gridColumn.getLargePush());
        }
        if (gridColumn.getMediumResetOrder()) {
            styleClass.add("medium-reset-order");
        }
        if (gridColumn.getLargeResetOrder()) {
            styleClass.add("large-reset-order");
        }
        if (gridColumn.getEnd()) {
            styleClass.add("end");
        }
        return styleClass.toString();
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
