package ru.stqa.pft.mantis.appmanager;

import org.apache.commons.net.telnet.TelnetClient;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by marru on 09.09.2017.
 */
public class JamesHelper {
    private ApplicationManager app;

    private TelnetClient telnet;
    private InputStream in;
    private PrintStream out;

    private Session mailSession;
    private Store store;
    private String mailserver;

    public JamesHelper (ApplicationManager app){
        this.app = app;
        telnet=new TelnetClient();
        mailSession=Session.getDefaultInstance(System.getProperties());
    }

    public boolean doesUserExit (String name){
        initTelnetSession();
        write("verify" + name);
        String result = readUntil ("exit");
        closeTelnetSession();
        return result.trim().equals("User"+name+"exit");
    }

    public void createUser (String name,String passwd){
        initTelnetSession();
        write("adduser"+name+" "+ passwd);
        String result = readUntil ("User"+name+"added");
        closeTelnetSession();
    }


    public void deleteUser (String name){
        initTelnetSession();
        write("deluser" + name);
        String result = readUntil ("User"+name+"deluser");
        closeTelnetSession();
    }


    private void initTelnetSession() {
        mailserver = app.getProperty("mailserver.host");
        int port = Integer.parseInt(app.getProperty("mailserver.port"));
        String login = app.getProperty("mailserver.adminlogin");
        String password = app.getProperty("mailserver.adminpassword");

        try {
            telnet.connect(mailserver, port);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream() );
            }catch (Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        readUntil("Login id:");
        write("");
        readUntil ("Password");
        write(password);

        readUntil ("Welcome"+login+". HELP for lost of commands");

    }


    private String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length()-1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();
            while (true){
                System.out.println(ch);
                sb.append(ch);
                if (ch==lastChar){
                    if (sb.toString().endsWith(pattern)){
                        return sb.toString();
                    }
                }
                ch=(char) in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void write (String value){
        try{
            out.println(value);
            out.flush();
            System.out.println(value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeTelnetSession(){
        write("quit");
    }

    public void drainEmail (String username, String password) throws MessagingException {
        Folder inbox = openInbox (username,password);
        for (Message message : inbox.getMessages()){
            message.setFlag(Flags.Flag.DELETED,true);
        }
        closeFolder(inbox);
    }

    private Folder openInbox(String username, String password) {
    }

    private void closeFolder(Folder folder) throws MessagingException {
        folder.close(true);
        store.close();
    }
}