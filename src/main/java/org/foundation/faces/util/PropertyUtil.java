package org.foundation.faces.util;

/**
 *
 * @author hfluz
 * @since 0.0.1
 */
public class PropertyUtil {

    public static boolean validateSize(Integer value) {
        return value > 0 && value <= 12;
    }
}
