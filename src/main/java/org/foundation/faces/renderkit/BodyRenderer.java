package org.foundation.faces.renderkit;

import java.io.IOException;
import java.util.Set;
import java.util.StringJoiner;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.foundation.faces.util.ComponentUtil;

/**
 * Extension of the default JSF body renderer to add the javascript that execute
 * the angular modules used by some of foundation components.
 *
 * @author hfluz
 * @since 0.0.1
 */
public class BodyRenderer extends com.sun.faces.renderkit.html_basic.BodyRenderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ComponentUtil util = new ComponentUtil();
        Set<String> usedAngularModules = util.checkWhichAngularModulesAreUsed(component.getChildren());
        if (usedAngularModules != null && !usedAngularModules.isEmpty()) {
            ResponseWriter writer = context.getResponseWriter();
            writer.startElement("script", null);
            writer.writeAttribute("type", "text/javascript", null);
            writer.write("angular.bootstrap(document,[");
            StringJoiner modules = new StringJoiner(",");
            if (usedAngularModules.contains("accordion")) {
                modules.add("'foundation.accordion'");
            }
            if (usedAngularModules.contains("tabs")) {
                modules.add("'foundation.tabs'");
            }
            writer.write(modules.toString());
            writer.write("]);");
            writer.endElement("script");
        }
        super.encodeEnd(context, component);
    }

}
