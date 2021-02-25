package application;
import java.util.ArrayList;
public class Queue {
    public static ArrayList<playFile> files = new ArrayList<playFile>();

    /*public void playNext(){
        long num = 10000;
        //System.out.println(files.size());
        try {
        if(files.size() > 0){
            System.out.println(files.size());
            //double audioLength = Main.audioLength(files.get(0).name);
            //System.out.println("Audio Length is" + audioLength);
            if(files.get(0).type == "audio"){
                //System.out.println("Ran file: " + files.get(0).name);
                //control.program.runAudio(files.get(0).name);
            	
            	//Main.newScene = Main.getScene(control.fPath + files.get(0).name);
            	//Main.newSceneName = files.get(0).name;
            	Main.stage.setScene(Main.getScene(control.fPath + files.get(0)));
               // System.out.println("Made it back");
            }
            //num = (long)(audioLength * 1000);
            num = 5000;
        }

        
        

        try {
            Thread.sleep(num);
            System.out.println("I'm fucking off too early");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        files.remove(0);

        }catch(Exception e) {System.out.println("Queue Failed");}
    }*/

}
