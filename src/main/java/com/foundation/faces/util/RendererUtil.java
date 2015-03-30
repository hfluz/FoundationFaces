package com.foundation.faces.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

/**
 *
 * @author hfluz
 */
public class RendererUtil {

    private static final Logger LOGGER = Logger.getLogger("org.foundation.faces.util.RendererUtil");

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
}
