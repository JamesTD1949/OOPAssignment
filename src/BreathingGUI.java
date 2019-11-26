

import com.sun.media.jfxmedia.MediaPlayer;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BreathingGUI extends JFrame {


    private String kennelCoughAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing.wav", heartFailureAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing2.wav",fluAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\Labrador-breathing.wav";

    public BreathingGUI(int petID, String name, String type)
    {
        setSize(650,600);
        setTitle("Vitaliti Vet - Diagnose Breathing Condition");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,250);
        setResizable(false);


        //define the components declared above
        JLabel severity = new JLabel("Severity(low to high):");
        JButton diagnose = new JButton("Diagnose");
        JRadioButton severity1 = new JRadioButton("1");
        JRadioButton severity2 = new JRadioButton("2");
        JRadioButton severity3 = new JRadioButton("3");
        JRadioButton severity4 = new JRadioButton("4");
        JRadioButton severity5 = new JRadioButton("5");
        JRadioButton kennelCough = new JRadioButton("Kennel Cough");
        JRadioButton heartFailure = new JRadioButton("Heart Failure");
        JRadioButton flu = new JRadioButton("Flu");
        JButton kennelCoughPlay = new JButton("Play Kennel Cough");
        JButton heartFailurePlay = new JButton("Play Heart Failure Cough");
        JButton fluPlay = new JButton("Play Flu Cough");

        ButtonGroup condition = new ButtonGroup();
        condition.add(kennelCough);
        condition.add(heartFailure);
        condition.add(flu);

        ButtonGroup severityGroup = new ButtonGroup();
        severityGroup.add(severity1);
        severityGroup.add(severity2);
        severityGroup.add(severity3);
        severityGroup.add(severity4);
        severityGroup.add(severity5);

        ImageIcon breathingImage = new ImageIcon("C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + type + "_breathing.jpg");
        JLabel breathing = new JLabel(breathingImage);

        //create dimension objects to hold the preferred width and height for the specified components
        Dimension label = severity.getPreferredSize();
        Dimension radio = kennelCough.getPreferredSize();
        Dimension image = breathing.getPreferredSize();


        //set the locations and dimensions of the components using the dimensions created above
        breathing.setBounds(200,30,image.width,image.height);
        kennelCough.setBounds(50,250,radio.width,radio.height);
        heartFailure.setBounds(50,300,radio.width,radio.height);
        flu.setBounds(50,350,radio.width,radio.height);
        kennelCoughPlay.setBounds(200,250,300,30);
        heartFailurePlay.setBounds(200,300,300,30);
        fluPlay.setBounds(200,350,300,30);
        severity.setBounds(50,400,label.width,label.height);
        severity1.setBounds(170,400,radio.width,radio.height);
        severity2.setBounds(270,400,radio.width,radio.height);
        severity3.setBounds(370,400,radio.width,radio.height);
        severity4.setBounds(470,400,radio.width,radio.height);
        severity5.setBounds(570,400,radio.width,radio.height);
        diagnose.setBounds(225,450,200,45);




        //add the components to the JFrame
        add(severity);
        add(diagnose);
        add(kennelCough);
        add(heartFailure);
        add(flu);
        add(severity1);
        add(severity2);
        add(severity3);
        add(severity4);
        add(severity5);
        add(breathing);
        add(kennelCoughPlay);
        add(heartFailurePlay);
        add(fluPlay);
/*
        kennelCoughPlay.addActionListener(event -> {
             playAudio(kennelCoughAudio);});

        heartFailurePlay.addActionListener(event -> {
            playAudio(heartFailureAudio); });

        fluPlay.addActionListener(event -> {
            playAudio(fluAudio); });

        diagnose.addActionListener(event -> {
            System.out.println("Success44"); });
*/

        //Set general JFrame properties
        setVisible(true);

    }

   /* public void playAudio(String path)
    {
        //create a new Media object using the file path specified in the call to playAudio
        //this will become the audio clip object we wish to play

       Media audioClip = (new File(path).toURI().toString());

        //create a new MediaPlayer object that will be used to play the audio clip

        mediaPlayer = new MediaPlayer(audioClip);

		/*when the clip has played to completion, the code below ensures that the JavaFX thread will terminate
		 I have commented it out though because you generally want a JavaFX thread to keep operating
		 after an audio file has been fully played, but a JavaFX thread won't terminate automatically
	     without a call to Platform.exit() or System.exit(). So, if you run this program with the code below commented out,
		 the JavaFX thread will continue after the audio clip has played meaning you can press the button again and again
		 to replay the audio - if you uncomment it, exceptions are thrown after the first few presses because the
		 audio requires JavaFX libraries which are no longer available as the thread they run on is terminated
		 The other button, for random number generation, based on the swing event-dispatch thread, continues to operate
		 as normal though, even with exceptions being thrown for the other thread*/

		/*mediaPlayer.setOnEndOfMedia(new Runnable() {
 			 public void run() {
		    	Platform.exit();
		  	}
		});*/

        /*now actually play the audio clip - some exception-handling code to attempt to play the .wav audio clip associated with audioFile1.
         *If it succeeds, you will hear the sound of a gunshot, otherwise it fails either because the audio clip could not be found, or the
         *MediaPlayer object had some difficulty in actually playing the file. If it fails, the "catch" clause executes and an error message
         *is displayed to the console*/
/*
        try
        {
            mediaPlayer.play();
        }
        catch(Exception e)
        {
            System.out.println("The audio file " + path + " could not be played!");
        }

    }  */

    public static void main(String[] args) {
        BreathingGUI test = new BreathingGUI(1,"Peach","cat");
    }

}
