package ProjectImp.WebDecorator;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWeb {
    List<String> blockedUsers;
    public String content;
    public int webCode;

    public AbstractWeb(int code, String cont) {
        blockedUsers = new LinkedList<>();
        webCode = code;
        content = cont;
    }

    public abstract String getContent(String user);

    public abstract void blockUser(String user, String classType);

    boolean isUserBlocked(String user){
        return blockedUsers.contains(user);
    }

    public void addContent(String cont) {
        content = content + "\n" + cont;
    }
}