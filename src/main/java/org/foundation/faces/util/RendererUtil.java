package org.foundation.faces.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 * @since 0.0.1
 */
public class RendererUtil {

    private static final Logger LOGGER = Logger.getLogger("org.foundation.faces.util.RendererUtil");

    /**
     * Get renderer of the component passed as parameter.
     *
     * @param context Faces context.
     * @param component Component that will have its renderer obtained.
     * @return Component renderer or null, if it cannot be found.
     */
    public static Renderer getRenderer(FacesContext context, UIComponent component) {
        String rendererType = component.getRendererType();
        Renderer result = null;
        if (rendererType != null) {
            result = context.getRenderKit().getRenderer(component.getFamily(),
                    rendererType);
            if (null == result) {
                if (LOGGER.isLoggable(Level.FINE)) {
                    LOGGER.log(Level.FINE, "Can''t get Renderer for type {0}", rendererType);
                }
            }
        } else {
            if (LOGGER.isLoggable(Level.FINE)) {
                String id = component.getId();
                id = (null != id) ? id : component.getClass().getName();
                LOGGER.log(Level.FINE, "No renderer-type for component {0}", id);
            }
        }
        return result;
    }

    /**
     * Encode all children of the component passed as parameter.
     *
     * @param context Faces context.
     * @param component Component that will have its children rendered.
     * @throws java.io.IOException
     */
    public static void encodeAllChildren(FacesContext context, UIComponent component) throws IOException {
        for (UIComponent innerComponent : component.getChildren()) {
            if (innerComponent.getRendererType() != null) {
                Renderer renderer = getRenderer(context, innerComponent);
                renderer.encodeBegin(context, innerComponent);
                if (innerComponent.getRendersChildren()) {
                    renderer.encodeChildren(context, innerComponent);
                }
                renderer.encodeEnd(context, innerComponent);
            } else {
                innerComponent.encodeAll(context);
            }
        }
    }
}
