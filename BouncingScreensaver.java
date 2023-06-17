import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingScreensaver {
    
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea box = new JTextArea();
    
    int xSpeed = 2;
    int ySpeed = 2;
    
    public BouncingScreensaver() {
        
        Color[] colorArray =    {  
                                    Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, 
                                    Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
                                    Color.YELLOW
                                };
        
        // JFrame and JPanel Configuration
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        
        // JTextArea [box] Configuration
        box.setBounds((frame.getWidth() / 2) - 80, (frame.getHeight() / 2) - 90, 150, 150);
        box.setEditable(false);
        box.setBackground(Color.BLACK);
        panel.add(box);
        
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                int randomColor = (int)(Math.random() * 9);
                box.setBounds(box.getX() + xSpeed, box.getY() + ySpeed, 150, 150);
                
                if(box.getX() >= frame.getWidth() - box.getWidth() || box.getX() <= 0) {
                    xSpeed *= -1;
                    box.setBackground(colorArray[randomColor]);
                }
                if(box.getY() >= frame.getHeight() - (box.getHeight() + 30) || box.getY() <= 0) {
                    ySpeed *= -1;
                    box.setBackground(colorArray[randomColor]);
                }
                
            }
        });
        timer.start();
        
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        
        new BouncingScreensaver();
        
    }
}