

public class TestDriver extends MainGUI {

    static MainGUI frame;
    public static void main(String[] args) {
        frame = new MainGUI();
        frame.setVisible(true);
        TestDriver temp = new TestDriver();

    }

    public TestDriver()
    {
        for(Pet pet:frame.getPets())
            System.out.println(pet.toString());
        //Sequencing and timing and stuff that breaks everything.
    }
}
