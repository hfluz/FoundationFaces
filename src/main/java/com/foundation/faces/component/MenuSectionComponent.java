package com.foundation.faces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
@FacesComponent("MenuSection")
public class MenuSectionComponent extends UIPanel {
    private enum PropertyKeys{
        alignment;
    }
    
    public String getAlignment() {
        return (String) getStateHelper().eval(PropertyKeys.alignment, null);
    }

    public void setAlignment(String alignment) {
        getStateHelper().put(PropertyKeys.alignment, alignment);
    }
}
