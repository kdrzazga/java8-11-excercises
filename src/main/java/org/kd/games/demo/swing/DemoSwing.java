package org.kd.games.demo.swing;

import org.kd.games.Animation;
import org.kd.games.Display;
import org.kd.games.Drawer;
import org.kd.games.GameFactory;

import javax.swing.*;
import java.awt.*;

public class DemoSwing extends JFrame {

    private final Display display = new GameFactory().createDefaultDisplayWithAnimation();

    private final JPanel panel = new JPanel();
    private Animation animation;
    private Drawer drawer;

    public static void main(String[] args) {
        new DemoSwing().start();

    }

    private void start() {
        setupUI();
        setupDrawer();
        setupAnimation();
    }

    private void setupAnimation() {
        animation = new GameFactory().createHorizontalAnimation(drawer);
        animation.start();
    }

    private void setupDrawer() {
        drawer = new SwingDrawer(this.panel.getGraphics());
        drawer.draw(display);
    }

    private void setupUI() {
        var width = display.getBackground().getWidth();
        var height = display.getBackground().getHeight();
        this.setMaximumSize(new Dimension(width, height + 30));
        this.setMinimumSize(new Dimension(width, height + 30));
        this.panel.setMaximumSize(new Dimension(width, height));
        this.panel.setMaximumSize(new Dimension(width, height));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.add(panel);
        this.setVisible(true);

    }
}
