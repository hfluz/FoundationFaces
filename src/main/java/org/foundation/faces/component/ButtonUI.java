package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;

/**
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css")
})
@FacesComponent(value = "Button", tagName = "button", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class ButtonUI extends UICommand {

    private enum PropertyKeys {

        active, href, type, size, disabled, hollow, corner, style, styleClass;
    }

    public Boolean getActive() {
        Boolean active = (Boolean) getStateHelper().eval(PropertyKeys.active, null);
        return active != null ? active : Boolean.FALSE;
    }

    public void setActive(Boolean active) {
        getStateHelper().put(PropertyKeys.active, active);
    }

    public String getHref() {
        return (String) getStateHelper().eval(PropertyKeys.href, null);
    }

    public void setHref(String href) {
        getStateHelper().put(PropertyKeys.href, href);
    }

    /**
     * Type of style applied to button. Possible values are:
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
    public String getType() {
        return (String) getStateHelper().eval(PropertyKeys.type, null);
    }

    public void setType(String type) {
        getStateHelper().put(PropertyKeys.type, type);
    }

    /**
     * Button size. Possible values are:
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

    /**
     * It disable the hover state and add a faded appearance.
     *
     * @return
     */
    public Boolean isDisabled() {
        Boolean disabled = (Boolean) getStateHelper().eval(PropertyKeys.disabled, null);
        return disabled != null ? disabled : Boolean.FALSE;
    }

    public void setDisabled(Boolean disabled) {
        getStateHelper().put(PropertyKeys.disabled, disabled);
    }

    /**
     * If true, button background gets empty and color is applied to border and
     * label. Default is false.
     *
     * @return
     */
    public Boolean isHollow() {
        Boolean hollow = (Boolean) getStateHelper().eval(PropertyKeys.hollow, null);
        return hollow != null ? hollow : Boolean.FALSE;
    }

    public void setHollow(Boolean hollow) {
        getStateHelper().put(PropertyKeys.hollow, hollow);
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
        return "Button";
    }
}
