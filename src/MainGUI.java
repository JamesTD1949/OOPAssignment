import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MainGUI extends JFrame implements ActionListener
{
    JMenu fileMenu;
    JMenu PetsMenu;
    JMenu DiagnoseMenu;
    public ArrayList<Pet> pets = new ArrayList<Pet>();
    public ArrayList<Diagnose> diagnoses = new ArrayList<Diagnose>();

    public ArrayList<Pet> getPets()
    {
        return pets;
    }

    public static void main(String[] args) {
        MainGUI frame = new MainGUI();
        frame.setVisible(true);
    }

    public MainGUI() {
        Container cPane;

        //set the frame properties
        setTitle     ("Vitaliti Vet - Home");
        setSize      (1100,500);
        setResizable (false);
        setLocation  (500,500);
        ImageIcon icon = new ImageIcon("C:\\Users\\t00192739\\IdeaProjects\\OOPAssignment\\Images+Sounds\\HomePage.jpg");
        JLabel label = new JLabel(icon);
        add(label);
        // shut down the program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cPane = getContentPane( );
        cPane.setLayout(new FlowLayout());

        //invoke a user-written method create two menus and their menu items
        // done by separate method to make the constructor shorter
        createFileMenu();
        createPetsMenu();
        createDiagnoseMenu();


        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(new Color(115,170,10));
        menuBar.add(fileMenu);
        menuBar.add(PetsMenu);
        menuBar.add(DiagnoseMenu);
    } // end constructor

    /** when an item is clicked, response starts here */
    public void actionPerformed(ActionEvent e) {
        String pressed;
        pressed = e.getActionCommand();

        switch(pressed)
        {
            case "New":
                break;
            case "Open...":
                System.out.println("Open...");
                break;
            case "Save":
                System.out.println("Save");
                break;
            case "Save As...":
                System.out.println("Save As...");
                break;
            case "Add Pet":
               /* AddPetGUI test = new AddPetGUI();
                test.setVisible(true);
                this.setVisible(false);  */
               System.out.println("Add Pet");
               break;
            case "View Pets":
                System.out.println("View Pets");
                break;
            case "Delete Pet":
                System.out.println("Delete Pet");
                break;
            case "Diagnose":
                System.out.println("Diagnose");
                break;
            case "View Diagnoses":
                System.out.println("View Diagnoses");
                break;
        }


    } // end actionPerformend

    /**  Creates File menu and its menu items */
    public void createFileMenu( ) {
        JMenuItem    item; // declare a re-usable JMenuItem object

        // first, create the menu: then you can start on the items
        fileMenu = new JMenu("File");

        // create the first item
        item = new JMenuItem("New");        //New
        // make sure the program is listening for clicks: handle them in 'this' class
        item.addActionListener( this );
        // attach the item to the menu
        fileMenu.add( item );

        // repeat for all the other menu items in the File menu
        item = new JMenuItem("Open...");    //Open...
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save");       //Save
        item.addActionListener( this );
        fileMenu.add( item );

        item = new JMenuItem("Save As..."); //Save As...
        item.addActionListener( this );
        fileMenu.add( item );

    } // end createFileMenu

    public void createPetsMenu( ) {
        JMenuItem    item;

        PetsMenu = new JMenu("Pets");

        item = new JMenuItem("Add Pet");      //Add Pet
        item.addActionListener( this );
        PetsMenu.add( item );

        item = new JMenuItem("View Pets");    //View Pets
        item.addActionListener( this );
        PetsMenu.add( item );

        item = new JMenuItem("Delete Pet");    //Delete Pets
        item.addActionListener( this );
        PetsMenu.add( item );
    } // end createEditMenu

    public void createDiagnoseMenu( ) {
            JMenuItem    item;

            DiagnoseMenu = new JMenu("Diagnose");

            item = new JMenuItem("Diagnose");      //Diagnose
            item.addActionListener( this );
            DiagnoseMenu.add( item );

            item = new JMenuItem("View Diagnoses");    //View Diagnoses
            item.addActionListener( this );
            DiagnoseMenu.add( item );
            } // end createEditMenu




} // end class
