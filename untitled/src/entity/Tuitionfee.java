package entity;

public class Tuitionfee {
    private float Total;
    private int ID;
    private int Semester;
    private int Credit;
    private float Debt;
    private int studentID;

    public Tuitionfee(float Total, int ID, int Semester, int Credit, float Debt, int studentID) {
        this.Total = Total;
        this.ID = ID;
        this.Semester = Semester;
        this.Credit = Credit;
        this.Debt = Debt;
        this.studentID = studentID;
    }

    // Getter and Setter methods for each field

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    public float getDebt() {
        return Debt;
    }

    public void setDebt(float Debt) {
        this.Debt = Debt;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
