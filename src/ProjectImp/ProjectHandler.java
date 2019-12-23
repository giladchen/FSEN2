package ProjectImp;

import ProjectImp.DBObjects.*;
import ProjectImp.WebDecorator.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class ProjectHandler {
    private static UserDB users = new UserDB();
    private static UserDB advisers = new UserDB();
    private static ProjectDB projects = new ProjectDB();
    private static RegistrationDB registrations = new RegistrationDB();
    private static WebDB webs = new WebDB();

    public static void tearDown() {
        users.clear();
        advisers.clear();
        projects.clear();
        //Q4
        webs.clear();
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

        String content = firstName + "\n" + lastName + "\n" + phone + "\n" + email + "\n" + organization + "\n" + projectName + "\n" + description + "\n" + hours;
        openWebsite(code, content);
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
        //Q4
        StringBuilder content = new StringBuilder();
        content.append(academicAdviser).append("\n");
        for (String student : studentList)
            content.append(student).append("\n");

        addContentToWeb(projectId, String.valueOf(content));
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

    //Q3
    public void registerStudentForEmail(String username, String email,
                                        int projectCode) {
        projects.registerStudentForEmail(users.getUser(username), email, projectCode);
    }

    public void registerStudentForText(String username, String phoneNumber,
                                       int projectCode) {
        projects.registerStudentForText(users.getUser(username), phoneNumber, projectCode);
    }

    public void registerStudentForBoth(String username, String email,
                                       String phoneNumber, int projectCode) {
        projects.registerStudentForBoth(users.getUser(username), email, phoneNumber, projectCode);
    }

    public void unregisterStudentFromMessages(String username, int projectCode) {
        projects.unregisterStudentFromMessages(users.getUser(username), projectCode);
    }

    public void approveProject(int projectCode) {
        projects.approveProject(projectCode);
    }

    //Q4
    private void openWebsite(int code, String content) {
        webs.addNewWebsite(code, content);
    }

    private void addContentToWeb(int projectId, String content) {
        webs.addContent(projectId, content);
    }

    public int getWeb(int code) {
        return webs.getWeb(code).webCode;
    }

    public void blockUser(int code, String user, String classType) {
        webs.getWeb(code).blockUser(user, classType);
    }

    public void addStyle(int code, int style) {
        AbstractWeb oldWeb = webs.getWeb(code);
        AbstractWeb newWeb = new Style(code, oldWeb.content, oldWeb, style);
        webs.replaceWebs(oldWeb, newWeb);
    }

    public void addMenu(int code, int menu) {
        AbstractWeb oldWeb = webs.getWeb(code);
        AbstractWeb newWeb = new Menu(code, oldWeb.content, oldWeb, menu);
        webs.replaceWebs(oldWeb, newWeb);
    }

    public void addLogo(int code, String logo) {
        AbstractWeb oldWeb = webs.getWeb(code);
        AbstractWeb newWeb = new Logo(code, oldWeb.content, oldWeb, logo);
        webs.replaceWebs(oldWeb, newWeb);
    }

    public void addLink(int code, String link) {
        AbstractWeb oldWeb = webs.getWeb(code);
        AbstractWeb newWeb = new Link(code, oldWeb.content, oldWeb, link);
        webs.replaceWebs(oldWeb, newWeb);
    }

    public void addMusic(int code, String music) {
        AbstractWeb oldWeb = webs.getWeb(code);
        AbstractWeb newWeb = new Music(code, oldWeb.content, oldWeb, music);
        webs.replaceWebs(oldWeb, newWeb);
    }
}