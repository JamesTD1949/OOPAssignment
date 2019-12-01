import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diagnose implements Serializable {
    private static int numberOfDiagnoses=0;
    private String condition,date;
    private int petID,severity,id;
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    Diagnose(int petID, String condition, int severity)
    {
        numberOfDiagnoses++;
        setCondition(condition);
        setPetID(petID);
        setSeverity(severity);
        Date today = new Date();
        date = DATE_FORMAT.format(today);
        setDate(date);
        id=numberOfDiagnoses;
        setID(id);
    }

    public int getId() {
        return id;
    }

    private void setID(int id){this.id = id;}

    String getCondition() {
        return condition;
    }

    private void setCondition(String condition) {
        this.condition = condition;
    }

    int getPetID() {
        return petID;
    }

    private void setPetID(int petID) {
        this.petID = petID;
    }

    int getSeverity() {
        return severity;
    }

    private void setSeverity(int severity) {
        this.severity = severity;
    }

    String getDate() {
        return date;
    }

    private void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return "Diagnosis ID: " + getId() + " Condition: " + getCondition() + " Severity: " + getSeverity() + " Pet ID: " + getPetID() + " Date of Diagnosis: " + getDate();
    }
}
