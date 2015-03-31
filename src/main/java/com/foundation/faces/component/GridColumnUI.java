package com.foundation.faces.component;

import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
public class GridColumnUI extends UIPanel {

    private enum PropertyKeys {

        style, styleClass,
        smallWidth, mediumWidth, largeWidth,
        smallOffset, mediumOffset, largeOffset,
        mediumUncentered, largeUncentered,
        smallCentered, mediumCentered, largeCentered,
        smallPush, mediumPush, largePush,
        smallPull, mediumPull, largePull,
        mediumResetOrder, largeResetOrder,
        end;
    }

    public Integer getSmallWidth() {
        return (Integer) getStateHelper().eval(PropertyKeys.smallWidth, null);
    }

    public void setSmallWidth(Integer smallWidth) {
        getStateHelper().put(PropertyKeys.smallWidth, smallWidth);
    }

    public Integer getMediumWidth() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumWidth, null);
    }

    public void setMediumWidth(Integer mediumWidth) {
        getStateHelper().put(PropertyKeys.mediumWidth, mediumWidth);
    }

    public Integer getLargeWidth() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeWidth, null);
    }

    public void setLargeWidth(Integer largeWidth) {
        getStateHelper().put(PropertyKeys.largeWidth, largeWidth);
    }

    public Integer getSmallOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.smallOffset, null);
    }

    public void setSmallOffset(Integer smallOffset) {
        getStateHelper().put(PropertyKeys.smallOffset, smallOffset);
    }

    public Integer getMediumOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumOffset, null);
    }

    public void setMediumOffset(Integer mediumOffset) {
        getStateHelper().put(PropertyKeys.mediumOffset, mediumOffset);
    }

    public Integer getLargeOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeOffset, null);
    }

    public void setLargeOffset(Integer largeOffset) {
        getStateHelper().put(PropertyKeys.largeOffset, largeOffset);
    }

    public Boolean getMediumUncentered() {
        Boolean mediumUncentered = (Boolean) getStateHelper().eval(PropertyKeys.mediumUncentered, null);
        return mediumUncentered != null ? mediumUncentered : Boolean.FALSE;
    }

    public void setMediumUncentered(Boolean mediumUncentered) {
        getStateHelper().put(PropertyKeys.mediumUncentered, mediumUncentered);
    }

    public Boolean getLargeUncentered() {
        Boolean largeUncentered = (Boolean) getStateHelper().eval(PropertyKeys.largeUncentered, null);
        return largeUncentered != null ? largeUncentered : Boolean.FALSE;
    }

    public void setLargeUncentered(Boolean largeUncentered) {
        getStateHelper().put(PropertyKeys.largeUncentered, largeUncentered);
    }

    public Boolean getSmallCentered() {
        Boolean smallCentered = (Boolean) getStateHelper().eval(PropertyKeys.smallCentered, null);
        return smallCentered != null ? smallCentered : Boolean.FALSE;
    }

    public void setSmallCentered(Boolean smallCentered) {
        getStateHelper().put(PropertyKeys.smallCentered, smallCentered);
    }

    public Boolean getMediumCentered() {
        Boolean mediumCentered = (Boolean) getStateHelper().eval(PropertyKeys.mediumCentered, null);
        return mediumCentered != null ? mediumCentered : Boolean.FALSE;
    }

    public void setMediumCentered(Boolean mediumCentered) {
        getStateHelper().put(PropertyKeys.mediumCentered, mediumCentered);
    }

    public Boolean getLargeCentered() {
        Boolean largeCentered = (Boolean) getStateHelper().eval(PropertyKeys.largeCentered, null);
        return largeCentered != null ? largeCentered : Boolean.FALSE;
    }

    public void setLargeCentered(Boolean largeCentered) {
        getStateHelper().put(PropertyKeys.largeCentered, largeCentered);
    }

    public Integer getSmallPush() {
        return (Integer) getStateHelper().eval(PropertyKeys.smallPush, null);
    }

    public void setSmallPush(Integer smallPush) {
        getStateHelper().put(PropertyKeys.smallPush, smallPush);
    }

    public Integer getMediumPush() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumPush, null);
    }

    public void setMediumPush(Integer mediumPush) {
        getStateHelper().put(PropertyKeys.mediumPush, mediumPush);
    }

    public Integer getLargePush() {
        return (Integer) getStateHelper().eval(PropertyKeys.largePush, null);
    }

    public void setLargePush(Integer largePush) {
        getStateHelper().put(PropertyKeys.largePush, largePush);
    }

    public Integer getSmallPull() {
        return (Integer) getStateHelper().eval(PropertyKeys.smallPull, null);
    }

    public void setSmallPull(Integer smallPull) {
        getStateHelper().put(PropertyKeys.smallPull, smallPull);
    }

    public Integer getMediumPull() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumPull, null);
    }

    public void setMediumPull(Integer mediumPull) {
        getStateHelper().put(PropertyKeys.mediumPull, mediumPull);
    }

    public Integer getLargePull() {
        return (Integer) getStateHelper().eval(PropertyKeys.largePull, null);
    }

    public void setLargePull(Integer largePull) {
        getStateHelper().put(PropertyKeys.largePull, largePull);
    }

    public Boolean getMediumResetOrder() {
        Boolean mediumResetOrder = (Boolean) getStateHelper().eval(PropertyKeys.mediumResetOrder, null);
        return mediumResetOrder != null ? mediumResetOrder : Boolean.FALSE;
    }

    public void setMediumResetOrder(Boolean mediumResetOrder) {
        getStateHelper().put(PropertyKeys.mediumResetOrder, mediumResetOrder);
    }

    public Boolean getLargeResetOrder() {
        Boolean largeResetOrder = (Boolean) getStateHelper().eval(PropertyKeys.largeResetOrder, null);
        return largeResetOrder != null ? largeResetOrder : Boolean.FALSE;
    }

    public void setLargeResetOrder(Boolean largeResetOrder) {
        getStateHelper().put(PropertyKeys.largeResetOrder, largeResetOrder);
    }

    public Boolean getEnd() {
        Boolean end = (Boolean) getStateHelper().eval(PropertyKeys.end, null);
        return end != null ? end : Boolean.FALSE;
    }

    public void setEnd(Boolean end) {
        getStateHelper().put(PropertyKeys.end, end);
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
}