package org.foundation.faces.component;

import com.sun.faces.renderkit.html_basic.HtmlBasicInputRenderer;
import java.io.IOException;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz <hfluz@uel.br
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.min.css"),
    @ResourceDependency(library = "foundation", name = "js/jquery.min.js", target = "body"),
    @ResourceDependency(library = "foundation", name = "js/foundation.min.js", target = "body")
})
@FacesComponent(createTag = true, namespace = "http://foundation.faces.com/taglib", tagName = "slider")
public class SliderUI extends UIInput {

    enum PropertyKeys {
        styleClass, initialStart, initialEnd, start, end, clickSelect, draggable, doubleSided, decimal, moveTime, vertical, disabled;
    }

    @Override
    public String getFamily() {
        return "org.foundation.faces";
    }

    @Override
    public String getRendererType() {
        return "SliderRenderer";
    }
}
