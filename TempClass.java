package application;

import javafx.application.Platform;
import javafx.stage.Stage;

public class TempClass implements Runnable{
	
	public Stage stage;
	
	TempClass(Stage s){
		stage = s;
	}
	
	public void run() {
		
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println("we run baby!");
		
		VideoTest vd = new VideoTest("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\PlayFiles\\t1.m4v", stage);
		
		//Main.pVideo();
		
		
		
	}

}
