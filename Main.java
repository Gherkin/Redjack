
package pkg21;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Main {
    
    static JFrame frame = new JFrame();
    static Core core = new Core();
    static Images images;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                images = new Images();
                
                frame.setSize(512, 380);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(core);
                
                core.setSize(frame.getSize());
                frame.setVisible(true);
                core.setVisible(true);
                
                int delay = 1000/60;
                
                frame.setIconImage(images.icon);
                ActionListener taskPerformer = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        core.update();
                        core.repaint();
                    }
                };
                new Timer(delay, taskPerformer).start();
            }
        });
    }
}
