package acptTests;

import bridgeProject.BridgeProject;
import bridgeProject.BridgeProxy;
import bridgeProject.RealBridge;

public abstract class Driver {

    public static BridgeProject getBridge() {
        BridgeProxy bridge = new BridgeProxy();
        //bridge.setRealBridge(null); // add real bridge here
        bridge.setRealBridge(new RealBridge()); //ADDED
        return bridge;
    }
}