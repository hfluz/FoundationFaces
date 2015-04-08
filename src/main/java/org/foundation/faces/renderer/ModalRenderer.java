package org.foundation.faces.renderer;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 * @since 0.0.2
 */
@FacesRenderer(componentFamily = "Modal", rendererType = "Modal")
public class ModalRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", component);
        writer.writeAttribute("zf-modal", "", null);
        writer.writeAttribute("id", component.getId(), null);
        writer.startElement("a", null);
        writer.writeAttribute("zf-close", "", null);
        writer.writeAttribute("class", "close-button", null);
        writer.write("x");
        writer.endElement("a");
        UIComponent header = component.getFacet("header");
        if(header != null){
            writer.startElement("h3", null);
            header.encodeAll(context);
            writer.endElement("h3");
        }
        UIComponent content = component.getFacet("content");
        if(content != null){
            writer.startElement("p", null);
            content.encodeAll(context);
            writer.endElement("p");
        }
        writer.endElement("div");
        
    }

//    @Override
//    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
//        super.encodeChildren(context, component); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
//        writer
    }

//    @Override
//    public boolean getRendersChildren() {
//        return true;
//    }
}
