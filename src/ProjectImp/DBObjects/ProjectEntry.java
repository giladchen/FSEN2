package ProjectImp.DBObjects;

import java.util.Calendar;

class ProjectEntry {
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String phone;
    public String email;
    public String organization;
    public String projectName;
    public String description;
    public int numberOfHours;
    public Calendar date;
    public int code;
    public boolean selected;

    public ProjectEntry(String username, String password,
                        String firstName, String lastName,
                        String phone, String email,
                        String organization, String projectName,
                        String description, int numberOfHours,
                        Calendar date, int code) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.organization = organization;
        this.projectName = projectName;
        this.description = description;
        this.numberOfHours = numberOfHours;
        this.date = date;
        this.code = code;
        this.selected = false;
    }
}
