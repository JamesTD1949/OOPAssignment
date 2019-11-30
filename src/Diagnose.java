import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diagnose implements Serializable {
    private static int id;
    private String condition,date;
    private int petID,severity;
    private Date today;

    public Diagnose(int petID,String condition, int severity)
    {
        setCondition(condition);
        setPetID(petID);
        setSeverity(severity);
        Date today = new Date();

        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        date = DATE_FORMAT.format(today);

        setDate(date);

        id++;
    }

    public static int getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "Diagnosis ID: " + getId() + " Condition: " + getCondition() + " Severity: " + getSeverity() + " Pet ID: " + getPetID() + " Date of Diagnosis: " + getDate();
    }
}
