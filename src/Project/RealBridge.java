package Project;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;
import bridgeProject.BridgeProject;

public class RealBridge implements BridgeProject {
    @Override
    public void registerNewTechnicalAdviser(String user, String password) {
        //TODO: ADD CALL TO OUR IMPLEMENTATION OF registerNewTechnicalAdviser
    }

    @Override
    public void addNewStudent(String user, String password) {
        //TODO: ADD CALL TO OUR IMPLEMENTATION OF addNewStudent
    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        //TODO: ADD CALL TO OUR IMPLEMENTATION OF addNewProject
        return 0;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        //TODO: ADD CALL TO OUR IMPLEMENTATION OF registerToProject
        return 0;
    }
}
