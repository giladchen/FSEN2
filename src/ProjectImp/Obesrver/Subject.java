package ProjectImp.Obesrver;

import java.util.ArrayList;

public abstract class Subject {

    ArrayList<Observer> observers = new ArrayList<>();

    abstract void attach(Observer o);

    abstract void detach(Observer o);

    void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }
}
