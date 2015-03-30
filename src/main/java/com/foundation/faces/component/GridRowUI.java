package com.foundation.faces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
@FacesComponent("GridRow")
public class GridRowUI extends UIPanel {

    private enum PropertyKeys {

        style, styleClass,
        smallUncollapse, mediumUncollapse, largeUncollapse,
        mediumCollapse, largeCollapse,;
    }
    
    public Boolean getSmallUncollapse() {
        Boolean smallUncollapse = (Boolean) getStateHelper().eval(PropertyKeys.smallUncollapse, null);
        return smallUncollapse != null ? smallUncollapse : Boolean.FALSE;
    }

    public void setSmallUncollapse(Boolean smallUncollapse) {
        getStateHelper().put(PropertyKeys.smallUncollapse, smallUncollapse);
    }
    
    public Boolean getMediumUncollapse() {
        Boolean mediumUncollapse = (Boolean) getStateHelper().eval(PropertyKeys.mediumUncollapse, null);
        return mediumUncollapse != null ? mediumUncollapse : Boolean.FALSE;
    }

    public void setMediumUncollapse(Boolean mediumUncollapse) {
        getStateHelper().put(PropertyKeys.mediumUncollapse, mediumUncollapse);
    }
    
    public Boolean getLargeUncollapse() {
        Boolean largeUncollapse = (Boolean) getStateHelper().eval(PropertyKeys.largeUncollapse, null);
        return largeUncollapse != null ? largeUncollapse : Boolean.FALSE;
    }

    public void setLargeUncollapse(Boolean largeUncollapse) {
        getStateHelper().put(PropertyKeys.largeUncollapse, largeUncollapse);
    }
    
    public Boolean getMediumCollapse() {
        Boolean mediumCollapse = (Boolean) getStateHelper().eval(PropertyKeys.mediumCollapse, null);
        return mediumCollapse != null ? mediumCollapse : Boolean.FALSE;
    }

    public void setMediumCollapse(Boolean mediumCollapse) {
        getStateHelper().put(PropertyKeys.mediumCollapse, mediumCollapse);
    }
    
    public Boolean getLargeCollapse() {
        Boolean largeCollapse = (Boolean) getStateHelper().eval(PropertyKeys.largeCollapse, null);
        return largeCollapse != null ? largeCollapse : Boolean.FALSE;
    }

    public void setLargeCollapse(Boolean largeCollapse) {
        getStateHelper().put(PropertyKeys.largeCollapse, largeCollapse);
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
        return "GridRow";
    }

    @Override
    public String getRendererType() {
        return "GridRow";
    }
}