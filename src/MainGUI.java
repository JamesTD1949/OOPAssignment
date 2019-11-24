import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MainGUI extends JFrame //implements ActionListener
{
    private JMenu fileMenu,PetsMenu,DiagnoseMenu;
    public static ArrayList<Pet> pets = new ArrayList<Pet>();
    public static ArrayList<Diagnose> diagnoses = new ArrayList<Diagnose>();
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
        Container cPane;

        //set the frame properties
        setTitle     ("Vitaliti Vet - Home");
        setSize      (1100,500);
        setResizable (false);
        setLocation  (500,250);
        ImageIcon icon = new ImageIcon("C:\\Users\\johnd\\IdeaProjects\\OOPAssignment\\Images+Sounds\\HomePage.jpg");
        JLabel label = new JLabel(icon);
        add(label);
        // shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

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


    private JMenu createFileMenu() {
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

        return fileMenu;

    }

    private JMenu createPetsMenu() {
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
        item.addActionListener(event -> {System.out.println("View Pets");});
        PetsMenu.add( item );

        item = new JMenuItem("Delete Pet");    //Delete Pets
        item.addActionListener(event -> {System.out.println("Delete Pet");});
        PetsMenu.add( item );

        return  PetsMenu;
    } // end createEditMenu

    private JMenu createDiagnoseMenu() {
            JMenuItem    item;

            DiagnoseMenu = new JMenu("Diagnose");

            item = new JMenuItem("Diagnose");      //Diagnose
            item.addActionListener(event -> {
                SymptomSelectGUI test = new SymptomSelectGUI();
                frame.setVisible(false);
                test.setVisible(true);
            });
            DiagnoseMenu.add( item );

            item = new JMenuItem("View Diagnoses");    //View Diagnoses
            item.addActionListener(event -> {System.out.println("View Diagnoses");});
            DiagnoseMenu.add( item );

            return DiagnoseMenu;
            } // end createEditMenu




} // end class
