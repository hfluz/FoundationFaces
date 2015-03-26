package com.foundation.faces.renderer;

import com.foundation.faces.component.ButtonComponent;
import com.foundation.faces.component.SplitButtonComponent;
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
@FacesRenderer(componentFamily = "Button", rendererType = "Link")
public class LinkRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("a", component);
        ButtonComponent buttonComponent = (ButtonComponent) component;
        writer.writeAttribute("href", buttonComponent.getHref(), "href");
        writer.writeAttribute("class", buildStyleClass(buttonComponent), "styleClass");
        if (buttonComponent.getStyle() != null && !buttonComponent.getStyle().trim().isEmpty()) {
            writer.writeAttribute("style", buttonComponent.getStyle(), "style");
        }
        writer.write((String) buttonComponent.getValue());
    }
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("a");
    }

    private String buildStyleClass(ButtonComponent component) {
        List<String> styleClasses = new ArrayList<>();
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
        if(component instanceof SplitButtonComponent){
            styleClasses.add("split");
        }
        return StringUtils.join(styleClasses, ' ');
    }

}
