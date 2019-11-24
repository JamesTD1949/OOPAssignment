import java.text.SimpleDateFormat;
import java.util.Date;

public class DiagnoseDriver {
    public static void main(String[] args) {
        Diagnose test = new Diagnose(3,"Kennel Cough",4);

        System.out.println(test.toString());
    }
}
