package ProjectImp.DBObjects;

import ProjectImp.ObesrverPattern.Observer;

public class UserEntry implements Observer {
    public String username;
    public String password;
    //Q3
    public ProjectEntry subject;
    public ListenType listenType;

    public UserEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object e) {
        if (!(e instanceof UserEntry))
            return false;
        UserEntry entry = (UserEntry) e;
        return this.username.equals(entry.username) && this.password.equals(entry.password);
    }

    //Q3
    @Override
    public void update() {
        if (subject.getState()) {
            switch (this.listenType) {
                case EMAIL:
                    sendEmail();
                    break;
                case TEXT:
                    sendText();
                    break;
                case BOTH:
                    sendEmail();
                    sendText();
                    break;
                case NONE:
                    throw new RuntimeException();
            }
        }
    }

    private void sendEmail() {
        System.out.println(this.subject.projectName + " approved. Email sent to " + this.username);
    }

    private void sendText() {
        System.out.println(this.subject.projectName + " approved. Text sent to " + this.username);
    }
}

