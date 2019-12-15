package bridgeProject;

import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class BridgeReal implements BridgeProject {
    @Override
    public void registerNewTechnicalAdviser(String user, String password) {

    }

    @Override
    public void addNewStudent(String user, String password) {

    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {
        return 0;
    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {
        return 0;
    }
}
