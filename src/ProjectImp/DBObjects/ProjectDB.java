package ProjectImp.DBObjects;

import java.util.ArrayList;
import java.util.Calendar;

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

    public void clear() {
        list.clear();
    }

    public boolean isSelected(int projectId) {
        for (ProjectEntry entry : list)
            if (entry.code == projectId)
                return entry.selected;
        throw new RuntimeException(); //throws when project doesn't exist
    }

    public ProjectEntry getProject(int projectId) {
        for (ProjectEntry entry : list)
            if (entry.code == projectId)
                return entry;
        return null;
    }

    //Q3
    public void registerStudentForEmail(UserEntry user, String email, int projectCode) {
        registerForMessages(user, email, "", projectCode, ListenType.EMAIL);
    }

    public void registerStudentForText(UserEntry user, String phoneNumber, int projectCode) {
        registerForMessages(user, "", phoneNumber, projectCode, ListenType.TEXT);
    }

    public void registerStudentForBoth(UserEntry user, String email, String phoneNumber, int projectCode) {
        registerForMessages(user, email, phoneNumber, projectCode, ListenType.BOTH);
    }

    private void registerForMessages(UserEntry user, String email,
                                     String phoneNumber, int projectCode, ListenType listenType) {
        ProjectEntry projectEntry = getProject(projectCode);
        if (user == null || projectEntry == null)
            throw new RuntimeException();
        projectEntry.registerStudent(user, email, phoneNumber, listenType);
    }

    public void approveProject(int projectCode) {
        ProjectEntry projectEntry = getProject(projectCode);
        if (projectEntry == null)
            throw new RuntimeException();
        projectEntry.approve();
    }

    public void unregisterStudentFromMessages(UserEntry user, int projectCode) {
        ProjectEntry projectEntry = getProject(projectCode);
        if (user == null || projectEntry == null)
            throw new RuntimeException();
        projectEntry.unregisterStudent(user);
    }
}

