package org.foundation.faces.renderer;

import org.foundation.faces.component.ButtonUI;
import org.foundation.faces.component.SplitButtonUI;
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
 * Alternative renderer for {@link ButtonUI}
 * @author hfluz
 * @since 0.0.1
 */
@FacesRenderer(componentFamily = "Button", rendererType = "Link")
public class LinkRenderer extends Renderer {
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("a", component);
        ButtonUI buttonComponent = (ButtonUI) component;
        writer.writeAttribute("id", buttonComponent.getClientId(context), null);
        writer.writeAttribute("href", buttonComponent.getHref(), "href");
        writer.writeAttribute("class", buildStyleClass(buttonComponent), "styleClass");
        if (buttonComponent.getStyle() != null && !buttonComponent.getStyle().trim().isEmpty()) {
            writer.writeAttribute("style", buttonComponent.getStyle(), "style");
        }
        writer.write((String) buttonComponent.getValue());
        writer.endElement("a");
    }

    private String buildStyleClass(ButtonUI buttonComponent) {
        List<String> styleClasses = new ArrayList<>();
        if (buttonComponent.getSize() != null) {
            String allowedSizes = "tiny small large expand";
            if (allowedSizes.contains(buttonComponent.getSize())) {
                styleClasses.add(buttonComponent.getSize());
            }
        }
        if (buttonComponent.getCorner() != null) {
            String allowedCorners = "round radius";
            if (allowedCorners.contains(buttonComponent.getCorner())) {
                styleClasses.add(buttonComponent.getCorner());
            }
        }
        if(buttonComponent.isDisabled()){
            styleClasses.add("disabled");
        }
        if(buttonComponent instanceof SplitButtonUI){
            styleClasses.add("split");
        }
        return StringUtils.join(styleClasses, ' ');
    }

}
