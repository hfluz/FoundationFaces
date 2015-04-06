package org.foundation.faces.renderer;

import java.io.IOException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 * Renderer for {@link MenuBarUI}
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesRenderer(componentFamily = "Menu", rendererType = "MenuBar")
public class MenuBarRenderer extends Renderer{

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("ul", component);
        writer.writeAttribute("class", "dark menu-bar", null);
        writer.startElement("li", null);
        writer.startElement("a", null);
        writer.writeAttribute("href", "#", null);
        writer.write("Item");
        writer.endElement("a");
        writer.endElement("li");
        
         writer.startElement("li", null);
        writer.startElement("a", null);
        writer.writeAttribute("href", "#", null);
        writer.write("Item");
        writer.endElement("a");
        writer.endElement("li");
        
         writer.startElement("li", null);
        writer.startElement("a", null);
        writer.writeAttribute("href", "#", null);
        writer.write("Item");
        writer.endElement("a");
        writer.endElement("li");
        writer.endElement("ul");
    }
}
