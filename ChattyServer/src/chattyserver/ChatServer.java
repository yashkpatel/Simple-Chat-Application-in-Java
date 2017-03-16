
package chattyserver;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer {
    
    ServerSocket ss;
    Socket s;
    PrintWriter out;
    BufferedReader in; 
    
    static Console console;
    
    static ArrayList<User> users = new ArrayList<User>();
       
    public ChatServer() throws Exception
    {
        ss = new ServerSocket(25568);
        
        new Thread(new Runnable()
        {
            
            public void run()
            {
                while(true)
                {
                try {
                    s = ss.accept();
                    
                    out = new PrintWriter(s.getOutputStream(),true);
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    
                    User user = new User(out,in);
                    user.userthread.start();
                    user.out.println("Welcome to the chat");
                    users.add(user);
                    console.writeToConsole(s.getInetAddress()+" has connected.");
                   
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            }
            }
            
        }
        
        ).start();
        
        
        console = new Console();
        
    }    
    public static void main(String[] args)throws Exception {       
        
        new ChatServer();
        console.writeToConsole("Server Started..");
 
    }
    
    public static void broadcast(String text)
    {
        for(int i=0;i<users.size();i++)
        {
            User user=users.get(i);
            
            if((user==null)||(user.out==null))
            {
                users.remove(user);
            }
            
            user.out.println(text);
        }
    }
    
}
