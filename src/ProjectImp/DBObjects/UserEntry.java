package ProjectImp.DBObjects;

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
