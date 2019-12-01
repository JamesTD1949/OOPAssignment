import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class MainGUI extends JFrame implements Serializable
{
    //Declare attributes
    private JMenu fileMenu,PetsMenu,DiagnoseMenu;
    static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Diagnose> diagnoses = new ArrayList< >();
    static MainGUI frame;

    //declare two methods to return the contents of the two arraylists
    ArrayList<Pet> getPets()
    {
        return pets;
    }
    ArrayList<Diagnose> getDiagnoses()
    {
        return diagnoses;
    }

    //main method
    public static void main(String[] args) {
        //have to create a 'dummy' JFXPanel here in order to avoid an initialization error in BreathingGUI when any of the audio buttons is pressed
        JFXPanel fxPanel = new JFXPanel();
        //create MainGui frame to in order to enable navigation in conjunction with getMainGUIFrame below
        frame = new MainGUI();
        frame.setVisible(true);
    }//end of main method

    //user defined method that enables navigation back to MainGui from other GUI classes in conjunction with code above
    static JFrame getMainGUIFrame()
    {
        return frame;
    }//end getMainGUIFrame() static method

    private MainGUI() {
        //set the frame properties
        setTitle("Vitaliti Vet - Home");
        setSize(1100,500);
        setResizable(false);
        setLocation(500,250);
        ImageIcon icon = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\HomePage.jpg");
        JLabel label = new JLabel(icon);
        add(label);
        // shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Invoke user written functions to create the JMenus and JMenuItems. I placed them into constructors to reduce the amount of code in MainGui's null constructor.
        createFileMenu();
        createPetsMenu();
        createDiagnoseMenu();
        //Create a JMenuBar and add the menus created above to it
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        menuBar.add(fileMenu);
        menuBar.add(PetsMenu);
        menuBar.add(DiagnoseMenu);
    } // end MainGUI null constructor

    //constructor for file menu that contains save and open options for the two arraylists
    private void createFileMenu() {
        // declare a re-usable JMenuItem object
        JMenuItem item;
        //Create Menu before MenuItems
        fileMenu = new JMenu("File");
        // repeat for all the other menu items in the File menu
        item = new JMenuItem("Open Pets");
        //lambda expression containing event handling code for loading in pets
        item.addActionListener(event -> {
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try { fis= new FileInputStream("PetArrayList.data"); }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try { ois = new ObjectInputStream(fis); }
            catch (IOException e) {
                e.printStackTrace();
            }
            try { assert ois != null;
                pets = (ArrayList<Pet>) ois.readObject(); }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });//end of lambda expression
        fileMenu.add( item ); //Add Open Pets to FileMenu
        item = new JMenuItem("Save Pets");
        item.addActionListener(event -> {
            File outFile = new File("PetArrayList.data");
            FileOutputStream   outFileStream = null;
            try {
                outFileStream = new FileOutputStream(outFile);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,"File Not Found Exception occurred. See Stack Trace for more info.","File Not Found",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            ObjectOutputStream outObjectStream = null;
            try {
                outObjectStream = new ObjectOutputStream(outFileStream);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"IO Exception occurred. See Stack Trace for more info.","IO Exception",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            try {
                assert outObjectStream != null;
                outObjectStream.writeObject(pets);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"IO Exception occurred. See Stack Trace for more info.","IO Exception",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });//end of lambda
        fileMenu.add( item ); //Add Save Pets to File Menu
        item = new JMenuItem("Save Diagnoses");
        item.addActionListener(event -> {
            File outFile = new File("DiagnoseArrayList.data");
            FileOutputStream   outFileStream = null;
            try {
                outFileStream = new FileOutputStream(outFile);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null,"File Not Found Exception occurred. See Stack Trace for more info.","File Not Found",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            ObjectOutputStream outObjectStream = null;
            try {
                outObjectStream = new ObjectOutputStream(outFileStream);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"IO Exception occurred. See Stack Trace for more info.","IO Exception",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            try {
                assert outObjectStream != null;
                outObjectStream.writeObject(diagnoses);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"IO Exception occurred. See Stack Trace for more info.","IO Exception",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }); //end of lambda
        fileMenu.add( item ); //add save diagnoses to file menu
        item = new JMenuItem("Open Diagnoses");
        item.addActionListener(event -> {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try { fis= new FileInputStream("DiagnoseArrayList.data"); }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try { ois = new ObjectInputStream(fis); }
            catch (IOException e) {
                e.printStackTrace();
            }
            try { assert ois != null;
                diagnoses = (ArrayList<Diagnose>) ois.readObject(); }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });//end of lambda
        fileMenu.add(item);//add Open Diagnoses to File Menu
    }

    private void createPetsMenu() {
        JMenuItem item;
        PetsMenu = new JMenu("Pets");
        item = new JMenuItem("Add Pet");
        //add code inside lambda to create an instance of the AddPetUI class, make it visible and make the mainGUI invisible
        item.addActionListener(event -> {
            AddPetGUI test = new AddPetGUI();
            frame.setVisible(false);
            test.setVisible(true);
        });
        PetsMenu.add( item );
        item = new JMenuItem("View Pets");
        //add code inside lambda to check if the number of items in the pets Arraylist is 0 and if not display the items formatted into a tabular fashion
        item.addActionListener(event -> {
            if(pets.size()!=0) {
                StringBuilder output = new StringBuilder(String.format("%-30s%-30s%-30s\n%-35s%-35s%-35s\n", "Pet ID", "Pet Name", "Pet Type", "--------", "--------------", "------------"));
                for (Pet iterator : pets) {
                    output.append(String.format("%-35d%-35s%-35s\n", iterator.getId(), iterator.getName(), iterator.getType()));
                }
                JOptionPane.showMessageDialog(null, output.toString());
            }
            else
            {
                JOptionPane.showMessageDialog(null,"There are no pets in the system.","Can't Display Pets",JOptionPane.ERROR_MESSAGE);
            }
        });
        PetsMenu.add( item );
    } // end createPetsMenu

    private void createDiagnoseMenu() {
            JMenuItem    item;
            DiagnoseMenu = new JMenu("Diagnose");
            item = new JMenuItem("Diagnose");
            //add code inside lambda to check if the number of items in the pets Arraylist is 0 and if not create an instance of the SymptomSelectGUI class, make it visible and make the mainGUI invisible
            item.addActionListener(event -> {
                if(pets.size()!=0) {
                    SymptomSelectGUI test = new SymptomSelectGUI();
                    frame.setVisible(false);
                    test.setVisible(true);
                }//end if
                else{
                JOptionPane.showMessageDialog(null,"There are no pets in the system to Diagnose.","No Pets",JOptionPane.ERROR_MESSAGE);
                }
            });
            DiagnoseMenu.add(item);
            item = new JMenuItem("View Diagnoses");
            //add code inside lambda to check if the number of items in the diagnoses Arraylist is 0 and if not display the items formatted into a tabular fashion
            item.addActionListener(event -> {
                if(diagnoses.size()!=0) {
                    StringBuilder output = new StringBuilder(String.format("%-25s%-30s%-30s%-30s%-30s\n%-30s%-35s%-34s%-35s%-35s\n", "Diagnosis ID", "Condition", "Severity", "Pet ID", "Date", "-------------------", "--------------", "------------", "---------", "-------"));
                    for (Diagnose iterator : diagnoses) {
                        String dateAsString = iterator.getDate();
                        output.append(String.format("%-35d%-28s%-35d%-35d%-35s\n", iterator.getId(), iterator.getCondition(), iterator.getSeverity(), iterator.getPetID(), dateAsString));
                    }
                    JOptionPane.showMessageDialog(null, output.toString());
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"There are no diagnoses in the system.","Can't Display Diagnoses",JOptionPane.ERROR_MESSAGE);
                }
            });
            DiagnoseMenu.add( item );
            } // end createDiagnoseMenu
} // end class


