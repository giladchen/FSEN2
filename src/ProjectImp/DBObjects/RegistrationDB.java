package ProjectImp.DBObjects;

import java.util.ArrayList;

public class RegistrationDB {
    private ArrayList<RegistrationEntry> list;

    public RegistrationDB() {
        list = new ArrayList<>();
    }

    public void add(int projectId, String username,
                    String password, ArrayList<String> studentList,
                    ProjectDB projects) {
        ProjectEntry project = projects.getProject(projectId);
        project.selected = true;
        list.add(new RegistrationEntry(new UserEntry(username, password), project, studentList));
    }
}
