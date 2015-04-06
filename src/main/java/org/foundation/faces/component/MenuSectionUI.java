package org.foundation.faces.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 * @since 0.0.1
 */
@FacesComponent("MenuSection")
public class MenuSectionUI extends UIPanel {
    private enum PropertyKeys{
        alignment;
    }
    
    public String getAlignment() {
        return (String) getStateHelper().eval(PropertyKeys.alignment, null);
    }

    public void setAlignment(String alignment) {
        getStateHelper().put(PropertyKeys.alignment, alignment);
    }
    
    @Override
    public String getRendererType() {
        return "MenuSection";
    }
}
