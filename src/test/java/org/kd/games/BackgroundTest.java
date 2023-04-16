package org.kd.games;

import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertEquals;

public class BackgroundTest {

    @Test
    public void testPutPixel() {
        var background = new Background();
        var color = Color.BLACK;
        background.putPixel(10, 20, color);
        assertEquals(color, background.getPixel(10, 20));
    }

    @Test
    public void testGetPixel() {
        var background = new Background();
        assertEquals(background.getBackgroundColor(), background.getPixel(10, 20));
    }

    @Test
    public void testClearPixel() {
        var background = new Background();
        background.putPixel(40, 41, Color.CYAN);
        background.clearPixel(40, 41);

        assertEquals(background.getBackgroundColor(), background.getPixel(40, 41));
    }

    @Test
    public void testImportDefaultBitmap() {
        var background = new GameFactory().createDefaultBackground();
        background.importBitmap("games\\bg1.bmp");

        assertEquals(480, background.getHeight());
        assertEquals(640, background.getWidth());
        assertEquals(Color.CYAN, background.getBackgroundColor());
    }

}
