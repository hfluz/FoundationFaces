package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 * It represents a {@link TabUI} content in displaced {@link TabsUI}
 *
 * @author hfluz
 * @since 0.0.2
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesComponent(value = "TabContent", tagName = "tabContent", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class TabContentUI extends UIComponentBase {

    enum PropertyKeys {

        target;
    }
    
    /**
     * Id of the {@link TabsUI} that will have its tabs content rendered by this
     * component.
     * @return 
     */
    public String getTarget() {
        return (String) getStateHelper().eval(PropertyKeys.target, null);
    }

    public void setTarget(String target) {
        getStateHelper().put(PropertyKeys.target, target);
    }

    @Override
    public String getFamily() {
        return "Tab";
    }

    @Override
    public String getRendererType() {
        return "TabContent";
    }
}
