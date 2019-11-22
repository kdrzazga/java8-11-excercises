package org.kd.games.demo.opengl;

import com.jogamp.opengl.GL2;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.util.Map;

public final class ColorSettings {

    @AllArgsConstructor
    @Getter
    public final static class OpenGlColor {
        private float r;
        private float g;
        private float b;
    }

    public final static Map<Color, OpenGlColor> awtToGlColorMap = Map.of(
            Color.RED, new OpenGlColor(1f, 0f, 0f)
            , Color.BLUE, new OpenGlColor(0f, 0f, 1f)
            , Color.GREEN, new OpenGlColor(0f, 1f, 0f)
            , Color.MAGENTA, new OpenGlColor(1f, 0f, 1f)
            , Color.ORANGE, new OpenGlColor(1f, 0.9f, 0.2f)
            , Color.CYAN, new OpenGlColor(0f, 1f, 1f)
            , Color.YELLOW, new OpenGlColor(1f, 1f, 0f)
            , Color.WHITE, new OpenGlColor(1f, 1f, 1f)
            , new Color(162, 42, 42), new OpenGlColor(1f, 0.37f, 0f)
    );

    public final static void setColor(Color awtColor, GL2 gl) {
        var openGlColor = ColorSettings.awtToGlColorMap.getOrDefault(awtColor, new ColorSettings.OpenGlColor(0, 0, 0));

        gl.glColor3f(openGlColor.getR(), openGlColor.getG(), openGlColor.getB());
    }
}
