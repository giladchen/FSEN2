package ProjectImp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Project {
    private static UserDB users = new UserDB();
    private static UserDB advisers = new UserDB();
    private static ProjectDB projects = new ProjectDB();
    private static RegistrationDB registrations = new RegistrationDB();
    //TODO: Make databases of important information

    public static void tearDown() {
        users.clear();
        advisers.clear();
        projects.clear();
    }

    public void addTechnicalAdviser(String username, String password) {
        advisers.add(username, password);
    }

    public void addStudent(String username, String password) {
        users.add(username, password);
    }

    public int addProject(String username, String password,
                          String firstName, String lastName,
                          String phone, String email,
                          String organization, String projectName,
                          String description, int hours) {
        if (!areNonBlank(username, password,
                firstName, lastName,
                phone, email,
                projectName, description))
            throw new RuntimeException();
        if (!inProportions(hours))
            throw new RuntimeException();
        if (!isAdviserRegistered(username, password))
            throw new RuntimeException();
        Calendar creationDate = getCurrentDate();
        if (existsSameProjectInYear(creationDate, organization))
            throw new RuntimeException();
        int code = generateCode();
        projects.add(username, password,
                firstName, lastName,
                phone, email,
                organization, projectName,
                description, hours,
                creationDate, code);
        return code;
    }

    public int registerToProject(String username, String password,
                                 int projectId, ArrayList<String> studentList,
                                 String academicAdviser) {
        if (!areNonBlank(username, password,
                studentList, academicAdviser))
            throw new RuntimeException();
        if (!isUserRegistered(username, password))
            throw new RuntimeException();
        if (!isValidStudentNum(studentList))
            throw new RuntimeException();
        if (isRegisteredAndExisting(projectId))
            throw new RuntimeException();
        registrations.add(projectId, username,
                password, studentList,
                projects);
        return projectId;
    }

    private boolean areNonBlank(String username, String password,
                                String firstName, String lastName,
                                String phone, String email,
                                String projectName, String description) {
        String[] args = {username, password,
                firstName, lastName,
                phone, email,
                projectName, description};
        boolean ret = true;
        for (String s : args)
            ret &= (s != null) && (!s.equals(""));
        return ret;
    }

    private boolean inProportions(int hours) {
        return 200 <= hours && hours <= 300;
    }

    private boolean isAdviserRegistered(String username, String password) {
        return advisers.contains(username, password);
    }

    private Calendar getCurrentDate() {
        return Calendar.getInstance();
    }

    private boolean existsSameProjectInYear(Calendar creationDate, String organization) {
        if (organization != null && !organization.equals(""))
            return projects.checkIfExistingYear(creationDate, organization);
        return false;
    }

    private int generateCode() {
        Random r = new Random();
        int code = Math.abs(r.nextInt());
        while (projects.containsCode(code))
            code = Math.abs(r.nextInt());
        return code;
    }


    private boolean areNonBlank(String username, String password,
                                ArrayList<String> studentList, String academicAdviser) {
        String[] args = {username, password, academicAdviser};
        boolean ret = true;
        for (String s : args)
            ret &= (s != null) && (!s.equals(""));
        ret &= studentList != null;
        return ret;
    }

    private boolean isUserRegistered(String username, String password) {
        return users.contains(username, password);
    }

    private boolean isValidStudentNum(ArrayList<String> studentList) {
        return 2 <= studentList.size() && studentList.size() <= 4;
    }

    private boolean isRegisteredAndExisting(int projectId) {
        return projects.isSelected(projectId);
    }

}