import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SkinGUI extends JFrame{
    private JRadioButton skinTag;
    private JRadioButton cyst;
    private JRadioButton flea;
    private JRadioButton balding;
    private JRadioButton severity1;
    private JRadioButton severity2;
    private JRadioButton severity3;
    private JRadioButton severity4;
    private JRadioButton severity5;

    public SkinGUI(Pet pet)
    {
        //define the components declared above
        JLabel severity = new JLabel("Severity(low to high):");
        JButton diagnose = new JButton("Diagnose");
        skinTag = new JRadioButton("Skin Tag");
        cyst = new JRadioButton("Cyst");
        flea = new JRadioButton("Flea");
        balding = new JRadioButton("Balding");
        severity1 = new JRadioButton("1");
        severity2 = new JRadioButton("2");
        severity3 = new JRadioButton("3");
        severity4 = new JRadioButton("4");
        severity5 = new JRadioButton("5");

        ButtonGroup condition = new ButtonGroup();
        condition.add(skinTag);
        condition.add(cyst);
        condition.add(flea);
        condition.add(balding);

        ButtonGroup severityGroup = new ButtonGroup();
        severityGroup.add(severity1);
        severityGroup.add(severity2);
        severityGroup.add(severity3);
        severityGroup.add(severity4);
        severityGroup.add(severity5);

        //create image icons to contain images and assign the icons to a Jlabel for display purposes
        ImageIcon partHairImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\check_dogskin.jpg");
        JLabel partHair = new JLabel(partHairImage);

        ImageIcon skinTagImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_skintag.jpg");
        JLabel lblSkinTag = new JLabel(skinTagImage);

        ImageIcon cystImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_cyst.jpg");
        JLabel lblCyst = new JLabel(cystImage);

        ImageIcon fleaImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_flea.jpg");
        JLabel lblFlea = new JLabel(fleaImage);

        ImageIcon baldingImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\" + pet.getType() + "_balding.jpg");
        JLabel lblBalding = new JLabel(baldingImage);



        //create dimension objects to hold the preferred width and height for the specified components
        Dimension label = severity.getPreferredSize();
        Dimension radio = skinTag.getPreferredSize();
        Dimension imagePartHair = partHair.getPreferredSize();
        Dimension image = lblSkinTag.getPreferredSize();


        //set the locations and dimensions of the components using the dimensions created above
        severity.setBounds(50,600,label.width,label.height);
        diagnose.setBounds(300,700,200,50);
        skinTag.setBounds(50,525,radio.width,radio.height);
        cyst.setBounds(250,525,radio.width,radio.height);
        flea.setBounds(450,525,radio.width,radio.height);
        balding.setBounds(650,525,radio.width,radio.height);
        severity1.setBounds(175,600,radio.width,radio.height);
        severity2.setBounds(300,600,radio.width,radio.height);
        severity3.setBounds(425,600,radio.width,radio.height);
        severity4.setBounds(550,600,radio.width,radio.height);
        severity5.setBounds(675,600,radio.width,radio.height);
        partHair.setBounds(60,30,imagePartHair.width,imagePartHair.height);
        lblSkinTag.setBounds(50,350,image.width,image.height);
        lblCyst.setBounds(250,350,image.width,image.height);
        lblFlea.setBounds(450,350,image.width,image.height);                   //ISSUE HERE ISSUE HERE
        lblBalding.setBounds(650,350,image.width,image.height);



        //add the components to the JFrame
        add(severity);
        add(diagnose);
        add(skinTag);
        add(cyst);
        add(flea);
        add(balding);
        add(severity1);
        add(severity2);
        add(severity3);
        add(severity4);
        add(severity5);
        add(partHair);
        add(lblBalding);
        add(lblSkinTag);
        add(lblCyst);
        add(lblFlea);


        diagnose.addActionListener(event -> {
            MainGUI f = (MainGUI) MainGUI.getMainGUIFrame();
            ArrayList<Diagnose> diagnoses = f.getDiagnoses();
            if(getSkinText().equals("None"))
            {
                JOptionPane.showMessageDialog(null,"No Skin Condition Selected","Selection Error",JOptionPane.ERROR_MESSAGE);
            }
            else if(getSeverity()==0)
            {
                JOptionPane.showMessageDialog(null,"No Severity Selected","Selection Error",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                switch (getSkinText())
                {
                    case "Skin Tag":
                        if(getSeverity()<3)
                            JOptionPane.showMessageDialog(null,"Take no action but re-examine if Skin Tag gets bigger.");
                        if(getSeverity()==3)
                            JOptionPane.showMessageDialog(null,"Take Sample to send for analysis.");
                        else
                            JOptionPane.showMessageDialog(null,"Schedule Surgery to remove Skin Tag.");
                        break;
                    case "Cyst":
                        if(getSeverity()<3)
                            JOptionPane.showMessageDialog(null,"Administer anti-inflammatory injection and re-examine in two weeks.");
                        if(getSeverity()==3)
                            JOptionPane.showMessageDialog(null,"Take Sample to send for analysis.");
                        else
                            JOptionPane.showMessageDialog(null,"Schedule Surgery to remove Cyst.");
                        break;
                    case "Flea":
                        if(getSeverity()<3)
                            JOptionPane.showMessageDialog(null,"Give Flea Bath and groom regularly.");
                        if(getSeverity()==3)
                            JOptionPane.showMessageDialog(null,"Give Flea Bath, worm dose and 2 week supply of vitamin supplements.");
                        else
                            JOptionPane.showMessageDialog(null,"Shave fur,give blood transfusion and overnight care.");
                        break;
                    case "Balding":
                        if(getSeverity()<3)
                            JOptionPane.showMessageDialog(null,"Give Skin Cream and re-examine in two weeks.");
                        if(getSeverity()==3)
                            JOptionPane.showMessageDialog(null,"Take blood test to send to endocrinologist to check for allergies.");
                        else
                            JOptionPane.showMessageDialog(null,"Give antibiotics and re-examine in 5 days.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"This message should never be seen.");
                        break;



                }
                Diagnose temp = new Diagnose(pet.getId(),getSkinText(),getSeverity());
                diagnoses.add(temp);
                String output="";
                for(Diagnose d:diagnoses)
                {
                    output+=d.toString();
                }



                System.out.print(output);
            }


        });


        //Set general JFrame properties
        setSize(850,850);
        setTitle("Vitaliti Vet - Diagnose Skin Condition");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500,250);
        setResizable(false);
    }

    public static void main(String[] args) {
        Pet peach = new Pet("Peach","dog");
        SkinGUI test = new SkinGUI(peach);
    }

    private String getSkinText()
    {
        if(skinTag.isSelected())
            return skinTag.getText();
        else if(cyst.isSelected())
            return cyst.getText();
        else if(flea.isSelected())
            return flea.getText();
        else if(balding.isSelected())
            return balding.getText();
        else
            return "None";
    }

    public int getSeverity()
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
