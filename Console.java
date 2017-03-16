
package chattyserver;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class Console {
    
    final JFrame frame = new JFrame("Server Console");                  
    final JPanel panel = new JPanel();
    public static final JTextArea textArea = new JTextArea();
    public static final JScrollPane scrol = new JScrollPane(textArea);
    
    static final int width = 640;
    static final int height = width/16*9;
    
    public Console()
    {
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        scrol.setPreferredSize(new Dimension(width-32,height-56));
        panel.add(scrol);
        frame.add(panel);
    }

    public void writeToConsole(String text) {
        textArea.append(text);
    }
}
