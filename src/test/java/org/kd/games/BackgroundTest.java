package org.kd.games;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testImportSmallBitmap() {
        var background = new Background(4, 3, Color.WHITE);
        background.importBitmap("games\\colors.bmp");

        assertEquals(3, background.getHeight());
        assertEquals(4, background.getWidth());

        HashMap<Point, Color> expectedPixels = createExpectedPixelMap();

        var errors = new HashMap<Point, ArrayList<Color>>();
        background.getPixels().keySet().forEach(
                bgPixelKey -> {
                    if (!background.getPixels().get(bgPixelKey).equals(expectedPixels.get(bgPixelKey))) {
                        Color expectedColor = expectedPixels.get(bgPixelKey);
                        Color actualColor = background.getPixels().get(bgPixelKey);
                        var mismatch = new ArrayList<Color>(2);
                        mismatch.add(expectedColor);
                        mismatch.add(actualColor);
                        errors.put(bgPixelKey, mismatch);
                    }
                }
        );

        if (errors.size() > 0) {
            var msg = new StringBuilder(errors.size() + " errors:\n");
            errors.keySet()
                    .forEach(bgPixelKey -> msg.append("Point ")
                            .append(bgPixelKey)
                            .append(" expected color = ")
                            .append(errors.get(bgPixelKey).get(0).toString())
                            .append(" actual = ")
                            .append(errors.get(bgPixelKey).get(1).toString())
                            .append("\n"));

            fail(msg.toString());
        }
    }

    private HashMap<Point, Color> createExpectedPixelMap() {
        Color[][] expectedPixelsArray = {
                {Color.BLACK, Color.RED, Color.MAGENTA, null}
                , {Color.GRAY, Color.GREEN, null, Color.CYAN}
                , {Color.DARK_GRAY, null, Color.YELLOW, Color.ORANGE}
                , {null, Color.LIGHT_GRAY, Color.BLUE, Color.WHITE}
        };

        var expectedPixels = new HashMap<Point, Color>();

        IntStream.range(0, expectedPixelsArray.length).forEach(x ->
                IntStream.range(0, expectedPixelsArray[0].length).forEach(y -> expectedPixels.put(new Point(x, y), expectedPixelsArray[x][y])
                ));
        return expectedPixels;
    }

    @Test
    public void testGetPixelsFromRange() {
        var background = new Background(4, 3, Color.WHITE);
        background.importBitmap("games\\colors.bmp");

        int x1 = 1, y1 = 1, x2 = 4, y2 = 3;
        var sector = background.getPixelsFromRange(x1, y1, x2, y2);
        Color[][] expectedPixels = {{Color.GREEN, Color.WHITE, Color.GRAY}
                , {Color.WHITE, Color.YELLOW, Color.BLUE}};

        IntStream.range(x1, x2).forEach(i ->
                IntStream.range(y1, y2).forEach(j -> {
                            var point = new Point(i, j);
                            System.out.print("[" + i + "," + j + "] ");
                            assertTrue(sector.containsKey(point));
                            System.out.println(sector.get(point));
                            assertEquals(expectedPixels[i - x1][j - y1], sector.get(point));
                        }
                ));
    }
}
