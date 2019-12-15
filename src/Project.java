import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;
import bridgeProject.BridgeProject;

public class Project implements BridgeProject {


    @Override
    public void registerNewTechnicalAdviser(String user, String password) {

    }

    @Override
    public void addNewStudent(String user, String password) {

    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        if (!isRegistered() || !isLoggedIn())
            throw new RuntimeException();
        if (!inProportions())
            throw new RuntimeException();
        if (!areNonBlank())
            throw new RuntimeException();
        saveCreationDate();
        if (checkSameProjectInYear())
            throw new RuntimeException();
        return 0;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        if (!isLoggedIn())
            throw new RuntimeException();
        if (!atLeastTwoStudents())
            throw new RuntimeException();
        handleRegisteredMentor();
        if (!checkIfRegistered())
            throw new RuntimeException();
        return 0;
    }

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