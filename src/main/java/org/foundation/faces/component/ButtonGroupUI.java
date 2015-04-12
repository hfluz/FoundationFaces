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
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css")
})
@FacesComponent(value = "ButtonGroup", tagName = "buttonGroup", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class ButtonGroupUI extends UIPanel {

    private enum PropertyKeys {

        buttonType, size, style, styleClass;
    }

    /**
     * Type of style applied to nested buttons. Possible values are:
     * <ul>
     * <li>'primary'</li>
     * <li>'secondary'</li>
     * <li>'success'</li>
     * <li>'alert'</li>
     * <li>'warning'</li>
     * <li>'info'</li>
     * <li>'dark'</li>
     * </ul>
     * Default is 'primary'.
     *
     * @return
     */
    public String getButtonType() {
        return (String) getStateHelper().eval(PropertyKeys.buttonType, null);
    }
    
    public void setButtonType(String buttonType) {
        getStateHelper().put(PropertyKeys.buttonType, buttonType);
    }
    
    /**
     * Size applied to button group. Possible values are:
     * <ul>
     * <li>'tiny'</li>
     * <li>'small'</li>
     * <li>'default'</li>
     * <li>'large'</li>
     * <li>'expand'</li>
     * </ul>
     * @return 
     */
    public String getSize() {
        return (String) getStateHelper().eval(PropertyKeys.size, null);
    }

    public void setSize(String size) {
        getStateHelper().put(PropertyKeys.size, size);
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
