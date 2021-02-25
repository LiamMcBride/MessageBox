
package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;



public class VideoTest extends MediaView{
	
	public Scene scene;
	public Stage stage;
	
	public BorderPane borderPane;
	//public HBox hbox;
	
	public Media media;
	public MediaPlayer mediaPlayer;
	public MediaView mediaView;
	
	//public String MEDIA_URL2 = "C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\TestPlayFiles\\piano2.wav";
	//public String MEDIA_URL = "C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v";
	public String MEDIA_URL;

	
	
	
	VideoTest(String md, Stage s){
		MEDIA_URL = md;
		stage = s;
		this.start();
	}
	
	public static void main(String args[]){

		Application.launch(args);

	}
	
	
	public void start() {

		borderPane = new BorderPane();
		
		media = new Media(new File(MEDIA_URL).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		//mediaPlayer.setPreserveRatio(true);
		
		//mediaPlayer.setOnReady(() -> stage2.sizeToScene());
		mediaView = new MediaView(mediaPlayer);
		
		borderPane.setCenter(mediaView);
		
		//stage.setAlwaysOnTop(true);
		
		//stage.setFullScreen(true);
		
		stage.setScene(new Scene(borderPane));
		stage.setFullScreen(true);
		
		//stage.show();
		


		
		
		
	}
}
