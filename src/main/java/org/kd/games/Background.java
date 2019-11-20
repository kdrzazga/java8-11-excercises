package org.kd.games;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

@NoArgsConstructor
@Getter
public class Background {

    private int width = 640;
    private int height = 480;
    private Color backgroundColor = Color.WHITE;
    private final static Map<Integer, Color> colorCodes = new HashMap<>();

    static {
        colorCodes.put(0, Color.BLACK);
        colorCodes.put(3, Color.ORANGE);
        colorCodes.put(6, new Color(128, 128, 128));
        colorCodes.put(7, Color.DARK_GRAY);
        colorCodes.put(8, Color.LIGHT_GRAY);
        colorCodes.put(9, Color.RED);
        colorCodes.put(10, Color.GREEN);
        colorCodes.put(11, Color.YELLOW);
        colorCodes.put(12, Color.BLUE);
        colorCodes.put(13, Color.MAGENTA);
        colorCodes.put(14, Color.CYAN);
        colorCodes.put(15, Color.WHITE);
    }

    private Map<Point, Color> pixels = new HashMap<>();

    public Background(int width, int height, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
    }

    public void putPixel(int x, int y, Color color) {
        if (validatePoint(x, y))
            this.pixels.put(new Point(x, y), color);
    }

    public void clearPixel(int x, int y) {
        putPixel(x, y, this.backgroundColor);
    }

    public Color getPixel(int x, int y) {
        var pixel = new Point(x, y);
        return this.pixels.getOrDefault(pixel, backgroundColor);
    }

    public Map<Point, Color> getPixelsFromRange(int x1, int y1, int x2, int y2) {
        var pixels = new HashMap<Point, Color>();
        IntStream.range(x1, x2).forEach(
                x -> IntStream.range(y1, y2).forEach(y -> pixels.put(new Point(x, y), getPixel(x, y)))
        );

        return pixels;
    }

    public void importBitmap(String path) {
        var file = new File(System.getProperty("user.dir") + "/src/main/resources/org/kd/" + path);
        try {
            var img = ImageIO.read(file);
            this.height = img.getHeight();
            this.width = img.getWidth();

            int band = 0;

            pixels.clear();
            convertToPixels(img.getData().getSamples(0, 0, width, height, band, new int[width * height]));

            this.backgroundColor = getMostFrequentColor();

        } catch (IOException e) {
            System.err.println("Import unsuccessful");
            e.printStackTrace();
        }
    }

    private Color getMostFrequentColor() {
        return new TreeMap<>(findColorsOccurrence())
                .descendingMap()
                .firstEntry()
                .getValue();
    }

    private void convertToPixels(int[] bitmapSamples) {
        IntStream.range(0, bitmapSamples.length).forEach(i -> {
            var x = i % width;
            var y = Math.round(i / height);

            pixels.put(new Point(x, y), colorCodes.get(bitmapSamples[i]));

            //eliminateBlankLines();
        });
    }

    private void eliminateBlankLines() {
        //TODO
        IntStream.range(1, height).forEach(y ->
                IntStream.range(0, width).forEach(x -> {
                    var pixel = new Point(x, y);
                    if (!pixels.keySet().contains(pixel)) {
                        var upperPixelColor = pixels.get(new Point(x, y - 1));
                        pixels.put(pixel, upperPixelColor);
                    }
                })
        );

    }

    private Map<Integer, Color> findColorsOccurrence() {
        var occurrence = new HashMap<Integer, Color>();
        pixels.values().stream().distinct().forEach(color -> {
            int number = Collections.frequency(pixels.values(), color);
            occurrence.put(number, color);
        });
        return occurrence;
    }

    private boolean validatePoint(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
