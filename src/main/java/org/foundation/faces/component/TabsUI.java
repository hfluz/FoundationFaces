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
    enum PropertyKeys{
        displaced, style, styleClass;
    }
    
    /**
     * It renders the tab content separated from the tabs. In this case
     * a {@link TabContentUI} which will display the content must target 
     * this component.
     *
     * @return
     */
    public Boolean getDisplaced() {
        Boolean displaced = (Boolean) getStateHelper().eval(PropertyKeys.displaced, null);
        return displaced != null ? displaced : Boolean.FALSE;
    }

    public void setDisplaced(Boolean displaced) {
        getStateHelper().put(PropertyKeys.displaced, displaced);
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
        return "Tab";
    }

    @Override
    public String getRendererType() {
        return "Tabs";
    }
}
