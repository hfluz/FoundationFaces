package com.foundation.faces.component;

import javax.faces.component.UIPanel;

/**
 *
 * @author hfluz
 */
public class GridColumnUI extends UIPanel {

    private enum PropertyKeys {

        smallWidth, mediumWidth, largeWidth,
        smallOffset, mediumOffset, largeOffset,
        mediumUncentered, largeUncentered,
        smallCentered, mediumCentered, largeCentered,
        smallPush, mediumPush, largePush,
        smallPull, mediumPull, largePull,
        mediumResetOrder, largeResetOrder,
        end;
    }

    public String getSmallWidth() {
        return (String) getStateHelper().eval(PropertyKeys.smallWidth, null);
    }

    public void setSmallWidth(String smallWidth) {
        getStateHelper().put(PropertyKeys.smallWidth, smallWidth);
    }

    public String getMediumWidth() {
        return (String) getStateHelper().eval(PropertyKeys.mediumWidth, null);
    }

    public void setMediumWidth(String mediumWidth) {
        getStateHelper().put(PropertyKeys.mediumWidth, mediumWidth);
    }

    public String getLargeWidth() {
        return (String) getStateHelper().eval(PropertyKeys.largeWidth, null);
    }

    public void setLargeWidth(String largeWidth) {
        getStateHelper().put(PropertyKeys.largeWidth, largeWidth);
    }

    public String getSmallOffset() {
        return (String) getStateHelper().eval(PropertyKeys.smallOffset, null);
    }

    public void setSmallOffset(String smallOffset) {
        getStateHelper().put(PropertyKeys.smallOffset, smallOffset);
    }

    public String getMediumOffset() {
        return (String) getStateHelper().eval(PropertyKeys.mediumOffset, null);
    }

    public void setMediumOffset(String mediumOffset) {
        getStateHelper().put(PropertyKeys.mediumOffset, mediumOffset);
    }

    public String getLargeOffset() {
        return (String) getStateHelper().eval(PropertyKeys.largeOffset, null);
    }

    public void setLargeOffset(String largeOffset) {
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

    public String getSmallPush() {
        return (String) getStateHelper().eval(PropertyKeys.smallPush, null);
    }

    public void setSmallPush(String smallPush) {
        getStateHelper().put(PropertyKeys.smallPush, smallPush);
    }

    public String getMediumPush() {
        return (String) getStateHelper().eval(PropertyKeys.mediumPush, null);
    }

    public void setMediumPush(String mediumPush) {
        getStateHelper().put(PropertyKeys.mediumPush, mediumPush);
    }

    public String getLargePush() {
        return (String) getStateHelper().eval(PropertyKeys.largePush, null);
    }

    public void setLargePush(String largePush) {
        getStateHelper().put(PropertyKeys.largePush, largePush);
    }

    public String getSmallPull() {
        return (String) getStateHelper().eval(PropertyKeys.smallPull, null);
    }

    public void setSmallPull(String smallPull) {
        getStateHelper().put(PropertyKeys.smallPull, smallPull);
    }

    public String getMediumPull() {
        return (String) getStateHelper().eval(PropertyKeys.mediumPull, null);
    }

    public void setMediumPull(String mediumPull) {
        getStateHelper().put(PropertyKeys.mediumPull, mediumPull);
    }

    public String getLargePull() {
        return (String) getStateHelper().eval(PropertyKeys.largePull, null);
    }

    public void setLargePull(String largePull) {
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
}