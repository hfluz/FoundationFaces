package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Allows you to create a series of vertical tabs containing various content.
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "js/angular.min.js"),
    @ResourceDependency(library = "foundation", name = "js/foundation-apps.min.js"),
    @ResourceDependency(library = "foundation", name = "js/accordion/accordion.js")
})
@FacesComponent(value = "Accordion", tagName = "accordion", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class AccordionUI extends UIPanel {

    enum PropertyKeys {

        autoOpen, collapsible, multiOpen,
        style, styleClass;
    }

    /**
     * Auto open opens the first tab on render. Defaults to "true".
     *
     * @return
     */
    public Boolean getAutoOpen() {
        Boolean autoOpen = (Boolean) getStateHelper().eval(PropertyKeys.autoOpen, null);
        return autoOpen != null ? autoOpen : Boolean.FALSE;
    }

    public void setAutoOpen(Boolean autoOpen) {
        getStateHelper().put(PropertyKeys.autoOpen, autoOpen);
    }

    /**
     * Collapsible allows toggable tabs. Click on a tab to open or close it.
     * Defaults to "false"
     *
     * @return
     */
    public Boolean getCollapsible() {
        Boolean collapsible = (Boolean) getStateHelper().eval(PropertyKeys.collapsible, null);
        return collapsible != null ? collapsible : Boolean.FALSE;
    }

    public void setCollapsible(Boolean collapsible) {
        getStateHelper().put(PropertyKeys.collapsible, collapsible);
    }

    /**
     * Multi open allows for multiple tabs to be open at once. Defaults to
     * "false". When true, it forces collapsible to be "true" as well. It cannot
     * be overriden.
     *
     * @return
     */
    public Boolean getMultiOpen() {
        Boolean multiOpen = (Boolean) getStateHelper().eval(PropertyKeys.multiOpen, null);
        return multiOpen != null ? multiOpen : Boolean.FALSE;
    }

    public void setMultiOpen(Boolean multiOpen) {
        getStateHelper().put(PropertyKeys.multiOpen, multiOpen);
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
        return "Accordion";
    }
}
