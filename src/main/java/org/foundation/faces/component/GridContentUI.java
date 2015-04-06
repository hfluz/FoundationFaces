package org.foundation.faces.component;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;

/**
 * If basic blocks are the rows of a Foundation for Apps layout, then content
 * blocks are the columns. They can be sized and re-ordered just like normal
 * blocks, but they're meant to house actual content, not just more blocks.
 *
 * {@code
 * <fo:gridBlock>
 *   <fo:gridBlock>
 *     <fo:gridContent>
 *       <!-- content -->
 *     </fo:gridContent>
 *     <fo:gridContent>
 *       <!-- content -->
 *     </fo:gridContent>
 *   </fo:gridBlock>
 *   <fo:gridContent>
 *     <!-- content -->
 *   </fo:gridContent>
 * </fo:gridBlock>
 * }
 *
 * In the above example, you can see that `gridContent` elements are the
 * bottommost elements of the basic layout. Use `gridBlock` when you intend to
 * keep nesting more blocks for your layout, and use `gridContent` when you're
 * filling the element with "normal" content, like lists, text, tabs, or menus.
 *
 * @author hfluz
 * @since 0.0.1
 */
@ResourceDependencies({
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.css"),
    @ResourceDependency(library = "foundation", name = "css/foundation-apps.min.js")
})
@FacesComponent(value="GridContent", tagName = "gridContent", createTag = true, namespace = "http://foundation.faces.com/taglib")
public class GridContentUI extends UIPanel {

    enum PropertyKeys {

        style, styleClass;
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
        return "GridContent";
    }
}
