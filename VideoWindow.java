
package application;

import javafx.stage.Stage;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

import java.io.File;



public class VideoWindow extends Application implements Runnable{
	
	public Stage stage2;
	public Scene scene;
	public BorderPane borderPane;
	public HBox hbox;
	
	public Media media;
	public MediaPlayer mediaPlayer;
	public MediaView mediaView;
	
	//public String MEDIA_URL2 = "C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\TestPlayFiles\\piano2.wav";
	public String MEDIA_URL = "C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v";
	public Button btnPlay;
	public Button btnPause;
	public Thread thr;
	
	
	
	public void run() {
		start(new Stage());
	}
	
	VideoWindow(String s, Stage st, Thread t){
		MEDIA_URL = s;
		stage2 = st;
		thr = t;
		
		start(stage2);
	}
	
	public static void main(String args[]){

		Application.launch(args);

	}
		
	@Override 
	public void start(Stage stage2) {
		//stage2 = new Stage();
		stage2.setTitle("Video Player");
		stage2.setAlwaysOnTop(true);
		borderPane = new BorderPane();
		
		media = new Media(new File(MEDIA_URL).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		//mediaPlayer.setPreserveRatio(true);
		
		mediaPlayer.setOnReady(() -> stage2.sizeToScene());
		mediaView = new MediaView(mediaPlayer);
		
		borderPane.setCenter(mediaView);
		
		btnPlay = new Button(">");
		btnPause = new Button("||");
		
		hbox = new HBox(10);
		hbox.getChildren().addAll(btnPlay,btnPause);
		hbox.setPadding(new Insets(10));
		
		scene = new Scene(borderPane);
		
		stage2.setScene(scene);
		stage2.show();
		
		try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//mediaPlayer = new MediaPlayer(new Media(new File(MEDIA_URL2).toURI().toString()));
		mediaPlayer.setAutoPlay(true);
		
		mediaPlayer.setOnEndOfMedia(() -> {
			
			System.out.println("finished playing the video Liammmmmmmmmmmmmmmmmmm");
			mediaPlayer = null;
			scene = null;
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stage2.close();
			deleteFile();
			Queue.files.remove(0);
			
			
		});
		
		
		
		
		
	}
	public void deleteFile(){
        File f = new File("C:/Users/liamm/Desktop/JavaFiles/ValentinesDayProj/PlayFiles/" + "t1.m4v");
	//TestClass.playFiles.get(0));
        
        TestClass.playFiles.remove(0);

        f.delete();

        System.out.println("File Deleted");
    }
}
