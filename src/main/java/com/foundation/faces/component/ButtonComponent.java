package com.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;

/**
 *
 * @author hfluz
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.css"),
})
@FacesComponent("Button")
public class ButtonComponent extends UICommand {

    private enum PropertyKeys {

        href, size, disabled, corner, style, styleClass;
    }
    
    public String getHref() {
        return (String) getStateHelper().eval(PropertyKeys.href, null);
    }

    public void setHref(String href) {
        getStateHelper().put(PropertyKeys.href, href);
    }
    
    public String getSize() {
        return (String) getStateHelper().eval(PropertyKeys.size, null);
    }

    public void setSize(String size) {
        getStateHelper().put(PropertyKeys.size, size);
    }
    
    public Boolean isDisabled() {
        return (Boolean) getStateHelper().eval(PropertyKeys.disabled, null);
    }

    public void setDisabled(Boolean disabled) {
        getStateHelper().put(PropertyKeys.disabled, disabled);
    }
    
    public String getCorner() {
        return (String) getStateHelper().eval(PropertyKeys.corner, null);
    }

    public void setCorner(String corner) {
        getStateHelper().put(PropertyKeys.corner, corner);
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
        return "Button";
    }
}
