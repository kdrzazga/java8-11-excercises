package org.kd.games;

import java.awt.*;
import java.util.List;

public interface Drawer {
    void draw(Display display);

    void draw(List<Sprite> sprites);

    void draw(Sprite sprite);

    void draw(Background background);

    void draw(Background background, Rectangle piece);
}
