//import statements
import java.io.Serializable;

public class Pet implements Serializable {
    //implement serializable to enable saving of arraylist of Pet objects
    private static int numberOfPets=0;
    private String name,type;
    private int id; //JB added code here to fix small issue
    //multiple argument constructor
    Pet(String name, String type) {
        numberOfPets++;
        setName(name);
        setType(type);
        id= numberOfPets;
        setId(id);
    }//end of multiple argument constructor
    //accessor and mutator methods
    String getName() {
        return name;
    }
    String getType() {
        return type;
    }
    int getId() {
        return id;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setType(String type) {
        this.type = type;
    }
    private void setId(int id) { this.id = id; }
    //end of accessor and mutator methods
    //basic toString() method
    public String toString() {
        return "Pet ID: " + getId() + " Animal Type: " + getType() + " Name: " + getName();
    }
}//end of Pet Class
