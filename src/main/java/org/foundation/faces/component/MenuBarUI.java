package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Menu bar gives you the ability to switch between different subtasks, views,
 * or modes in an app. It can be used vertically or horizontally.
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesComponent(value="MenuBar", tagName = "menuBar", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class MenuBarUI extends UIPanel {

    @Override
    public String getFamily() {
        return "Menu";
    }

    @Override
    public String getRendererType() {
        return "MenuBar";
    }
}
