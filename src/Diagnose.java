//import statements
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
//implement serializable to enable saving of arraylist of diagnose objects
public class Diagnose implements Serializable {
    private static int numberOfDiagnoses=0;
    private String condition,date;
    private int petID,severity,id;
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy"); //create a more readable date format and define it as an attribute so it won't have to be created every time the constructor runs
    //multiple argument constructor
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
    }//end of multiple argument constructor
    //accessor and mutator methods
    public int getId() {

        return id;
    }
    private void setID(int id){
        this.id = id;
    }
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
    //end of accessor and mutator methods
    //Basic toString() method
    public String toString() {
        return "Diagnosis ID: " + getId() + " Condition: " + getCondition() + " Severity: " + getSeverity() + " Pet ID: " + getPetID() + " Date of Diagnosis: " + getDate();
    }//end of toString method
}//end of Diagnose class
