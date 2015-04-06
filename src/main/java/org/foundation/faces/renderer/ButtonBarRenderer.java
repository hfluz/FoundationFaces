package org.foundation.faces.renderer;

import org.foundation.faces.component.ButtonBarUI;
import org.foundation.faces.component.ButtonGroupUI;
import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Renderer for {@link ButtonBarUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Button", rendererType = "ButtonBar")
public class ButtonBarRenderer extends Renderer{

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonBarUI buttonBarComponent = (ButtonBarUI) component;
        writer.startElement("div", component);
        writer.writeAttribute("class", "button-bar", null);
        if(buttonBarComponent.getStyleClass() != null){
            writer.writeAttribute("class", buttonBarComponent.getStyleClass(), "styleClass");
        }
        if(buttonBarComponent.getStyle() != null){
            writer.writeAttribute("style", buttonBarComponent.getStyle(), "style");
        }
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        List<UIComponent> innerComponents = component.getChildren();
        ButtonGroupRenderer buttonGroupRenderer = new ButtonGroupRenderer();
        for(UIComponent innerComponent : innerComponents){
            if(innerComponent instanceof ButtonGroupUI){
                buttonGroupRenderer.encodeBegin(context, innerComponent);
                buttonGroupRenderer.encodeChildren(context, innerComponent);
                buttonGroupRenderer.encodeEnd(context, innerComponent);
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
