import javax.swing.*;
import java.awt.*;

public abstract class Figure {
    protected Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);
}

