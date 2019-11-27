//import statements


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddPetGUI extends JFrame {
    //declare components that will be used in the gui as attributes
    private JLabel name;
    private JLabel type;
    //private JLabel dob;
    private JTextField petName;
    private JComboBox petType;
    private JButton submit;
    //private DatePicker petDOB;
    //create an array of string to hold the options for the petType combo box -- only two options due to time constraints
    private String[] petOptions = {"dog","cat"};

    public AddPetGUI(){


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));

        JMenu backM = new JMenu("Navigation");
        menuBar.add(backM);
        JMenuItem back = new JMenuItem("Back");
        backM.add(back);


        back.addActionListener(event -> {this.setVisible(false); MainGUI.frame.setVisible(true);});



        //define the components declared above
        name = new JLabel("Pet Name:");
        type = new JLabel("Pet Type:");
        //dob = new JLabel("Date of Birth:");
        petName = new JTextField("");
        petType = new JComboBox(petOptions);
        submit = new JButton("Submit");
        //petDOB = new DatePicker();


        //create dimension objects to hold the preferred width and height for the specified components
        Dimension dName = name.getPreferredSize();
        Dimension dPetName = petName.getPreferredSize();
        Dimension dPetType = petType.getPreferredSize();

        //set the locations and dimensions of the components using the dimensions created above
        name.setBounds(100,30,dName.width,dName.height);
        //dob.setBounds(100,30,dDob.width,dDob.height);
        type.setBounds(100,66,dName.width,dName.height);
        petName.setBounds(200,27,125,dPetName.height);   //give the text boxes a slightly lower y value to give the appearance of them being inline with the corresponding label rather than aligned with their top left corners
        petType.setBounds(200,57,125,dPetType.height);   //specify a specific width for the JTextField since the preferred width is too narrow, set the combo box to the same for aesthetic purposes
        submit.setBounds(150,150,125,50);

        //add the components to the JFrame
        add(name);
        add(type);
        //add(dob);
        add(petName);
        add(petType);
        add(submit);


        //Set general JFrame properties
        setSize(500,500);
        setTitle("Vitaliti Vet - Add Pet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocation(500,250);
        setResizable(false);

        submit.addActionListener(event -> {
            int i;
            System.out.println("The text in pet textfield is: " + petName.getText());
                if (petName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pet name field must be entered.", "No Pet Name", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    for(i=0;i<petName.getText().length();i++)
                    {
                        Character c = petName.getText().charAt(i);
                        System.out.println(c);

                        if(!Character.isLetter(c))
                            {
                            break;
                            }



                    }
                    if(i==petName.getText().length())
                        {
                        Pet temp = new Pet(petName.getText(), petType.getSelectedItem().toString());
                        MainGUI f = (MainGUI) MainGUI.getMainGUIFrame();
                        ArrayList<Pet> pets = f.getPets();
                        pets.add(temp);
                        }
                    else
                        {
                        JOptionPane.showMessageDialog(null, "Pet name field can only contain letters.", "Invalid Pet Name", JOptionPane.ERROR_MESSAGE);
                        }

                    }



        });

    }

    public static void main(String[] args) {
        AddPetGUI test = new AddPetGUI();
    }




}
