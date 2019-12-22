package ProjectImp.Decorator;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWeb {
    List<String> blockedUsers;
    String content;
    public int webCode;

    public AbstractWeb(int code, String cont) {
        blockedUsers = new LinkedList<>();
        webCode = code;
        content = cont;
    }

    public abstract String getContent(String user);

    public void addMoreContent(String cont) {
        content = content + "\n" + cont;
    }

    public void blockUser(String user) {
        blockedUsers.add(user);
    }

    public void unblockUser(String user) {
        blockedUsers.remove(user);
    }
}