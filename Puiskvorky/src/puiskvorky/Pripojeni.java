/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puiskvorky;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Kuba D
 */
public abstract class Pripojeni extends Thread {
    protected Socket client=null;
    protected short port=-1;
    protected ObjectOutputStream out=null;// = new ObjectOutputStream(new PrintWriter(client.getOutputStream(), true));
    protected ObjectInputStream in=null;// = new ObjectInputStream(new BufferedReader(new InputStreamReader(client.getInputStream())));
    protected BufferedReader systemIn=null;// = new BufferedReader(new InputStreamReader(System.in));

    public abstract short conect(short port);
    public void proudy() throws IOException{
        System.out.println("proudy...0"+this.getClass());
//        out= new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));
        System.out.println("proudy...1"+this.getClass());
        systemIn= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("proudy...2");
        InputStream is=client.getInputStream();
        System.out.println("proudy...3");
        BufferedInputStream bis=new BufferedInputStream(is);
        System.out.println("proudy...4");
        in=new ObjectInputStream(bis);
//        in= new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
//        new BufferedReader(new InputStreamReader(client.getInputStream())).close();
        System.out.println("proudy...5");
    }
    public void send(Object o) throws IOException{
        if(port>-1){
        out.writeObject(o);
            System.out.println("Odeslano.");
        }else{
            System.out.println("Nelze odeslat.");
        }
        
    }
    @Override
    public abstract void run();
    @Override
    public void finalize() throws Throwable{
        if(port>-1){
            out.close();
            in.close();
            systemIn.close();
            client.close();
        }
        super.finalize();
    }
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        Mic m = new Mic(5,5,KK.PRAZDNE);
        Pripojeni[] p=new Pripojeni[10];
        p[0]=new Zdroj();
        p[1]=new Zrout();
        p[0].conect((short)-1);
        System.out.println("Zadej port.");
        Scanner sc=new Scanner(System.in);
        p[1].conect(sc.nextShort());
        System.out.println("....1");
        sleep(10000);
        p[0].send(m);
        System.out.println("....2");
        sleep(10000);
        System.out.println("....3");
        sleep(10000);
        System.out.println(p[1].getObject());
    }

    public Object getObject() throws IOException, ClassNotFoundException {
        Object ret = null;
        if(port>-1){
            ret = this.in.readObject();
        }
        return ret;
    }
}
