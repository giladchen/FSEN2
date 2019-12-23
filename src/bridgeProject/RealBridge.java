package bridgeProject;

import ProjectImp.ProjectHandler;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class RealBridge implements BridgeProject {
    ProjectHandler projectHandler = new ProjectHandler();

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        try {
            projectHandler.addTechnicalAdviser(user, password);
        } catch (RuntimeException e) {

        }
    }

    @Override
    public void addNewStudent(String user, String password) {
        try {
            projectHandler.addStudent(user, password);
        } catch (RuntimeException e) {

        }
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        try {
            return projectHandler.addProject(user, pass,
                    suggestedProject.firstName, suggestedProject.lastName,
                    suggestedProject.phone, suggestedProject.email,
                    suggestedProject.organization, suggestedProject.projectName,
                    suggestedProject.description, suggestedProject.numberOfHours);
        } catch (RuntimeException e) {
            return 0;
        }
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        try {
            return projectHandler.registerToProject(user, pass,
                    registeredProject.projectId, registeredProject.studentList,
                    registeredProject.academicAdviser);
        } catch (RuntimeException e) {
            return 0;
        }
    }
}