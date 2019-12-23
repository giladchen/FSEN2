package ProjectImp.DBObjects;

import java.util.ArrayList;

class RegistrationEntry {
    public UserEntry user;
    public ProjectEntry project;
    ArrayList<String> students;

    public RegistrationEntry(UserEntry user, ProjectEntry project, ArrayList<String> students) {
        this.user = user;
        this.project = project;
        this.students = students;
    }
}
