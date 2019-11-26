import javax.swing.*;
import java.awt.*;

public class SymptomSelectGUI extends JFrame {
    private JMenu back;
    private JLabel lblSelect,lblSymptom;
    private JComboBox cmbPet, cmbSymptom;
    private JButton btnDiagnose;
    private String[] pets = {"Peach -- (dog)","Oscar -- (cat)"};
    private String[] symptoms = {"Cough","Skin Problem"};

    public SymptomSelectGUI(){


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        back = new JMenu("Back");



        //define the components declared above
        lblSelect = new JLabel("Select Pet:");
        lblSymptom= new JLabel("Select Symptom:");
        cmbPet = new JComboBox(pets);
        cmbSymptom = new JComboBox(symptoms);
        btnDiagnose = new JButton("Submit");

        //create dimension objects to hold the preferred width and height for the specified components
        Dimension dSelect = lblSelect.getPreferredSize();
        Dimension dSymptom = lblSymptom.getPreferredSize();
        Dimension dcmbSymptom = cmbPet.getPreferredSize();
        Dimension dPet = cmbSymptom.getPreferredSize();

        //set the locations and dimensions of the components using the dimensions created above
        lblSelect.setBounds(100,30,dSelect.width,dSelect.height);
        lblSymptom.setBounds(100,66,dSymptom.width,dSymptom.height);
        cmbPet.setBounds(200,27,125,dcmbSymptom.height);   //give the text boxes a slightly lower y value to give the appearance of them being inline with the corresponding label rather than aligned with their top left corners
        cmbSymptom.setBounds(200,57,125,dPet.height);   //specify a specific width for the JTextField since the preferred width is too narrow, set the combo box to the same for aesthetic purposes
        btnDiagnose.setBounds(150,150,125,50);

        //add the components to the JFrame
        add(lblSelect);
        add(lblSymptom);
        add(cmbPet);
        add(cmbSymptom);
        add(btnDiagnose);


        //Set general JFrame properties
        setSize(500,500);
        setLocation(500,250);
        setTitle("Vitaliti Vet - Select Symptom");
        setLayout(null);

        btnDiagnose.addActionListener(event -> {
            if(cmbPet.getSelectedIndex()==0 && cmbSymptom.getSelectedIndex()==1)
            {
                SkinGUI dogSkin = new SkinGUI(1,"Peach","dog");
                this.setVisible(false);
                dogSkin.setVisible(true);
            }
            else if(cmbPet.getSelectedIndex()==1 && cmbSymptom.getSelectedIndex()==1)
            {
                SkinGUI catSkin = new SkinGUI(2,"Oscar","cat");
                this.setVisible(false);
                catSkin.setVisible(true);
            }
            else if(cmbPet.getSelectedIndex()==0 && cmbSymptom.getSelectedIndex()==1)
            {
                BreathingGUI breathingDog = new BreathingGUI(1,"Peach","dog");
                this.setVisible(false);
                breathingDog.setVisible(true);
            }
            else if(cmbPet.getSelectedIndex()==1 && cmbSymptom.getSelectedIndex()==1)
            {
                BreathingGUI breathingCat = new BreathingGUI(2,"Oscar","cat");
                this.setVisible(false);
                breathingCat.setVisible(true);
            }


        });

    }
}
