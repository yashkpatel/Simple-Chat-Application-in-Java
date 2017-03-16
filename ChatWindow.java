
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatWindow extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    static int WIDTH = 640;
    static int HEIGHT = WIDTH/16*9;
    
    static final JPanel panel = new JPanel();
    static final JTextArea textArea = new JTextArea();
    static final JScrollPane scroll = new JScrollPane(textArea);
    static final JTextField messageField = new JTextField();
    static final JButton sendButton = new JButton("Send");
    
    
    
    public ChatWindow()
    {
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);           //EXIT_ON_CLOSE
        
        scroll.setPreferredSize(new Dimension(WIDTH-32,HEIGHT-100));
        
        messageField.setPreferredSize(new Dimension(WIDTH-32,16));
        
        
        panel.add(scroll);
        panel.add(messageField);
        panel.add(sendButton);        
        this.add(panel);  
        
        sendButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = messageField.getText();
                ChatClient.out.println(ChatClient.username+" : "+text);
                messageField.setText("");
            }
            
        });
    }
    
    public static void writeToChat(String text)
    {
        textArea.append(text+"\n");
    }
    
}
