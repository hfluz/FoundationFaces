package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 * @since 0.0.2
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "js/angular.js"),
    @ResourceDependency(library = "foundation", name = "js/foundation-apps.min.js"),
    @ResourceDependency(library = "foundation", name = "js/foundation.core.animation.js"),
    @ResourceDependency(library = "foundation", name = "js/foundation.core.js"),
    @ResourceDependency(library = "foundation", name = "js/common.js"),
    @ResourceDependency(library = "foundation", name = "js/components/modal.js")
})
@FacesComponent(value = "Modal", tagName = "modal", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class ModalUI extends UIPanel {

    @Override
    public String getFamily() {
        return "Modal";
    }

    @Override
    public String getRendererType() {
        return "Modal";
    }
}
