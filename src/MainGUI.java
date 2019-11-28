import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;


public class MainGUI extends JFrame implements Serializable// ActionListener
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
        item = new JMenuItem("New");
        //item.addActionListener(this);//New
        fileMenu.add( item );

        // repeat for all the other menu items in the File menu
        item = new JMenuItem("Open...");
        //item.addActionListener(this);//Open...
        fileMenu.add( item );

        item = new JMenuItem("Save");
        //item.addActionListener(this);//Save
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
                outObjectStream.writeObject(pets);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"IO Exception occurred. See Stack Trace for more info.","IO Exception",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
           /* try {
                outObjectStream.writeObject(diagnoses);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        });
        fileMenu.add( item );

        item = new JMenuItem("Save As...");
        //item.addActionListener(this);//Save As...

        item.addActionListener(event ->{
            File outFile = new File(JOptionPane.showInputDialog("Please enter the name of the savefile: "));
            FileOutputStream   outFileStream = null;
            try {
                outFileStream = new FileOutputStream(outFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ObjectOutputStream outObjectStream = null;
            try {
                outObjectStream = new ObjectOutputStream(outFileStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outObjectStream.writeObject(pets);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outObjectStream.writeObject(diagnoses);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileMenu.add( item );

    }

    private void createPetsMenu() {
        JMenuItem    item;

        PetsMenu = new JMenu("Pets");

        item = new JMenuItem("Add Pet");
        //item.addActionListener(this);//Add Pet
         item.addActionListener(event -> {
            AddPetGUI test = new AddPetGUI();
            frame.setVisible(false);
            test.setVisible(true);

        });
        PetsMenu.add( item );

        item = new JMenuItem("View Pets");
        //item.addActionListener(this);//View Pets
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

            item = new JMenuItem("Diagnose");
            //item.addActionListener(this);//Diagnose
            item.addActionListener(event -> {
                SymptomSelectGUI test = new SymptomSelectGUI();
                frame.setVisible(false);
                test.setVisible(true);
            });
            DiagnoseMenu.add(item);

            item = new JMenuItem("View Diagnoses");
            //item.addActionListener(this);//View Diagnoses
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

   /*public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()=="New"){
            System.out.println("New");
        }
        else if (e.getSource()=="Save"){
            File outFile = new File("PetArrayList.data");
            FileOutputStream   outFileStream = null;
            try {
                outFileStream = new FileOutputStream(outFile);
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            }
            ObjectOutputStream outObjectStream = null;
            try {
                outObjectStream = new ObjectOutputStream(outFileStream);
            } catch (IOException f) {
                f.printStackTrace();
            }
            try {
                outObjectStream.writeObject(pets);
            } catch (IOException f) {
                f.printStackTrace();
            }
            try {
                outObjectStream.writeObject(diagnoses);
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
        else if(e.getSource()=="Save As..."){
            File outFile = new File(JOptionPane.showInputDialog("Please enter the name of the savefile: "));
            FileOutputStream   outFileStream = null;
            try {
                outFileStream = new FileOutputStream(outFile);
            } catch (FileNotFoundException f) {
                f.printStackTrace();
            }
            ObjectOutputStream outObjectStream = null;
            try {
                outObjectStream = new ObjectOutputStream(outFileStream);
            } catch (IOException f) {
                f.printStackTrace();
            }
            try {
                outObjectStream.writeObject(pets);
            } catch (IOException f) {
                f.printStackTrace();
            }
            try {
                outObjectStream.writeObject(diagnoses);
            } catch (IOException f) {
                f.printStackTrace();
            }
        }
        else if(e.getSource()=="Open"){
            System.out.println("Open");
        }
        else if(e.getSource()=="Add Pet"){
            AddPetGUI test = new AddPetGUI();
            frame.setVisible(false);
            test.setVisible(true);
        }
        else if(e.getSource()=="View Pets"){
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
        }
        else if(e.getSource()=="Diagnose"){
            SymptomSelectGUI test = new SymptomSelectGUI();
            frame.setVisible(false);
            test.setVisible(true);
        }
        else{
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
        }
    }*/




} // end class
