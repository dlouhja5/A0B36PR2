/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kuba D
 */
public class Zrout extends Pripojeni{

    public Zrout() {
        this.setDaemon(true);
    }

    public Zrout(short port) {
        this();
        conect(port);
    }
    

    @Override
    public short conect(short port) {
        System.out.println("Connecting...");
        try {
            client = new Socket("localhost", port);
            System.out.println("Connecting...2");
            this.port=port;
            System.out.println("Connecting...3");
            proudy();
            System.out.println("Connecting...4");
            this.start();
            System.out.println("Connecting...5");
        } catch (UnknownHostException ex) {
            System.out.println("Nepodařilo se najit hostitele.");
            return (short)-1;
        } catch (IOException ex) {
            System.out.println("Nepodarilo se spojit s hostitelem.");
            return (short)-1;
        }
        return this.port;
    }

    @Override
    public void run() {
        String input;
        try {
            for(boolean b=true;b;){
                while ((input = systemIn.readLine()) != null) {
                    if (input.trim().equals("CLOSE")) {
                        System.out.println("Zrout uzavren.");
                        b=false;
                        in.close();
                        out.close();
                        systemIn.close();
                        client.close();
                        break;
                    } else {
                        Object response=null;
                        try {
                            response = in.readObject();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Zdroj.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println(response.getClass());
                        System.out.println("RESPONSE: " + response);
                        if(response!=null){
                            if(response instanceof NovyMic){
                                NovyMic nm=(NovyMic)response;
                            }
                            if(response instanceof Mic){
                                Mic m=(Mic)response;
                            }
                        }
                    }
                }
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Zrout.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Hlad.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Zdroj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
