package chattyserver;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User implements Runnable 
{
    public PrintWriter out;
    public BufferedReader in;
    public Thread userthread = new Thread(this);
    
    public User(PrintWriter out, BufferedReader in)
    {
        this.out=out;
        this.in=in;
    }

    @Override
    public void run() {
        
        while(true)
        {
            try {
                String text = in.readLine();
                ChatServer.broadcast(text);
            } catch (IOException ex) {
                userthread.stop();
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}