//import statements
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

class AddPetGUI extends JFrame{
    private JTextField petName;
    private JComboBox petType;

    AddPetGUI(){
        //Set general JFrame properties
        setSize(500,500);
        setTitle("Vitaliti Vet - Add Pet");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocation(500,250);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        JMenu backM = new JMenu("Navigation");
        menuBar.add(backM);
        JMenuItem back = new JMenuItem("Back");
        backM.add(back);
        back.addActionListener(event -> {this.setVisible(false); MainGUI.frame.setVisible(true);});


        //Create an array of Strings to hold the petOptions for the pet type combo box -- only two due to time constraints
        String[] petOptions = {"dog","cat"};
        //define the components declared above
        JLabel name = new JLabel("Pet Name:");
        JLabel type = new JLabel("Pet Type:");
        petName = new JTextField("");
        petType = new JComboBox(petOptions);
        JButton submit = new JButton("Submit");


        //create dimension objects to hold the preferred width and height for the specified components
        Dimension dName = name.getPreferredSize();
        Dimension dPetName = petName.getPreferredSize();
        Dimension dPetType = petType.getPreferredSize();

        //set the locations and dimensions of the components using the dimensions created above
        name.setBounds(100,30,dName.width,dName.height);
        type.setBounds(100,66,dName.width,dName.height);
        petName.setBounds(200,27,125,dPetName.height);   //give the text boxes a slightly lower y value to give the appearance of them being inline with the corresponding label rather than aligned with their top left corners
        petType.setBounds(200,57,125,dPetType.height);   //specify a specific width for the JTextField since the preferred width is too narrow, set the combo box to the same for aesthetic purposes
        submit.setBounds(150,150,125,50);

        //add the components to the JFrame
        add(name);
        add(type);
        add(petName);
        add(petType);
        add(submit);

        submit.addActionListener(event -> {
            int i;
            System.out.println("The text in pet textfield is: " + petName.getText());
                if (petName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Pet name field must be entered.", "No Pet Name", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    for(i=0;i<petName.getText().length();)
                    {
                        char c = petName.getText().charAt(i);
                        System.out.println(c);


                        if(!Character.isLetter(c))
                            { break; }
                        i++;
                    }
                    if(i==petName.getText().length())
                        {
                        Pet temp = new Pet(petName.getText(), Objects.requireNonNull(petType.getSelectedItem()).toString());
                        System.out.println(temp.getId());
                        MainGUI f = (MainGUI) MainGUI.getMainGUIFrame();
                        ArrayList<Pet> pets = f.getPets();
                        pets.add(temp);
                        JOptionPane.showMessageDialog(null, petName.getText() + "has been added to the system.", "Pet Added", JOptionPane.INFORMATION_MESSAGE);
                        }
                    else
                        {
                        JOptionPane.showMessageDialog(null, "Pet name field can only contain letters.", "Invalid Pet Name", JOptionPane.ERROR_MESSAGE);
                        }

                    }
        });

    }
}
