//AudioFilePlayer.java
/*Code researched and written by John Brosnan who sent it on for use with the audio aspects of the project
  It uses some of the JavaFX classes and has a driver to show how it might be used. */

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
//This class is a modified version of the code provided by John Brosnan
public class AudioFilePlayer{

	private MediaPlayer mediaPlayer; //need to declare this reference globally to prevent garbage collector
	                         //from removing it prematurely when play() is called in the playAudio()
	                         //method, which would stop playing the clip after a few seconds
    public void playAudio(String path)
    {			
		//create a new Media object using the file path specified in the call to playAudio
		//this will become the audio clip object we wish to play
		Media audioClip = new Media(new File(path).toURI().toString());
		
		//create a new MediaPlayer object that will be used to play the audio clip
		mediaPlayer = new MediaPlayer(audioClip);
		
		try
		{
			mediaPlayer.play();
		}
		catch(Exception e)
    	{
    		System.out.println("The audio file " + path + " could not be played!");
    	}
    }
}