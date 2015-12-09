package org.foundation.faces.components;

import java.io.IOException;
import java.util.StringJoiner;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlCommandButton;
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
        tagName = "commandButton")
public class CommandButtonUI extends HtmlCommandButton {

    enum PropertyKeys {
        sizing, expanded, coloring, hollow, disabled;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        this.setStyleClass(buildStyleClass());
        setDisabled(false);
        super.encodeBegin(context);
    }

    public String buildStyleClass() {
        StringJoiner styleClass = new StringJoiner(" ");
        styleClass.add("button");
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
        if (isHollow()) {
            styleClass.add("hollow");
        }

        if (isDisabled()) {
            styleClass.add("disabled");
        }
        return styleClass.toString();
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

    public Boolean isHollow() {
        return (Boolean) getStateHelper().eval(PropertyKeys.hollow, Boolean.FALSE);
    }

    public void setHollow(Boolean hollow) {
        getStateHelper().put(PropertyKeys.hollow, hollow);
    }
}
