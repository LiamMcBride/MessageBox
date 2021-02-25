package application;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.File;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.*;
import javax.mail.*;
import javax.mail.internet.*;
public class receiveEmail implements Runnable{
    public static void check(String host, String storeType, String user,
    String password) 
   {
    String lastEmail = "";
    try {
      while(true){
    //create properties field
    Properties properties = new Properties();

    properties.put("mail.pop3.host", host);
    properties.put("mail.pop3.port", "995");
    properties.put("mail.pop3.starttls.enable", "true");
    Session emailSession = Session.getDefaultInstance(properties);

    //create the POP3 store object and connect with the pop server
    Store store = emailSession.getStore("pop3s");

    store.connect(host, user, password);

    //create the folder object and open it
    Folder emailFolder = store.getFolder("INBOX");
    emailFolder.open(Folder.READ_ONLY);


   /* Flags seen = new Flags(Flags.Flag.SEEN);
    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
    Message messages[] = emailFolder.search(unseenFlagTerm);*/


    // retrieve the messages from the folder in an array and print it
    
    Message[] messages = emailFolder.getMessages();

    if(messages.length > 0){
   
    System.out.println("messages.length---" + messages.length);
    messages =  receiveEmail.reverseMessages(messages);
   
    if(!lastEmail.equals(messages[0].getSubject()))
    {
       lastEmail = messages[0].getSubject();
    //for (int i = 0, n = 1; i < n; i++) {
       Message message = messages[0];
       String contentType = message.getContentType();
       if(contentType.contains("multipart")){
           Multipart multiPart = (Multipart) message.getContent();
           for(int j = 0; j < multiPart.getCount(); j++){
               MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(j);
               if(Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())){
                    part.saveFile("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles/" + part.getFileName());
                    System.out.println("File saved");
                   //FileOutputStream output = new FileOutputStream(new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj"));

               }
           }
       }
       System.out.println("---------------------------------");
       System.out.println("Email Number " + (0 + 1));
       System.out.println("Subject: " + message.getSubject());
       System.out.println("From: " + message.getFrom()[0]); 
       System.out.println("Text: " + message.getContent().toString());

    //}
   }
   
   
   }
    //close the store and folder objects
    emailFolder.close(false);
    store.close();
    Thread.sleep(10);

   }


    } catch (NoSuchProviderException e) {
       e.printStackTrace();
    } catch (MessagingException e) {
       e.printStackTrace();
    } catch (Exception e) {
       e.printStackTrace();
    }
 }
   public void run(){
      String host = "pop.gmail.com";// change accordingly
      String mailStoreType = "pop3";
      String username = "bluelettergames@gmail.com";// change accordingly
      String password = "Joimarie5302";// change accordingly
  
      check(host, mailStoreType, username, password);
   }
 public static void main(String[] args) {

    String host = "pop.gmail.com";// change accordingly
    String mailStoreType = "pop3";
    String username = "bluelettergames@gmail.com";// change accordingly
    String password = "Joimarie5302";// change accordingly
    System.out.println("Mail Starting...");
    check(host, mailStoreType, username, password);

 }

 public static Message[] reverseMessages(Message[] mess){
    Message[] temp = new Message[mess.length];

    for(int i = 0; i < mess.length; i++){
        temp[mess.length - 1 - i] = mess[i];

    }

    return temp;
 }
}