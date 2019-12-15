package Project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ProjectDB {
    private ArrayList<ProjectEntry> list;

    public ProjectDB() {
        list = new ArrayList<>();
    }


    public void add(String username, String password,
                    String firstName, String lastName,
                    String phone, String email,
                    String organization, String projectName,
                    String description, int hours,
                    Calendar creationDate, int code) {
        list.add(new ProjectEntry(username, password,
                firstName, lastName,
                phone, email,
                organization, projectName,
                description, hours,
                creationDate, code));
    }

    public boolean checkIfExistingYear(Calendar creationDate, String organization) {
        for (ProjectEntry entry : list)
            if (entry.organization.equals(organization) &&
                    entry.date.get(Calendar.YEAR) == creationDate.get(Calendar.YEAR))
                return true;
        return false;
    }

    public boolean containsCode(int code) {
        for (ProjectEntry entry : list)
            if (entry.code == code)
                return true;
        return false;
    }
}

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
    }
}
