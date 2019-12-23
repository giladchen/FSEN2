package ProjectImp.WebDecorator;

public class Logo extends WebDecorator {
    String logo;

    public Logo(int code, String content, AbstractWeb absWeb, String lgo) {
        super(code, content);
        web = absWeb;
        logo = lgo;
    }

    public void onClick() {
        //opens company web page
    }

    @Override
    public String getContent(String user) {
        String content = web.getContent(user);
        if (!isUserBlocked(user))
            return content + " Logo";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if (classType.equals("Logo"))
            blockedUsers.add(user);
        else
            web.blockUser(user, classType);
    }
}