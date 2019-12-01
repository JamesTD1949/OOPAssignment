import java.io.Serializable;

public class Pet implements Serializable {
    private String name,type;
    private static int id; //autoincrement ID value
    private int animalID; //JB added code here to fix small issue

    Pet(String name, String type) {
        id++;
        setName(name);
        setType(type);
        animalID = id;
        setId(animalID);
    }

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

    public String toString() {
        return "Pet ID: " + getId() + " Animal Type: " + getType() + " Name: " + getName();
    }
}
