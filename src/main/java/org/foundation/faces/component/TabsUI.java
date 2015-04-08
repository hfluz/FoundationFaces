package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "js/angular.min.js"),
    @ResourceDependency(library = "foundation", name = "js/foundation-apps.min.js"),
    @ResourceDependency(library = "foundation", name = "js/components/tabs.js")
})
@FacesComponent(value = "Tabs", tagName = "tabs", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class TabsUI extends UIPanel {
    @Override
    public String getFamily() {
        return "Tab";
    }

    @Override
    public String getRendererType() {
        return "Tabs";
    }
}
