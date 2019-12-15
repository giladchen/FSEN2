package Project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Project {
    private static UserDB users = new UserDB();
    private static UserDB advisers = new UserDB();
    private static A projects;
    //TODO: Make databases of important information

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


    public void registerTechnicalAdviser(String username, String password) {
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
        String creationDate = getCurrentDate();
        if (checkSameProjectInYear())
            throw new RuntimeException();
        return 0; //TODO
    }

    private String getCurrentDate() {
        Date date = new Date();
        return dateFormat.format(date);
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
        boolean ret = !username.equals("");
        ret &= !password.equals("");
        ret &= !firstName.equals("");
        ret &= !lastName.equals("");
        ret &= !phone.equals("");
        ret &= !email.equals("");
        ret &= !projectName.equals("");
        ret &= !description.equals("");
        return ret;
    }

    private boolean inProportions(int hours) {
        return 200 <= hours && hours <= 300;
    }

    private boolean isRegistered(String username, String password) {
        return users.contains(username, password);
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