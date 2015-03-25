package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonBarComponent;
import com.foundation.faces.component.ButtonGroupComponent;
import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "Button", rendererType = "ButtonBar")
public class ButtonBarRenderer extends Renderer{

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        ButtonBarComponent buttonBarComponent = (ButtonBarComponent) component;
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
            if(innerComponent instanceof ButtonGroupComponent){
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
