package entity;

public class Scholarship {
    private int Year;
    private int scholarID;
    private int Sum;
    private int Type;
    private int Tuition;
    private int studentID;

    public Scholarship(int Year, int scholarID, int Sum, int Type, int Tuition, int studentID) {
        this.Year = Year;
        this.scholarID = scholarID;
        this.Sum = Sum;
        this.Type = Type;
        this.Tuition = Tuition;
        this.studentID = studentID;
    }

    // Getter and Setter methods for each field

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getScholarID() {
        return scholarID;
    }

    public void setScholarID(int scholarID) {
        this.scholarID = scholarID;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int Sum) {
        this.Sum = Sum;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public int getTuition() {
        return Tuition;
    }

    public void setTuition(int Tuition) {
        this.Tuition = Tuition;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}