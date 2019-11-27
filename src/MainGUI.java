import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class MainGUI extends JFrame //implements ActionListener
{
    private JMenu fileMenu,PetsMenu,DiagnoseMenu;
    public static ArrayList<Pet> pets = new ArrayList<>();
    public static ArrayList<Diagnose> diagnoses = new ArrayList<>();
    static MainGUI frame;

    public ArrayList<Pet> getPets()
    {
        return pets;
    }
    public ArrayList<Diagnose> getDiagnoses()
    {
        return diagnoses;
    }

    public static void main(String[] args) {
        frame = new MainGUI();
        frame.setVisible(true);
    }

    public static JFrame getMainGUIFrame()

    {
        return frame;
    }
    public MainGUI() {


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



        //Invoke user written functions to create the JMenus and JMenuItems. I placed them into constructors to reduce the amount of code in MainGui's constructor.
        createFileMenu();
        createPetsMenu();
        createDiagnoseMenu();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        menuBar.add(fileMenu);
        menuBar.add(PetsMenu);
        menuBar.add(DiagnoseMenu);




    } // end constructor


    private void createFileMenu() {
        JMenuItem    item; // declare a re-usable JMenuItem object

        // first, create the menu: then you can start on the items
        fileMenu = new JMenu("File");

        // create the first item
        item = new JMenuItem("New");        //New
        // make sure the program is listening for clicks: handle them in 'this' class
        item.addActionListener(event -> {System.out.println("New");});
        // attach the item to the menu
        fileMenu.add( item );

        // repeat for all the other menu items in the File menu
        item = new JMenuItem("Open...");    //Open...
        item.addActionListener(event -> {System.out.println("Open...");});
        fileMenu.add( item );

        item = new JMenuItem("Save");       //Save
        item.addActionListener(event -> {System.out.println("Save");});
        fileMenu.add( item );

        item = new JMenuItem("Save As..."); //Save As...
        item.addActionListener(event -> {System.out.println("Save As...");});
        fileMenu.add( item );

        //return fileMenu;

    }

    private void createPetsMenu() {
        JMenuItem    item;

        PetsMenu = new JMenu("Pets");

        item = new JMenuItem("Add Pet");      //Add Pet
        item.addActionListener(event -> {
            AddPetGUI test = new AddPetGUI();
            frame.setVisible(false);
            test.setVisible(true);

        });
        PetsMenu.add( item );

        item = new JMenuItem("View Pets");    //View Pets
        item.addActionListener(event -> {
            if(pets.size()!=0) {
                String output = String.format("%20s%20s%20s\n%20s%20s%20s\n", "Pet ID", "Pet Name", "Pet Type", "------", "--------", "--------");
                for (int i = 0; i < pets.size(); i++) {
                    Pet iterator = pets.get(i);
                    output += String.format("%20d%20s%20s\n", iterator.getId(), iterator.getName(), iterator.getType());
                }
                JOptionPane.showMessageDialog(null, output);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"There are no pets in the system.","Can't Display Pets",JOptionPane.ERROR_MESSAGE);
            }
        });
        PetsMenu.add( item );

        item = new JMenuItem("Delete Pet");    //Delete Pets
        item.addActionListener(event -> {System.out.println("Delete Pet");});
        PetsMenu.add( item );

        //return  PetsMenu;
    } // end createEditMenu

    private void createDiagnoseMenu() {
            JMenuItem    item;

            DiagnoseMenu = new JMenu("Diagnose");

            item = new JMenuItem("Diagnose");      //Diagnose
            item.addActionListener(event -> {
                SymptomSelectGUI test = new SymptomSelectGUI();
                frame.setVisible(false);
                test.setVisible(true);
            });
            DiagnoseMenu.add(item);

            item = new JMenuItem("View Diagnoses");    //View Diagnoses
            item.addActionListener(event -> {
                if(diagnoses.size()!=0) {
                    String output = String.format("%20s%20s%20s%20s\n%20s%20s%20s%20s\n", "Diagnosis ID", "Condition", "Severity","Pet ID","Date", "------------", "---------", "--------","------","----");
                    for (int i = 0; i < diagnoses.size(); i++) {
                        Diagnose iterator = diagnoses.get(i);
                        String formattedDateOfDiagnosis = new SimpleDateFormat("dd/MMM/YYYY").format(iterator.getDate());
                        output += String.format("%20d%20s%20d%20d%20s\n", iterator.getId(), iterator.getCondition(), iterator.getSeverity(),iterator.getPetID(),formattedDateOfDiagnosis);
                    }
                    JOptionPane.showMessageDialog(null, output);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"There are no diagnoses in the system.","Can't Display Diagnoses",JOptionPane.ERROR_MESSAGE);
                }
            });
            DiagnoseMenu.add( item );

            //return DiagnoseMenu;
            } // end createEditMenu




} // end class
