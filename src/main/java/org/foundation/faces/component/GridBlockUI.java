package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * Blocks are the... building blocks of apps in Foundation for Apps. They're
 * flexbox-powered elements that can be intelligently sized, re-oriented, and
 * re-ordered. Blocks are most analagous to rows in Foundation 5, but there's
 * much more to them than that. to row from Foundation 5.
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesComponent(value="GridBlock", tagName = "gridBlock", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class GridBlockUI extends UIPanel {

    enum PropertyKeys {

        shrink, wrap, alignment,
        vertical, mediumHorizontal, largeHorizontal,
        size, mediumSize, largeSize,
        order, mediumOrder, largeOrder,
        offset, mediumOffset, largeOffset,
        childrenSize, mediumChildrenSize, largeChildrenSize,
        container, containerAlignment,
        style, styleClass;
    }

    /**
     * If true means it only takes up as much space as its content needs.
     * Default is false.
     *
     * @return
     */
    public Boolean getShrink() {
        Boolean shrink = (Boolean) getStateHelper().eval(PropertyKeys.shrink, null);
        return shrink != null ? shrink : Boolean.FALSE;
    }

    public void setShrink(Boolean shrink) {
        getStateHelper().put(PropertyKeys.shrink, shrink);
    }

    /**
     * By default, every block in a grid will try to fit on the same line—this
     * is how Flexbox works. However, you can also force grid items to wrap when
     * they take up too much space by adding the class `wrap` to the parent
     * block. In the below example, the four child blocks will display on two
     * rows, two per row:
     *
     * {@code
     * <fo:gridBlock wrap="true">
     *   <fo:gridBlock smallSize="6"/>
     *   <fo:gridBlock smallSize="6"/>
     *   <fo:gridBlock smallSize="6"/>
     *   <fo:gridBlock smallSize="6"/>
     * </fo:gridBlock>
     * }
     *
     * @return
     */
    public Boolean getWrap() {
        Boolean wrap = (Boolean) getStateHelper().eval(PropertyKeys.wrap, null);
        return wrap != null ? wrap : Boolean.FALSE;
    }

    public void setWrap(Boolean wrap) {
        getStateHelper().put(PropertyKeys.wrap, wrap);
    }

    /**
     * By default, all blocks in a grid align to the left of a grid, or the top
     * if the grid is vertical.
     *
     * These are the allowed values:
     * <ul>
     * <li>'left': blocks clump together on the left. This is the default.
     * <li>'right': blocks clump together on the right.
     * <li>'center': blocks clump together in the middle.
     * <li>'justify': blocks spread out so that the space between each one is
     * the same.
     * <li>'spaced': locks spread out so that the space around each one is the
     * same.
     * </ul>
     *
     * @return
     */
    public String getAlignment() {
        return (String) getStateHelper().eval(PropertyKeys.alignment, null);
    }

    public void setAlignment(String alignment) {
        getStateHelper().put(PropertyKeys.alignment, alignment);
    }

    /**
     * If true reorients the grid to lay out the inner gridBlocks vertically.
     * Default is false, which means default orientation is horizontal.
     *
     * This behavior doesn't cascade down to child blocks—they'll be horizontal
     * by default also.
     *
     * @return
     */
    public Boolean getVertical() {
        Boolean vertical = (Boolean) getStateHelper().eval(PropertyKeys.vertical, null);
        return vertical != null ? vertical : Boolean.FALSE;
    }

    public void setVertical(Boolean vertical) {
        getStateHelper().put(PropertyKeys.shrink, vertical);
    }

    /**
     * If true, it overwrites the vertical property for medium screen size and
     * reorient the grid horizontally.
     *
     * @return
     */
    public Boolean getMediumHorizontal() {
        Boolean mediumHorizontal = (Boolean) getStateHelper().eval(PropertyKeys.mediumHorizontal, null);
        return mediumHorizontal != null ? mediumHorizontal : Boolean.FALSE;
    }

    public void setMediumHorizontal(Boolean mediumHorizontal) {
        getStateHelper().put(PropertyKeys.mediumHorizontal, mediumHorizontal);
    }

    /**
     * If true, it overwrites the vertical property for large screen size and
     * reorient the grid horizontally.
     *
     * @return
     */
    public Boolean getLargeHorizontal() {
        Boolean largeHorizontal = (Boolean) getStateHelper().eval(PropertyKeys.largeHorizontal, null);
        return largeHorizontal != null ? largeHorizontal : Boolean.FALSE;
    }

    public void setLargeHorizontal(Boolean largeHorizontal) {
        getStateHelper().put(PropertyKeys.largeHorizontal, largeHorizontal);
    }

    /**
     * Size of the grid using a 12-column-based grid. This value can be
     * overwritten by medium and large size properties.
     *
     * @return
     */
    public Integer getSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.size, null);
    }

    public void setSize(Integer size) {
        getStateHelper().put(PropertyKeys.size, size);
    }

    /**
     * Size of the grid using a 12-column-based grid. This value overwrites the
     * size property and can be overwritten by large size one.
     *
     * @return
     */
    public Integer getMediumSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumSize, null);
    }

    public void setMediumSize(Integer mediumSize) {
        getStateHelper().put(PropertyKeys.mediumSize, mediumSize);
    }

    /**
     * Size of the grid using a 12-column-based grid. The large size value
     * overwrites the small and medium size ones.
     *
     * @return
     */
    public Integer getLargeSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeSize, null);
    }

    public void setLargeSize(Integer largeSize) {
        getStateHelper().put(PropertyKeys.largeSize, largeSize);
    }

    /**
     * Set the order in which this block will appear in the page. So if this
     * value is '2', it will appear after a grid with order value '1' and before
     * one with value '3'.
     *
     * @return
     */
    public Integer getOrder() {
        return (Integer) getStateHelper().eval(PropertyKeys.order, null);
    }

    public void setOrder(Integer order) {
        getStateHelper().put(PropertyKeys.order, order);
    }

    /**
     * It overwrites order property for medium screen size.
     *
     * @return
     */
    public Integer getMediumOrder() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumOrder, null);
    }

    public void setMediumOrder(Integer mediumOrder) {
        getStateHelper().put(PropertyKeys.mediumOrder, mediumOrder);
    }

    /**
     * It overwrites order and mediumOrder properties for large screen size.
     *
     * @return
     */
    public Integer getLargeOrder() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeOrder, null);
    }

    public void setLargeOrder(Integer largeOrder) {
        getStateHelper().put(PropertyKeys.largeOrder, largeOrder);
    }

    public Integer getOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.offset, null);
    }

    /**
     * It creates a left margin on this block in a 12-column grid.
     * @param offset 
     */
    public void setOffset(Integer offset) {
        getStateHelper().put(PropertyKeys.offset, offset);
    }

    /**
     * It overwrites offset property for medium screen size.
     *
     * @return
     */
    public Integer getMediumOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumOffset, null);
    }

    public void setMediumOffset(Integer mediumOffset) {
        getStateHelper().put(PropertyKeys.mediumOffset, mediumOffset);
    }

    /**
     * It overwrites offset and mediumOffset properties for large screen size.
     *
     * @return
     */
    public Integer getLargeOffset() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeOffset, null);
    }

    public void setLargeOffset(Integer largeOffset) {
        getStateHelper().put(PropertyKeys.largeOffset, largeOffset);
    }
    
    /**
     * Default size applied to any inner grid blocks.
     *
     * @return
     */
    public Integer getChildrenSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.childrenSize, null);
    }

    public void setChildrenSize(Integer childrenSize) {
        getStateHelper().put(PropertyKeys.childrenSize, childrenSize);
    }

    /**
     * Default medium size applied to any inner grid blocks.
     *
     * @return
     */
    public Integer getMediumChildrenSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.mediumChildrenSize, null);
    }

    public void setMediumChildrenSize(Integer mediumChildrenSize) {
        getStateHelper().put(PropertyKeys.mediumChildrenSize, mediumChildrenSize);
    }

    /**
     * Default large size applied to any inner grid blocks.
     *
     * @return
     */
    public Integer getLargeChildrenSize() {
        return (Integer) getStateHelper().eval(PropertyKeys.largeChildrenSize, null);
    }

    public void setLargeChildrenSize(Integer largeChildrenSize) {
        getStateHelper().put(PropertyKeys.largeChildrenSize, largeChildrenSize);
    }

    /**
     * If true, it wraps the grid's content in a container with a maximum width.
     *
     * By default, the container aligns to the center of the gridBlock it's
     * inside. The alignment can be changed to left or right through
     * {@link #setContainerAlignment(String)}
     *
     * @return
     */
    public Boolean getContainer() {
        Boolean container = (Boolean) getStateHelper().eval(PropertyKeys.container, null);
        return container != null ? container : Boolean.FALSE;
    }

    public void setContainer(Boolean container) {
        getStateHelper().put(PropertyKeys.container, container);
    }

    /**
     * It aligns the container if that property is true. Allowed values are
     * 'left' and 'right'. Default alignment is center.
     *
     * @return
     */
    public String getContainerAlignment() {
        return (String) getStateHelper().eval(PropertyKeys.containerAlignment, null);
    }

    public void setContainerAlignment(String containerAlignment) {
        getStateHelper().put(PropertyKeys.containerAlignment, containerAlignment);
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

    @Override
    public String getFamily() {
        return "Grid";
    }

    @Override
    public String getRendererType() {
        return "GridBlock";
    }
}
