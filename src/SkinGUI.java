import javax.swing.*;
import java.awt.*;

public class SkinGUI extends SymptomSelectGUI{
    private JRadioButton skinTag,cyst,flea,balding,severity1,severity2,severity3,severity4,severity5;
    private JLabel severity,partHair,lblSkinTag,lblCyst,lblFlea,lblBalding;
    private JButton diagnose;

    public SkinGUI()
    {
        //define the components declared above
        severity = new JLabel("Severity of Skin Condition(low to high):");
        diagnose = new JButton("diagnose");
        skinTag = new JRadioButton("Skin Tag");
        cyst = new JRadioButton("Cyst");
        flea = new JRadioButton("Flea");
        balding = new JRadioButton("Balding");
        severity1 = new JRadioButton("1");
        severity2 = new JRadioButton("2");
        severity3 = new JRadioButton("3");
        severity4 = new JRadioButton("4");
        severity5 = new JRadioButton("5");

        //create image icons to contain images and assign the icons to a Jlabel for display purposes
        ImageIcon partHairImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\check_dogskin.jpg");
        JLabel partHair = new JLabel(partHairImage);

        ImageIcon skinTagImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\cat_skintag.jpg");
        JLabel lblSkinTag = new JLabel(skinTagImage);

        ImageIcon cystImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\cat_cyst.jpg");
        JLabel lblCyst = new JLabel(cystImage);

        ImageIcon fleaImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\cat_flea.jpg");
        JLabel lblFlea = new JLabel(fleaImage);

        ImageIcon baldingImage = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\cat_balding.jpg");
        JLabel lblBalding = new JLabel(baldingImage);



        //create dimension objects to hold the preferred width and height for the specified components
        Dimension label = severity.getPreferredSize();
        Dimension radio = skinTag.getPreferredSize();
        Dimension button = diagnose.getPreferredSize();
        Dimension imagePartHair = partHair.getPreferredSize();
        Dimension image = lblSkinTag.getPreferredSize();


        //set the locations and dimensions of the components using the dimensions created above
        severity.setBounds(100,30,label.width,label.height);
        diagnose.setBounds(100,66,button.width,button.height);
        skinTag.setBounds(200,27,radio.width,radio.height);
        cyst.setBounds(200,57,radio.width,radio.height);
        flea.setBounds(150,150,radio.width,radio.height);
        balding.setBounds(150,150,radio.width,radio.height);
        severity1.setBounds(150,150,radio.width,radio.height);
        severity2.setBounds(150,150,radio.width,radio.height);
        severity3.setBounds(150,150,radio.width,radio.height);
        severity4.setBounds(150,150,radio.width,radio.height);
        severity5.setBounds(150,150,radio.width,radio.height);
        partHair.setBounds(200,30,imagePartHair.width,imagePartHair.height);
        lblBalding.setBounds(50,400,image.width,image.height);
        lblSkinTag.setBounds(250,400,image.width,image.height);
        lblCyst.setBounds(450,400,image.width,image.height);
        lblFlea.setBounds(650,400,image.width,image.height);



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


        //Set general JFrame properties
        setSize(850,500);
        setTitle("Vitaliti Vet - Diagnose Skin Condition");
    }

    public static void main(String[] args) {
        SkinGUI test = new SkinGUI();
    }

}
