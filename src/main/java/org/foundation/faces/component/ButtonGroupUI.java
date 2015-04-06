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
    @ResourceDependency(library = "foundation", name = "css/foundation.css"),
})
@FacesComponent("ButtonGroup")
public class ButtonGroupUI extends UIPanel {

    private enum PropertyKeys {

        stackEnabled, stackType, even, corner, style, styleClass;
    }

    public Boolean isStackEnabled() {
        return (Boolean) getStateHelper().eval(PropertyKeys.stackEnabled, null);
    }

    public void setStackEnabled(Boolean stackEnabled) {
        getStateHelper().put(PropertyKeys.stackEnabled, stackEnabled);
    }

    public String getStackType() {
        return (String) getStateHelper().eval(PropertyKeys.stackType, null);
    }

    public void setStackType(String stackType) {
        getStateHelper().put(PropertyKeys.stackType, stackType);
    }

    public String getEven() {
        return (String) getStateHelper().eval(PropertyKeys.even, null);
    }

    public void setEven(String even) {
        getStateHelper().put(PropertyKeys.even, even);
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
    
    @Override
    public String getRendererType() {
        return "ButtonGroup";
    }
}
