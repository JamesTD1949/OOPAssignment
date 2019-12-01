import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class MainGUI extends JFrame implements Serializable
{
    private JMenu fileMenu,PetsMenu,DiagnoseMenu;
    static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Diagnose> diagnoses = new ArrayList< >();
    static MainGUI frame;

    ArrayList<Pet> getPets()
    {
        return pets;
    }
    ArrayList<Diagnose> getDiagnoses()
    {
        return diagnoses;
    }

    public static void main(String[] args) {
        frame = new MainGUI();
        frame.setVisible(true);
    }

    static JFrame getMainGUIFrame()

    {
        return frame;
    }
    MainGUI() {
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
        // repeat for all the other menu items in the File menu
        item = new JMenuItem("Open Pets");
        item.addActionListener(event -> {
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {
                fis= new FileInputStream("PetArrayList.data");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ArrayList<Pet> pets = null;
            try {
                pets = (ArrayList<Pet>)     ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
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

        });
        fileMenu.add( item );
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
        });
        fileMenu.add( item );
        item = new JMenuItem("Save Diagnoses");
        item.addActionListener(event ->{
            File outFile = new File(JOptionPane.showInputDialog("DiagnoseArrayList.data"));
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
        });
        fileMenu.add( item );

    }

    private void createPetsMenu() {
        JMenuItem    item;
        PetsMenu = new JMenu("Pets");
        item = new JMenuItem("Add Pet");
         item.addActionListener(event -> {
            AddPetGUI test = new AddPetGUI();
            frame.setVisible(false);
            test.setVisible(true);
        });
        PetsMenu.add( item );
        item = new JMenuItem("View Pets");
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
            item.addActionListener(event -> {
                SymptomSelectGUI test = new SymptomSelectGUI();
                frame.setVisible(false);
                test.setVisible(true);
            });
            DiagnoseMenu.add(item);
            item = new JMenuItem("View Diagnoses");
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
