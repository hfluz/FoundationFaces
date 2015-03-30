package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonUI;
import com.foundation.faces.component.ButtonGroupUI;
import java.io.IOException;
import java.util.List;
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
@FacesRenderer(componentFamily = "Button", rendererType = "ButtonGroup")
public class ButtonGroupRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonGroupUI buttonGroupComponent = (ButtonGroupUI) component;
        writer.startElement("ul", component);
        writer.writeAttribute("class", buildStyleClass(buttonGroupComponent), "styleClass");
        if (buttonGroupComponent.getStyle() != null) {
            writer.writeAttribute("style", buttonGroupComponent.getStyle(), "style");
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        List<UIComponent> innerComponents = component.getChildren();
        ButtonRenderer buttonRenderer = new ButtonRenderer();
        for (UIComponent innerComponent : innerComponents) {
            if (innerComponent instanceof ButtonUI) {
                writer.startElement("li", null);
                buttonRenderer.encodeBegin(context, (ButtonUI) innerComponent);
                buttonRenderer.encodeEnd(context, (ButtonUI) innerComponent);
                writer.endElement("li");
            }
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("ul");
    }

    private String buildStyleClass(ButtonGroupUI component) {
        StringJoiner styleClasses = new StringJoiner(" ");
        styleClasses.add("button-group");
        if (component.getStyleClass() != null) {
            styleClasses.add(component.getStyleClass());
        }
        if (component.isStackEnabled() != null && component.isStackEnabled()) {
            if (component.getStackType() == null || component.getStackType().equals("stack")) {
                styleClasses.add("stack");
            } else if (component.getStackType().equals("stackForSmall")) {
                styleClasses.add("stack-for-small");
            }
            if (component.getEven() != null && component.getEven().matches("even-[1-8]")) {
                styleClasses.add(component.getEven());
            }
        }
        if (component.getCorner() != null) {
            String allowedCorners = "round radius";
            if (allowedCorners.contains(component.getCorner())) {
                styleClasses.add(component.getCorner());
            }
        }
        return styleClasses.toString();
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

}
