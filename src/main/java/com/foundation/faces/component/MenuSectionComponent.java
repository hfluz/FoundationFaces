/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.component;

import java.util.List;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
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
