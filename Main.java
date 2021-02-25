package application;

import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaView;
import javafx.geometry.Insets;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.event.*;



public class Main extends Application{
	public static Stage stage = new Stage();
	//public static Scene[] scenes = new Scene[2];
	//public static Scene newScene;
	//public static Scene oldScene;
	//public static String oldSceneName;
	//public static String newSceneName;
	//public Scene scene;
	public StackPane pane;
	public static MediaPlayer player;
	int counter = 0;
	public Thread myThread;
	
	public static VideoWindow vd;
	
	
	
	public static void main(String args[]) {
		
		Application.launch(args);
		
	}
	
	public static void getPlayer(String med) {
		
		Media media = new Media(new File(med).toURI().toString());
		player = new MediaPlayer(media);
		
		player.setAutoPlay(true);
		
		//player.setOnReady(() -> stage.sizeToScene());
		
		
		
	}
	
	public static Scene getScene(String med) {
		BorderPane bp = new BorderPane();
		getPlayer(med);
		bp.setCenter(new MediaView(player));
		
		
		Scene scene = new Scene(bp);
		System.out.println("Ya boi set that scene baby");
		return scene;
	}
	
	public void swapScene(Scene s) {
		stage.setScene(s);
	}
	
	public void pVideo() {
		//VideoWindow vd = new VideoWindow("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\PlayFiles\\t1.m4v", stage);
		//System.out.println(Queue.files.size());
		if(Queue.files.size() > 0) {
			vd = new VideoWindow("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\PlayFiles\\" + Queue.files.get(0).name, stage, myThread);
			
			//System.out.println(vd.mediaPlayer.getStatus().equals(Status.PLAYING));
			//counter += 1;
		}
		//else if(counter == 1) {
			
		//	if(Queue.files.size() > 0) {
				//Queue.files.remove(0);
				//TestClass.deleteFile(Queue.files.get(0).name);
				
				//System.out.println("Counter works");
				
				//counter = 0;
				//pVideo();
			//}
			
		//}
		
	}
	
	
	
	public void start(Stage stage) { 
		Runnable fileThread = new TestClass();
        myThread = new Thread(fileThread);
        Runnable emailThread = new receiveEmail();
        Thread myThread2 = new Thread(emailThread);

        myThread.start();
        myThread2.start();
        
       // Runnable fileThread2 = new TempClass(stage);
        //Thread myThread3 = new Thread(fileThread2);
        //myThread3.start();
		
		/*Runnable vidThread = new VideoWindow();
		Thread myThread = new Thread(vidThread);
		myThread.start();*/
		
		
		
		//scenes[0] = getScene("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\PlayFiles\\Img 3359-1.m4v");
		//scenes[1] = getScene("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\PlayFiles\\t1.m4v");
        
		
		
		
		pane = new StackPane();
		
		//stage.setScene(getScene("C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v"));
		//stage.setScene(getScene("C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v"));
		//Main.swapScene("C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v", stage);
		
		//Scene scene1 = getScene("C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v");
		//Scene scene2 = getScene("C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\TestPlayFiles\\piano2.wav");
		
		//stage.setScene(scene1);
		
		Button play = new Button("Play");
		pane.getChildren().add(play);
		
		Scene cScene = new Scene(pane);
		
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				play.setText("Clicked");
				pVideo();
			}
		};
		
		play.setOnAction(event);
		
		
		
		
		stage.setAlwaysOnTop(false);
		
		stage.setFullScreen(false);
		
		stage.setHeight(600);
		
		stage.setWidth(900);
		
		/*System.out.println(stage.isResizable());
		Runnable fileThread = new TempClass();
        Thread myThread = new Thread(fileThread);
		myThread.start();*/

		stage.setScene(cScene);
		
		//stage.setScene(scenes[0]);
		
		//Stage stage2 = new Stage();
		stage.show();
		
		
		
		/*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		stage.setScene(scenes[1]);
		
		/*while(true) {
			
			if(oldSceneName != newSceneName) {
				System.out.println("We run baby");
				stage.setScene(newScene);
				oldSceneName = newSceneName;
				System.out.println("We run baby");
			}
			else {
				//System.out.println(oldSceneName + " == " + newSceneName);
			}
		}*/
		
		/*try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		stage.setScene(scene2);*/
		
		
	}
	

	
	
}
