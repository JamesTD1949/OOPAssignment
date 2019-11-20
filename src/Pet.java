import java.util.Date;

public class Pet {
    private static int id=0;
    private String name,type;
    //private Date dob;

    public Pet(String name, String type) {
        setName(name);
        setType(type);
        //setDOB(dob);
        setId(id);
        id++;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    /*public Date getDOB() {
        return dob;
    }*/

    public static int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*public void setDOB(Date dob) {
        this.dob = dob;
    }*/

    public static void setId(int id) {
        Pet.id = id;
    }

    public String toString() {
        return "Pet ID: " + getId() + " Animal Type: " + getType() + " Name: " + getName();
    }
}
