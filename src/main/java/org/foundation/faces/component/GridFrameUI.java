package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * A frame is a layout object that lives above all others, and is 100% of the
 * width and height of the screen you're on. This allows you to carve the screen
 * up into areas that are independently scrollable.
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesComponent(value="GridFrame", tagName = "gridFrame", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class GridFrameUI extends UIPanel {

    enum PropertyKeys {

        style, styleClass;
    }
    
    public String getStyle() {
        return (String) getStateHelper().eval(PropertyKeys.style, null);
    }

    public void setStyle(String style) {
        getStateHelper().put(PropertyKeys.style, style);
    }
    
    public String getStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.styleClass, null);
    }

    public void setStyleClass(String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }

    @Override
    public String getFamily() {
        return "Grid";
    }

    @Override
    public String getRendererType() {
        return "GridFrame";
    }
}
