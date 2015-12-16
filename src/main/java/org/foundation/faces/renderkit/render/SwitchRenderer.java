package org.foundation.faces.renderkit.render;

import com.sun.faces.renderkit.html_basic.CheckboxRenderer;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import org.foundation.faces.component.SwitchUI;

/**
 *
 * @author hfluz <hfluz@uel.br>
 */
@FacesRenderer(componentFamily = "org.foundation.faces", rendererType = "SwitchRenderer")
public class SwitchRenderer extends CheckboxRenderer {

    @Override
    protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        SwitchUI switchUI = (SwitchUI) component;
        writer.startElement("div", switchUI);
        writer.writeAttribute("class", "switch", null);
        switchUI.setStyleClass("switch-input " + (switchUI.getStyleClass() != null ? switchUI.getStyleClass() : ""));
        if (component.getId() == null) {
            component.setId(component.getClientId(context));
        }
        super.getEndTextToRender(context, component, currentValue);
        writer.startElement("label", null);
        writer.writeAttribute("class", "switch-paddle", null);
        writer.writeAttribute("for", switchUI.getClientId(context), null);
        writer.endElement("label");
        writer.endElement("div");
    }

}
