package Project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Project {
    private static UserDB users = new UserDB();
    private static UserDB advisers = new UserDB();
    private static ProjectDB projects = new ProjectDB();
    //TODO: Make databases of important information
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
        if (!isRegistered(username, password))
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

    public int registerToProject(/* TODO */) {
        if (!isLoggedIn())
            throw new RuntimeException();
        if (!atLeastTwoStudents())
            throw new RuntimeException();
        handleRegisteredMentor();
        if (!checkIfRegistered())
            throw new RuntimeException();
        return 0; //TODO
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

    private boolean isRegistered(String username, String password) {
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


    //TODO: write all of the helper functions
    private boolean checkIfRegistered() {
        return false;
    }

    private void handleRegisteredMentor() {
    }

    private boolean atLeastTwoStudents() {
        return false;
    }


    private boolean isLoggedIn() {
        return false;
    }

}