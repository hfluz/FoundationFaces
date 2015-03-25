/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;
import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.css"),
    @ResourceDependency(library = "foundation", name = "js/foundation.min.js")
})
@FacesComponent("SplitButton")
public class SplitButtonComponent extends ButtonComponent {
}
