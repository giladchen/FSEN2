package ProjectImp;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<UserEntry> list;

    public UserDB() {
        this.list = new ArrayList<>();
    }

    public void add(String username, String password) {
        if (username.equals("") || password.equals(""))
            throw new RuntimeException("username or password are empty");
        for (UserEntry entry : list)
            if (entry.username.equals(username))
                throw new RuntimeException("username exists");
        list.add(new UserEntry(username, password));
    }

    public String getPassword(String username) {
        for (UserEntry entry : list)
            if (entry.username.equals(username))
                return entry.password;
        return "";
    }

    public boolean contains(String username, String password) {
        return list.contains(new UserEntry(username, password));
    }

    public void clear() {
        list.clear();
    }
}

class UserEntry {
    public String username;
    public String password;

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
}