
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
public class ChatClient {
    
    Socket s;
    
    public static PrintWriter out;
    public static BufferedReader in;
    
    public static String username="";
    
    public ChatClient() 
    {
        new ChatWindow();
        try
            
        {
            s = new Socket("localhost",25568);
        
            out = new PrintWriter(s.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
            while(true)
            {
                String message = in.readLine();
                ChatWindow.writeToChat(message);
            } 
        }catch(UnknownHostException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) throws IOException
    {
        username=JOptionPane.showInputDialog("Enter your name");
        new ChatClient();
    }
    
    
}
