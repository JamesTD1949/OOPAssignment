public class Pet {
    private String name,type;
    private int age;

    public Pet(String name, String type, int age) {
        setName(name);
        setType(type);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Animal Type: " + getType() + " Animal Name: " + getName() + " Animal Age: " + getAge();
    }
}
