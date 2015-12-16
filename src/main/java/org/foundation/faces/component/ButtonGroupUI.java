package org.foundation.faces.component;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author hfluz <hfluz@uel.br>
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation.min.css")
})
@FacesComponent(createTag = true, namespace = "http://foundation.faces.com/taglib",
        tagName = "buttonGroup")
public class ButtonGroupUI extends UIPanel {

    enum PropertyKeys {
        styleClass, sizing, expanded, coloring, stackedFor;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", this);
        String styleClass = buildStyleClass();
        if (getStyleClass() != null) {
            styleClass = getStyleClass() + " " + styleClass;
        }
        writer.writeAttribute("class", styleClass, "styleClass");
    }

    @Override
    public void encodeChildren(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        List<UIComponent> innerComponents = getChildren();
        for (UIComponent innerComponent : innerComponents) {
            if (innerComponent instanceof ButtonUI || innerComponent instanceof CommandButtonUI) {
                innerComponent.encodeEnd(context);
            }
        }
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement("div");
    }

    public String buildStyleClass() {
        StringJoiner styleClass = new StringJoiner(" ");
        styleClass.add("button-group");
        if (getStyleClass() != null) {
            styleClass.add(getStyleClass());
        }
        if (getSizing() != null && getSizing().matches("(.*)(tiny|small|normal|large)(.*)")) {
            styleClass.add(getSizing());
        }
        if (isExpanded()) {
            styleClass.add("expanded");
        }
        if (getColoring() != null && getColoring().matches("(.*)(secondary|success|alert|warning)(.*)")) {
            styleClass.add(getColoring());
        }
        if (getStackedFor() != null && getStackedFor().matches("(.*)(small|all)(.*)")) {
            styleClass.add(getColoring());
        }
        return styleClass.toString();
    }

    public String getStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.styleClass, null);
    }

    public void setStyleClass(String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }

    public String getSizing() {
        return (String) getStateHelper().eval(PropertyKeys.sizing, null);
    }

    public void setSizing(String sizing) {
        getStateHelper().put(PropertyKeys.sizing, sizing);
    }

    public Boolean isExpanded() {
        return (Boolean) getStateHelper().eval(PropertyKeys.expanded, Boolean.FALSE);
    }

    public void setExpanded(Boolean expanded) {
        getStateHelper().put(PropertyKeys.expanded, expanded);
    }

    public String getColoring() {
        return (String) getStateHelper().eval(PropertyKeys.coloring, null);
    }

    public void setColoring(String coloring) {
        getStateHelper().put(PropertyKeys.coloring, coloring);
    }

    public String getStackedFor() {
        return (String) getStateHelper().eval(PropertyKeys.stackedFor, null);
    }

    public void setStackedFor(String stackedFor) {
        getStateHelper().put(PropertyKeys.stackedFor, stackedFor);
    }

}
