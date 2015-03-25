/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author hfluz
 */
@FacesRenderer(componentFamily = "Button", rendererType = "Button")
public class ButtonRenderer extends Renderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("a", component);
        writer.writeAttribute("role", "button", null);
        ButtonComponent buttonComponent = (ButtonComponent) component;
        writer.writeAttribute("href", buttonComponent.getHref(), "href");
        writer.writeAttribute("class", buildStyleClass(buttonComponent), "styleClass");
        if (buttonComponent.getStyle() != null && !buttonComponent.getStyle().trim().isEmpty()) {
            writer.writeAttribute("style", buttonComponent.getStyle(), "style");
        }
        writer.write((String) buttonComponent.getValue());
        writer.endElement("a");
    }

    private String buildStyleClass(ButtonComponent component) {
        List<String> styleClasses = new ArrayList<>();
        styleClasses.add("button");
        if (component.getSize() != null) {
            String allowedSizes = "tiny small large expand";
            if (allowedSizes.contains(component.getSize())) {
                styleClasses.add(component.getSize());
            }
        }
        if (component.getCorner() != null) {
            String allowedCorners = "round radius";
            if (allowedCorners.contains(component.getCorner())) {
                styleClasses.add(component.getCorner());
            }
        }
        if(component.isDisabled() != null && component.isDisabled()){
            styleClasses.add("disabled");
        }
        return StringUtils.join(styleClasses, ' ');
    }

}
