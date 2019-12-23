package ProjectImp.Obesrver;

public class Student implements Observer {
    ProjectEntry subject;

    @Override
    public void update() {
        subject.getState();
    }
}
