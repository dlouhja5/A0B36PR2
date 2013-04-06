/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kuba D
 */
public class Zdroj extends Pripojeni {
    private ServerSocket server=null;

    public Zdroj() {
        this.setDaemon(true);
    }

    public Zdroj(short port) {
        this();
        conect(port);
    }
    

    @Override
    public short conect(short port) {
        if(port>-1){
            try {
                server = new ServerSocket(port);
                this.port=port;
                System.out.println(""+this.port);
            } catch (IOException e) {
                System.out.println("Port " + port +" je uz obsazen.");
            }
        }
        if(this.port<0){
            for(port=Short.MAX_VALUE;port>-1;port--){
                try {
                    server = new ServerSocket(port);
                    this.port=port;
                    System.out.println(""+this.port);
                    break;
                } catch (IOException e) {
                    System.out.println("Port " + port +" je uz obsazen.");
                }
            }
        }
        this.start();
        return this.port;
    }

    public void finalize() throws Throwable{
        if(port>-1){
            server.close();
        }
        super.finalize();
    }

    @Override
    public void run() {
        try {
            while(client==null){
                client = server.accept();
                proudy();
                System.out.println("Conected.");
            }
        } catch (IOException e) {
            System.out.println("Pripojeni selhalo.");
            System.exit(-1);
        }
        String input;
        try {
            for(boolean b=true;b;){
                while ((input = systemIn.readLine()) != null) {
                    if (input.trim().equals("CLOSE")) {
                        System.out.println("Zdroj uzavren.");
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
                    Logger.getLogger(Zdroj.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Nic.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Zdroj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
