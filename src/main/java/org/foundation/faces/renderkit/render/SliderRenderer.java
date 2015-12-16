package org.foundation.faces.renderkit.render;

import com.sun.faces.renderkit.html_basic.HtmlBasicInputRenderer;
import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import org.foundation.faces.component.SliderUI;

/**
 *
 * @author hfluz <hfluz@uel.br>
 */
@FacesRenderer(componentFamily = "org.foundation.faces", rendererType = "SliderRenderer")
public class SliderRenderer extends HtmlBasicInputRenderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        SliderUI slider = (SliderUI) component;
        writer.startElement("div", component);
        writer.writeAttribute("class", "slider", null);
        writer.writeAttribute("data-slider", "data-slider", null);
        writer.startElement("span", null);
        writer.writeAttribute("class", "slider-handle", null);
        writer.writeAttribute("data-slider-handle", "data-slider-handle", null);
        writer.writeAttribute("role", "slider", null);
        writer.writeAttribute("tabindex", "1", null);
        writer.endElement("span");
        writer.startElement("span", null);
        writer.writeAttribute("class", "slider-fill", null);
        writer.writeAttribute("data-slider-fill", "data-slider-fill", null);
        writer.endElement("span");
        writer.startElement("input", null);
        writer.writeAttribute("type", "hidden", null);
        writer.endElement("input");
    }

}
