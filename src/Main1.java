import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main1 {
    static int count = 0;
    private int x1, x2, y1, y2;
    private Boolean event = false;
    private Color dColorChooser = Color.BLUE;
    private Image image;
    public BufferedImage bufferedImage;

    public Main1() {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame mainFrame;
        JPanel menuPanel;



        JButton buttonFigure, buttonOval, buttonColor, button4;
        Dimension drawPanelX;
        int drawPanelY;


        mainFrame = new JFrame("Window toolbar");
        //mainFrame.setLocationRelativeTo();
        mainFrame.setBounds(400,200, 1200, 700);
        //mainFrame.setSize();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        menuPanel = new JPanel();

        MyPanel drawPanel = new MyPanel(new Line());
        drawPanel.setBackground(Color.WHITE);
        System.out.println(drawPanel.getMaximumSize());

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu = new JMenu("File");

        JMenuItem jMenuItem1 = new JMenuItem("Открыть...");
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser("E:\\distr");
                jFileChooser.showDialog(mainFrame, null);

            }
        });
        jMenu.add(jMenuItem1);
        JMenuItem jMenuItem2 = new JMenuItem("Сохранить");
        jMenu.add(jMenuItem2);
        JMenuItem jMenuItem3 = new JMenuItem("Печать");
        jMenu.add(jMenuItem3);
        jMenu.addSeparator();
        JMenuItem jMenuItem4 = new JMenuItem("Закрыть");
        jMenu.add(jMenuItem4);

        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu jMenu1 = new JMenu("edit");

        JMenu jMenu2 = new JMenu("русский язык");
        jMenu2.addSeparator();

        JMenu jMenu3 = new JMenu("Справка");
        JMenuItem jMenuItem11 = new JMenuItem("О программе");
        jMenuItem11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame, "Help");

            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(new JSeparator());
        jMenuBar.add(jMenu3);



        drawPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (event == true) {
                    //drawPanel.getGraphics().setColor(dColorChooser);

                    Line line = new Line(x1, y1, e.getX(), e.getY());
                    line.setColor(dColorChooser);
                    drawPanel.setFigure(line);
                    drawPanel.repaint();
//                    drawPanel.getGraphics().drawLine(x1, y1, e.getX(), e.getY());

                    x1 = e.getX();
                    y1 = e.getY();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        drawPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                event = true;

                x1 = e.getX();
                y1 = e.getY();

                drawPanel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //drawPanel.setFigure(new Line(x1, y1, x2, y2));
                event = false;
                x2 = e.getX();
                y2 = e.getY();
                // drawPanel.setFigure(new Oval(x1, y1, x2, y2));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        menuPanel.setBackground(Color.gray);


        buttonFigure = new JButton("Line");

        buttonOval = new JButton("Filloval");

        buttonOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*dColorChooser = JColorChooser.showDialog(mainFrame, "Czetaaa", dColorChooser);
                drawPanel.getGraphics().setColor(dColorChooser);*/
                FillOval fillOval = new FillOval((int) (Math.random()*1000), (int) (Math.random()*1000), 40, 40);
                fillOval.setColor(dColorChooser);

                drawPanel.setFigure(fillOval);
                drawPanel.repaint();
                mainFrame.repaint();
            }
        });

        buttonColor = new JButton("выбрать цвет");
        buttonColor.setBackground(Color.YELLOW);
        buttonColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dColorChooser = JColorChooser.showDialog(mainFrame, "Czetaaa", dColorChooser);
                ((Line) drawPanel.getFigure()).setColor(dColorChooser);
//                drawPanel.getGraphics().setColor(dColorChooser);
                // drawPanel.repaint();
            }
        });
        button4 = new JButton("&&&");


        menuPanel.add(buttonFigure);
        menuPanel.add(buttonOval);
        menuPanel.add(buttonColor);
        menuPanel.add(button4);
        menuPanel.setLayout(new GridLayout(5,1));
        //menuPanel.add(jColorChooser);
        menuPanel.setPreferredSize(new Dimension(400,300));
        mainFrame.add(menuPanel, BorderLayout.EAST);
        mainFrame.add(drawPanel, BorderLayout.CENTER);
        mainFrame.add(jMenuBar, BorderLayout.NORTH);
        //mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main1();
            }
        });
    }

}

