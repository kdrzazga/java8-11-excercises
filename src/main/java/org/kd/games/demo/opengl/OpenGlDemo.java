package org.kd.games.demo.opengl;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import org.kd.games.Display;
import org.kd.games.GameFactory;

import javax.swing.*;

public final class OpenGlDemo implements GLEventListener {

    private final Display display = new GameFactory().createDefaultDisplayWithAnimation();

    @Override
    public void display(GLAutoDrawable drawable) {
        try {
            final var gl = drawable.getGL().getGL2();
            var drawer = new OpenGlDrawer(gl);
            drawer.draw(display);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    @Override
    public void init(GLAutoDrawable arg0) {
        // method body
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }

    public static void main(String[] args) {
        new OpenGlDemo().init();
    }//end of main

    private void init() {
        var profile = GLProfile.get(GLProfile.GL2);
        var capabilities = new GLCapabilities(profile);
        var glCanvas = new GLCanvas(capabilities);

        glCanvas.addGLEventListener(this);
        glCanvas.setSize(display.getBackground().getWidth(), this.display.getBackground().getHeight());

        final var frame = new JFrame("Demo");

        frame.getContentPane().add(glCanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}//end of classimport