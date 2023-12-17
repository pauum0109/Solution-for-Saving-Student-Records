package entity;

public class User {
    private String Username;
    private String Password;
    private String Role;
    private int ID;

    public User(String Username, String Password, String Role, int ID) {
        this.Username = Username;
        this.Password = Password;
        this.Role = Role;
        this.ID = ID;
    }

    // Getter and Setter methods for each field

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
