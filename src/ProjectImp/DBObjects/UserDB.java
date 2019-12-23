package ProjectImp.DBObjects;

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

    public UserEntry getUser(String username) {
        for (UserEntry entry : list)
            if (entry.username.equals(username))
                return entry;
        return null;
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

