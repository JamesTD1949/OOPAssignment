import java.io.Serializable;

public class Pet implements Serializable {
    private static int id;
    private String name,type;

    Pet(String name, String type) {
        setName(name);
        setType(type);
        setId(id);
        id++;

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

    private void setId(int id) { Pet.id = id; }

    public String toString() {
        return "Pet ID: " + getId() + " Animal Type: " + getType() + " Name: " + getName();
    }
}
