package ProjectImp.WebDecorator;

public class Menu extends WebDecorator {
    int menu;

    public Menu(int code, String content, AbstractWeb absWeb, int men) {
        super(code,content);
        web = absWeb;
        menu = men;
    }

    @Override
    public String getContent(String user) {
        String content = web.getContent(user);
        if (!isUserBlocked(user))
            return  content + " Menu";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if (classType.equals("Menu"))
            blockedUsers.add(user);
        else
            web.blockUser(user, classType);
    }
}