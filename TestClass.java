package application;
import java.io.*;
import java.util.ArrayList;

import javafx.scene.media.MediaPlayer.Status;

public class TestClass implements Runnable {
    int currentFileCount;
    public static ArrayList<File> playFiles = new ArrayList<File>();
    static String[] soundExes = new String[]{
        "m4a",
        "mp3",
        "flac",
        "wav",
        "wma",
        "aac"
    };
    static String[] imageExes = new String[]{
        "gif",
        "png",
        "raw",
        "jpg",
        "pdf",
        "jpeg"
    };
    static String[] videoExes = new String[]{
        "mp4",
        "mov",
        "wmv",
        "avi",
        "avchd",
        "avi"
    };
    static String[] textExes = new String[]{
        "txt"
    };


    
    public void run() {
        TestClass tc = new TestClass();
        tc.go();
    }

    //Main loop
    void go() {
        currentFileCount = PlayFileCount();


        while (true) {
        	try {
        	//System.out.println(Main.vd.mediaPlayer.getStatus().equals(Status.PLAYING));
        	}
        	catch(Exception e) {}
        	
            checkUpdate();
            
            if(Queue.files.size() > 0){
                //control.fileQueue.playNext();
                //deleteFile(playFiles.get(0).getName());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    //Checks for new files
    public boolean checkUpdate(){
        //Checks if the file has more files now.

        boolean temp = false;
        File directory = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles");
        for(File d : directory.listFiles()){
            if(!playFiles.contains(d)){
                temp = true;
                System.out.println("New File");
                playFiles.add(d);
                currentFileCount = playFiles.size();
                //MainScreen.fileNum = currentFileCount;
                //MainScreen.updateText();
                Queue.files.add(new playFile(d.getName(), fileType(d.getName())));
                //control.program.updateText("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/" + d.getName());
                //control.im = "C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/" + d.getName();
            }
        }


        return temp;
    }

    //Initial Check of file count and population of the fileQueue, should delete this soon and combine it wil checkUpdate()
    public int PlayFileCount(){
        File directory = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles");
        int fileCount = directory.list().length;
        for(File d : directory.listFiles()){
            playFiles.add(d);
            

            Queue.files.add(new playFile(d.getName(), fileType(d.getName())));
            
            
        }
        return fileCount;
    }

    //Deletes named file
    public static void deleteFile(int fileName){
        File f = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles/" + TestClass.playFiles.get(0));
        
        TestClass.playFiles.remove(0);

        f.delete();

        System.out.println("File Deleted " + fileName);
    }

    public static String fileType(String name){
        name = name.toLowerCase();
        int pointer = name.indexOf(".");
    
        String ext = name.substring(pointer + 1);


        for(String s : soundExes){
           
            if(s.equals(ext)){
               
                return "audio";
            }
        }
        for(String s : videoExes){
            if(s == ext){
                return "video";
            }
        }
        for(String s : imageExes){
            if(s == ext){
                return "image";
            }
        }
        for(String s : textExes){
            if(s == ext){
                return "text";
            }
        }
        
        return "unknown file type";
    }
}
