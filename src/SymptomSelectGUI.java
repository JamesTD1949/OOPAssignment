import javax.swing.*;
import java.awt.*;

public class SymptomSelectGUI extends JFrame {
    private JComboBox cmbPet, cmbSymptom;
    private String[] petArray;

    public SymptomSelectGUI(){
        //Set general JFrame properties
        setSize(500,500);
        setLocation(500,250);
        setTitle("Vitaliti Vet - Select Symptom");
        setLayout(null);

        populateArray();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        JMenu backM = new JMenu("Navigation");
        menuBar.add(backM);
        JMenuItem back = new JMenuItem("Back");
        backM.add(back);

        back.addActionListener(event -> {this.setVisible(false); MainGUI.frame.setVisible(true);});

        //Create an array of String to hold values for Symptoms combo box
        String[] symptoms = {"Cough","Skin Problem"};
        //define the components declared above
        JLabel lblSelect = new JLabel("Select Pet:");
        JLabel lblSymptom= new JLabel("Select Symptom:");
        cmbPet = new JComboBox(petArray);
        cmbSymptom = new JComboBox(symptoms);
        JButton btnDiagnose = new JButton("Submit");

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

        btnDiagnose.addActionListener(event -> {
            if(cmbSymptom.getSelectedIndex()==0)
            {
                new BreathingGUI(MainGUI.pets.get(cmbPet.getSelectedIndex()));
            }
            else
            {
                new SkinGUI(MainGUI.pets.get(cmbPet.getSelectedIndex()));
            }
        });
    }

    private void populateArray(){
        petArray = new String[MainGUI.pets.size()];
        for(int i=0;i<MainGUI.pets.size();i++)
        {
            String name =  MainGUI.pets.get(i).getName();
            System.out.println(name);
            petArray[i] = name;
        }
    }
}
