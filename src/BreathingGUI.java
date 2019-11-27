

//import javafx..media.jfxmedia.MediaPlayer;

import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javafx.embed.swing.JFXPanel;

public class BreathingGUI extends JFrame {


    private String kennelCoughAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing.wav";
    private String heartFailureAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing2.wav";
    private String fluAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\Labrador-breathing.wav";

    public BreathingGUI(Pet pet) {
        setSize(650, 600);
        setTitle("Vitaliti Vet - Diagnose Breathing Condition");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 250);
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

        ImageIcon breathingImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_breathing.jpg");
        JLabel breathing = new JLabel(breathingImage);

        //create dimension objects to hold the preferred width and height for the specified components
        Dimension label = severity.getPreferredSize();
        Dimension radio = kennelCough.getPreferredSize();
        Dimension image = breathing.getPreferredSize();


        //set the locations and dimensions of the components using the dimensions created above
        breathing.setBounds(200, 30, image.width, image.height);
        kennelCough.setBounds(50, 250, radio.width, radio.height);
        heartFailure.setBounds(50, 300, radio.width, radio.height);
        flu.setBounds(50, 350, radio.width, radio.height);
        kennelCoughPlay.setBounds(200, 250, 300, 30);
        heartFailurePlay.setBounds(200, 300, 300, 30);
        fluPlay.setBounds(200, 350, 300, 30);
        severity.setBounds(50, 400, label.width, label.height);
        severity1.setBounds(170, 400, radio.width, radio.height);
        severity2.setBounds(270, 400, radio.width, radio.height);
        severity3.setBounds(370, 400, radio.width, radio.height);
        severity4.setBounds(470, 400, radio.width, radio.height);
        severity5.setBounds(570, 400, radio.width, radio.height);
        diagnose.setBounds(225, 450, 200, 45);


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

       /* AudioFilePlayer player = new AudioFilePlayer();

        kennelCoughPlay.addActionListener(event -> {
             player.playAudio(kennelCoughAudio);});

        heartFailurePlay.addActionListener(event -> {
            playAudio(heartFailureAudio); });

        fluPlay.addActionListener(event -> {
            playAudio(fluAudio); });

        diagnose.addActionListener(event -> {
            System.out.println("Success44"); });


        //Set general JFrame properties
        setVisible(true);

    }



    public static void main(String[] args) {

        Pet peach = new Pet("Peach","dog");
        BreathingGUI test = new BreathingGUI(peach);

        //In order to avoid an "initialization exception" it is necessary to initiate the JavaFX Runtime when the application is started
        //I am initialising here by creating a "dummy" JFXPanel() object
        //You MUST add this line of code to your own main() method for your project if you are going to use this class

        JFXPanel fxPanel = new JFXPanel();
    }

}


        */


    }
}