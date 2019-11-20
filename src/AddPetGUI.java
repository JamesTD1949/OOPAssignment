//import statements
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPetGUI extends MainGUI {
    //declare components that will be used in the gui as attributes
    private JLabel name,type,dob;
    private JTextField petName;
    private JComboBox petType;
    private JButton submit;
    //private DatePicker petDOB;
    //create an array of string to hold the options for the petType combo box -- only two options due to time constraints
    private String[] pets = {"dog","cat"};

    public AddPetGUI(){



        //define the components declared above
        name = new JLabel("Pet Name:");
        type = new JLabel("Pet Type:");
        dob = new JLabel("Date of Birth:");
        petName = new JTextField("");
        petType = new JComboBox(pets);
        submit = new JButton("Submit");
        //petDOB = new DatePicker();


        //create dimension objects to hold the preferred width and height for the specified components
        Dimension dName = name.getPreferredSize();
        Dimension dType = type.getPreferredSize();
        //Dimension dDob = dob.getPreferredSize();
        Dimension dPetName = petName.getPreferredSize();
        Dimension dPetType = petType.getPreferredSize();

        //set the locations and dimensions of the components using the dimensions created above
        name.setBounds(100,30,dName.width,dName.height);
        //dob.setBounds(100,30,dDob.width,dDob.height);
        type.setBounds(100,66,dType.width,dType.height);
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

        submit.addActionListener(event -> {
            int i;
            System.out.println("The text in pet textfield is: " + petName.getText());
                if (petName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pet name field must be entered.", "No Pet Name", JOptionPane.ERROR_MESSAGE);
                    return;
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
                        super.pets.add(temp);
                        String output = "";
                        for(Pet p:super.pets)
                        {
                            output+=p.toString();
                        }



                        System.out.print(output);

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Pet name field can only contain letters.", "Invalid Pet Name", JOptionPane.ERROR_MESSAGE);
                        return;

                    }

                    }



        });

    }

    public static void main(String[] args) {
        AddPetGUI test = new AddPetGUI();
    }




}
