package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;

/**
 *
 * @author hfluz <hfluz@uel.br
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.min.css"),
    @ResourceDependency(library = "foundation", name = "js/jquery.min.js", target = "body"),
    @ResourceDependency(library = "foundation", name = "js/foundation.min.js", target = "body")
})
@FacesComponent(createTag = true, namespace = "http://foundation.faces.com/taglib", tagName = "switch")
public class SwitchUI extends HtmlSelectBooleanCheckbox {

    @Override
    public String getFamily() {
        return "org.foundation.faces";
    }

    @Override
    public String getRendererType() {
        return "SwitchRenderer";
    }
}
