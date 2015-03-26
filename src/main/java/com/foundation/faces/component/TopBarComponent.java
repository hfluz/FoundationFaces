package com.foundation.faces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
@FacesComponent("TopBar")
public class TopBarComponent extends UIPanel {
    private enum PropertyKeys {
        home, homeLink, style, styleClass, fixed, containToGrid, sticky;
    }
    
    public String getHome() {
        return (String) getStateHelper().eval(PropertyKeys.home, null);
    }

    public void setHome(String home) {
        getStateHelper().put(PropertyKeys.home, home);
    }
    
    public String getHomeLink() {
        return (String) getStateHelper().eval(PropertyKeys.homeLink, null);
    }

    public void setHomeLink(String homeLink) {
        getStateHelper().put(PropertyKeys.homeLink, homeLink);
    }
    
    public Boolean isFixed() {
        Boolean fixed = (Boolean) getStateHelper().eval(PropertyKeys.fixed, null);
        return fixed != null ? fixed : Boolean.FALSE;
    }

    public void setFixed(Boolean fixed) {
        getStateHelper().put(PropertyKeys.fixed, fixed);
    }
    
    public Boolean isContainToGrid() {
        Boolean containToGrid = (Boolean) getStateHelper().eval(PropertyKeys.containToGrid, null);
        return containToGrid != null ? containToGrid : Boolean.FALSE;
    }

    public void setContainToGrid(Boolean containToGrid) {
        getStateHelper().put(PropertyKeys.containToGrid, containToGrid);
    }
    
    public Boolean isSticky() {
        Boolean sticky = (Boolean) getStateHelper().eval(PropertyKeys.sticky, null);
        return sticky != null ? sticky : Boolean.FALSE;
    }

    public void setSticky(Boolean sticky) {
        getStateHelper().put(PropertyKeys.sticky, sticky);
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
        return "Menu";
    }
}
