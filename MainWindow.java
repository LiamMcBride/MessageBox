
package application;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaView;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;



public class MainWindow extends Application{
	
	public Stage stage2;
	public Scene scene;
	public BorderPane borderPane;
	public HBox hbox;
	
	public Media media;
	public MediaPlayer mediaPlayer;
	public MediaView mediaView;
	
	//public String MEDIA_URL = "C:\\Users\\liamm\\Desktop\\JavaFiles\\ValentinesDayProj\\TestPlayFiles\\piano2.wav";
	public String MEDIA_URL = "C:/Users/liamm/Desktop/Video2/ExportedVids/t1.m4v";
	public Button btnPlay;
	public Button btnPause;
	
	
	
	
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
		System.out.println(mediaPlayer.getTotalDuration());
		
		
		
	}
}
