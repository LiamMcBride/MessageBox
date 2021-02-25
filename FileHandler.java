package application;

import java.io.*;
import java.util.ArrayList;


public class FileHandler implements Runnable {
    int currentFileCount;
    ArrayList<File> playFiles = new ArrayList<File>();
   
    public void run(){
        System.out.println("Hi!");
    }
    void go(){
        currentFileCount = PlayFileCount();
        while(!checkUpdate()){
            //MainScreen.updateText(String.valueOf(currentFileCount));
        }
    }

    public boolean checkUpdate(){
        boolean temp = false;
        File directory = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles");
        for(File d : directory.listFiles()){
            if(!playFiles.contains(d)){
                temp = true;
                System.out.println("New File");
                playFiles.add(d);
            }
        }


        return temp;
    }

    public int PlayFileCount(){
        File directory = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles");
        int fileCount = directory.list().length;
        for(File d : directory.listFiles()){
            playFiles.add(d);
        }
        return fileCount;
    }

 

    
}
