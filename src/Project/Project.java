package Project;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;
import bridgeProject.BridgeProject;

import java.util.ArrayList;

public class Project {
    private static ArrayList<Entry> database = new ArrayList<>();
    //TODO: Make databases of important information


    public void registerTechnicalAdviser(/* TODO */) {
        //TODO
    }

    public void addStudent(/* TODO */) {
        //TODO
    }

    public int addProject(/* TODO */) {
        if (!isRegistered() || !isLoggedIn())
            throw new RuntimeException();
        if (!inProportions())
            throw new RuntimeException();
        if (!areNonBlank())
            throw new RuntimeException();
        saveCreationDate();
        if (checkSameProjectInYear())
            throw new RuntimeException();
        return 0; //TODO
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

    //TODO: write all of the helper functions
    private boolean checkIfRegistered() {
        return false;
    }

    private void handleRegisteredMentor() {
    }

    private boolean atLeastTwoStudents() {
        return false;
    }

    private boolean isRegistered() {
        return false;
    }

    private boolean isLoggedIn() {
        return false;
    }

    private boolean inProportions() {
        return false;
    }

    private boolean checkSameProjectInYear() {
        return false;
    }

    private void saveCreationDate() {

    }

    private boolean areNonBlank() {
        return false;
    }

}