package bridgeProject;

import Project.Project;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class RealBridge implements BridgeProject {
    Project project = new Project();

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        try {
            project.addTechnicalAdviser(user, password);
        }
        catch (RuntimeException e) {

        }
    }

    @Override
    public void addNewStudent(String user, String password) {
        try {
            project.addStudent(user, password);
        }
        catch (RuntimeException e) {

        }
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        try {
            return project.addProject(user, pass,
                    suggestedProject.firstName, suggestedProject.firstName,
                    suggestedProject.phone, suggestedProject.email,
                    suggestedProject.organization, suggestedProject.projectName,
                    suggestedProject.description, suggestedProject.numberOfHours);
        }
        catch (RuntimeException e) {
            return 0;
        }
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        //TODO: ADD CALL TO OUR IMPLEMENTATION OF registerToProject
        return 0;
    }
}
