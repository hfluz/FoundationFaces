package org.foundation.faces.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.component.UIComponent;
import org.foundation.faces.component.AccordionUI;
import org.foundation.faces.component.ModalUI;
import org.foundation.faces.component.TabsUI;

/**
 * 
 * @author hfluz
 * @since 0.0.1
 */
public class ComponentUtil {

    private Set<String> angularModules;

    public ComponentUtil() {
        angularModules = new HashSet<>();
    }

    public Set<String> checkWhichAngularModulesAreUsed(List<UIComponent> components) {
        for (UIComponent component : components) {
            if (!angularModules.contains("accordion") &&  component instanceof AccordionUI) {
                angularModules.add("accordion");
            }
            if (!angularModules.contains("tabs") &&  component instanceof TabsUI) {
                angularModules.add("tabs");
            }
            if (!angularModules.contains("modal") &&  component instanceof ModalUI) {
                angularModules.add("modal");
            }
            if (angularModules.size() < 1 && component.getChildren() != null && !component.getChildren().isEmpty()) {
                checkWhichAngularModulesAreUsed(component.getChildren());
            }
        }
        return angularModules;
    }

//   public Set<String> search()
}
