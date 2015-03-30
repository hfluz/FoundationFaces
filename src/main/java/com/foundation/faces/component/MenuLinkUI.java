/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;

/**
 *
 * @author hfluz
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.css"),})
@FacesComponent("MenuLink")
public class MenuLinkUI extends ButtonBarUI {

}
