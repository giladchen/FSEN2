package ProjectImp.DBObjects;


import ProjectImp.ObesrverPattern.Subject;

import java.util.Calendar;

public class ProjectEntry extends Subject {
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
    //Q3
    public boolean approved;

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
        this.approved = false;
    }

    //Q3
    public void registerStudent(UserEntry user, ListenType listenType) {
        user.listenType = listenType;
        user.subject = this;
        attach(user);
    }

    public void unregisterStudent(UserEntry user) {
        user.listenType = ListenType.NONE;
        user.subject = null;
        detach(user);
    }

    public void approve() {
        this.approved = true;
        notifyObservers();
    }


    @Override
    public boolean getState() {
        return approved;
    }

    @Override
    public void setState(boolean state) {
        this.approved = state;
    }
}
