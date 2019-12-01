import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BreathingGUI extends JFrame{

    private String kennelCoughAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing.wav";
    private String heartFailureAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\pug-breathing2.wav";
    private String fluAudio = "C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\Labrador-breathing.wav";
    private JRadioButton severity1;
    private JRadioButton severity2;
    private JRadioButton severity3;
    private JRadioButton severity4;
    private JRadioButton severity5;
    private JRadioButton kennelCough;
    private JRadioButton heartFailure;
    private JRadioButton flu;

    BreathingGUI(Pet pet) {
        setSize(650, 600);
        setTitle("Vitaliti Vet - Diagnose Breathing Condition");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 250);
        setResizable(false);
        setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        JMenu backM = new JMenu("Navigation");
        menuBar.add(backM);
        JMenuItem back = new JMenuItem("Back");
        backM.add(back);
        back.addActionListener(event -> {this.setVisible(false); MainGUI.frame.setVisible(true);});

        //define the components declared above
        JLabel severity = new JLabel("Severity(low to high):");
        JButton diagnose = new JButton("Diagnose");
        severity1 = new JRadioButton("1");
        severity2 = new JRadioButton("2");
        severity3 = new JRadioButton("3");
        severity4 = new JRadioButton("4");
        severity5 = new JRadioButton("5");
        kennelCough = new JRadioButton("Kennel Cough");
        heartFailure = new JRadioButton("Heart Failure");
        flu = new JRadioButton("Flu");
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

        ImageIcon breathingImage = new ImageIcon("C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_breathing.jpg");
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

        AudioFilePlayer player = new AudioFilePlayer();

        kennelCoughPlay.addActionListener(event -> player.playAudio(kennelCoughAudio));
        heartFailurePlay.addActionListener(event -> player.playAudio(heartFailureAudio));
        fluPlay.addActionListener(event -> player.playAudio(fluAudio));

        diagnose.addActionListener(event -> {
                    MainGUI f = (MainGUI) MainGUI.getMainGUIFrame();
                    ArrayList<Diagnose> diagnoses = f.getDiagnoses();
                    if (getBreathingText().equals("None")) {
                        JOptionPane.showMessageDialog(null, "No Breathing Condition Selected", "Selection Error", JOptionPane.ERROR_MESSAGE);
                    } else if (getSeverity() == 0) {
                        JOptionPane.showMessageDialog(null, "No Severity Selected", "Selection Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (getBreathingText()) {
                            case "Kennel Cough":
                                if (getSeverity() < 3)
                                    JOptionPane.showMessageDialog(null, "Keep in overnight and administer fluids via IV Drip.");
                                else if (getSeverity() == 3)
                                    JOptionPane.showMessageDialog(null, "Administer Azithromycin and keep in overnight.");
                                else
                                    JOptionPane.showMessageDialog(null, "Administer Doxycycline and keep in overnight..");
                                break;
                            case "Heart Failure":
                                if (getSeverity() < 3)
                                    JOptionPane.showMessageDialog(null, "Take no action but moniter closely -- readmit immiedietly if symptoms worsen.");
                                else if (getSeverity() == 3)
                                    JOptionPane.showMessageDialog(null, "Give Pet oxygen therapy to improve circulation.");
                                else
                                    JOptionPane.showMessageDialog(null, "Schedule Heart Surgery to remove fluids from chest.");
                                break;
                            case "Flu":
                                if (getSeverity() < 3)
                                    JOptionPane.showMessageDialog(null, "Give plenty of water and bring back if not better in two weeks for flu shot.");
                                else if (getSeverity() == 3)
                                    JOptionPane.showMessageDialog(null, "Give antibiotic to clear airways and bring back in 3 days.");
                                else
                                    JOptionPane.showMessageDialog(null, "Keep overnight and administer fluids via IP Drip.");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "This message should never be seen.");
                                break;
                        }
                        Diagnose temp = new Diagnose(pet.getId(),getBreathingText(),getSeverity());
                        diagnoses.add(temp);
                        StringBuilder output= new StringBuilder();
                        for(Diagnose d:diagnoses)
                            {
                            output.append(d.toString());
                            }
                        System.out.print(output);
                        }
                    });
    }

    private String getBreathingText()
    {
        if(kennelCough.isSelected())
            return kennelCough.getText();
        else if(flu.isSelected())
            return flu.getText();
        else if(heartFailure.isSelected())
            return heartFailure.getText();
        else
            return "None";
                }

    private int getSeverity()
    {
        if(severity1.isSelected())
            return 1;
        else if(severity2.isSelected())
            return 2;
        else if(severity3.isSelected())
            return 3;
        else if(severity4.isSelected())
            return 4;
        else if(severity5.isSelected())
            return 5;
        else
            return 0;

    }
}