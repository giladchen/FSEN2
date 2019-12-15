package acptTests;

import Project.Project; //ADDED
import bridgeProject.BridgeProject;
import bridgeProject.BridgeProxy;

public abstract class Driver {

    public static BridgeProject getBridge() {
        BridgeProxy bridge = new BridgeProxy();
        //bridge.setRealBridge(null); // add real bridge here
        bridge.setRealBridge(new Project()); //ADDED
        return bridge;
    }
}