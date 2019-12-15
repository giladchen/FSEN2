package Project;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<UserEntry> list;

    public UserDB() {
        this.list = new ArrayList<>();
    }

    public void add(String username, String password) {
        //TODO: maybe do nothing instead of throwing exception
        if (username.equals("") || password.equals(""))
            throw new RuntimeException("username or password are empty");
        for (UserEntry entry : list)
            if (entry.getUsername().equals(username))
                throw new RuntimeException("username exists");
        list.add(new UserEntry(username, password));
    }

    public String getPassword(String username) {
        for (UserEntry entry : list)
            if (entry.getUsername().equals(username))
                return entry.getPassword();
        return "";
    }

    public boolean contains(String username, String password) {
        return list.contains(new UserEntry(username, password));
    }
}

class UserEntry {
    private String username;
    private String password;

    public UserEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object e) {
        if (!(e instanceof UserEntry))
            return false;
        UserEntry entry = (UserEntry) e;
        return this.username.equals(entry.username) && this.password.equals(entry.password);
    }
}
