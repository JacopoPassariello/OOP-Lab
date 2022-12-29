package it.unisa.drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleComponent extends JComponent {

    private final Ellipse2D.Double circle;
    private final Ellipse2D.Double circleBorder;
    private final Color fillColor;
    private final Color borderColor;

    public CircleComponent(float radius, float x, float y) {
       this.circle = new Ellipse2D.Double(x,y,radius,radius);
       this.circleBorder = new Ellipse2D.Double(x,y,radius,radius);
       fillColor = Color.white;
       borderColor=Color.black;
    }

    public CircleComponent(Color fillColor, Color borderColor, float radius, float x, float y) {
        this.circle = new Ellipse2D.Double(x,y,radius,radius);
        this.circleBorder = new Ellipse2D.Double(x,y,radius,radius);
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void paintComponent(Graphics g) {

    }

    /* TODO */
}
