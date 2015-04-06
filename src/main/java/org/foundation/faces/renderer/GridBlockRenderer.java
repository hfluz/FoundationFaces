package org.foundation.faces.renderer;

import org.foundation.faces.component.GridBlockUI;
import org.foundation.faces.util.PropertyUtil;
import org.foundation.faces.util.RendererUtil;
import java.io.IOException;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Renderer for {@link GridBlockUI}
 *
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Grid", rendererType = "GridBlock")
public class GridBlockRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        GridBlockUI gridBlock = (GridBlockUI) component;
        writer.startElement("div", component);
        writer.writeAttribute("class", buildStyleClass(gridBlock), "styleClass");
        if(gridBlock.getStyle() != null){
            writer.writeAttribute("style", gridBlock.getStyle(), "style");
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

    private String buildStyleClass(GridBlockUI gridBlock) {
        StringJoiner styleClass = new StringJoiner(" ");
        styleClass.add("grid-block");
        if (gridBlock.getShrink()) {
            styleClass.add("shrink");
        } else {
            if (gridBlock.getSize() != null && PropertyUtil.validateSize(gridBlock.getSize())) {
                styleClass.add("small-" + gridBlock.getSize());
            }
            if (gridBlock.getMediumSize() != null && PropertyUtil.validateSize(gridBlock.getMediumSize())) {
                styleClass.add("medium-" + gridBlock.getMediumSize());
            }
            if (gridBlock.getLargeSize() != null && PropertyUtil.validateSize(gridBlock.getLargeSize())) {
                styleClass.add("large-" + gridBlock.getLargeSize());
            }
        }
        if (gridBlock.getAlignment() != null && gridBlock.getAlignment().toLowerCase().matches("left|right|center|justify|spaced")) {
            styleClass.add("align-" + gridBlock.getAlignment());
        }
        if (gridBlock.getVertical()) {
            styleClass.add("vertical");
            if (gridBlock.getMediumHorizontal()) {
                styleClass.add("medium-horizontal");
            } else if (gridBlock.getLargeHorizontal()) {
                styleClass.add("large-horizontal");
            }
        }
        if (gridBlock.getWrap()) {
            styleClass.add("wrap");
        }
        if (gridBlock.getContainer()) {
            styleClass.add("grid-container");
            if (gridBlock.getContainerAlignment() != null && gridBlock.getContainerAlignment().toLowerCase().matches("left|right")) {
                styleClass.add("contains-" + gridBlock.getContainerAlignment());
            }
        }
        if (gridBlock.getOrder() != null && PropertyUtil.validateSize(gridBlock.getOrder())) {
            styleClass.add("order-" + gridBlock.getOrder());
            if (gridBlock.getMediumOrder() != null && PropertyUtil.validateSize(gridBlock.getMediumOrder())) {
                styleClass.add("medium-order-" + gridBlock.getMediumOrder());
            }
            if (gridBlock.getLargeOrder() != null && PropertyUtil.validateSize(gridBlock.getLargeOrder())) {
                styleClass.add("large-order-" + gridBlock.getLargeOrder());
            }
        }
        
        if (gridBlock.getOffset() != null && PropertyUtil.validateSize(gridBlock.getOffset())) {
            styleClass.add("small-offset-" + gridBlock.getOffset());
            if (gridBlock.getMediumOffset() != null && PropertyUtil.validateSize(gridBlock.getMediumOffset())) {
                styleClass.add("medium-offset-" + gridBlock.getMediumOffset());
            }
            if (gridBlock.getLargeOffset() != null && PropertyUtil.validateSize(gridBlock.getLargeOffset())) {
                styleClass.add("large-offset-" + gridBlock.getLargeOffset());
            }
        }
        
        if (gridBlock.getChildrenSize() != null && PropertyUtil.validateSize(gridBlock.getChildrenSize())) {
            styleClass.add("small-up-" + gridBlock.getChildrenSize());
            if (gridBlock.getMediumChildrenSize() != null && PropertyUtil.validateSize(gridBlock.getMediumChildrenSize())) {
                styleClass.add("medium-up-" + gridBlock.getMediumChildrenSize());
            }
            if (gridBlock.getLargeChildrenSize() != null && PropertyUtil.validateSize(gridBlock.getLargeChildrenSize())) {
                styleClass.add("large-up-" + gridBlock.getLargeChildrenSize());
            }
        }
        if(gridBlock.getStyleClass() != null){
            styleClass.add(gridBlock.getStyleClass());
        }
        return styleClass.toString();
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }
}
