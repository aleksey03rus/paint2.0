import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    private Figure figure;


    public MyPanel(Figure figure) {
        super();
        this.figure = figure;

    }


    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        /*BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\Users\\Alex\\Downloads\\music_vk\\Tpuko3a\\kEd3gYovPy0.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, 0, 0, this);*/
        figure.draw(g);
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }
}
