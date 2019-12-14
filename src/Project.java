public class Project {
    public String add() {
        if (!isRegistered() || !isLoggedIn())
            throw new RuntimeException();
        if (!inProportions())
            throw new RuntimeException();
        if (!areNonBlank())
            throw new RuntimeException();
        saveCreationDate();
        if (checkSameProjectInYear())
            throw new RuntimeException();
        return "";
    }

    public String registerTo() {
        if (!isLoggedIn())
            throw new RuntimeException();
        if (!atLeastTwoStudents())
            throw new RuntimeException();
        handleRegisteredMentor();
        if (!checkIfRegistered())
            throw new RuntimeException();
        return "";
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
