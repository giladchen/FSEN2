package ProjectImp.ObesrverPattern;

import java.util.HashSet;

public abstract class Subject {

    private HashSet<Observer> observers = new HashSet<>();

    protected void attach(Observer o) {
        observers.add(o);
    }

    protected void detach(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }

    public abstract boolean getState();

    public abstract void setState(boolean state);
}
