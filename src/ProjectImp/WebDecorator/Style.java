package ProjectImp.WebDecorator;

public class Style extends WebDecorator {
    int style;

    public Style(int code, String content, AbstractWeb absWeb,int styl) {
        super(code, content);
        web = absWeb;
        style = styl;
    }

    @Override
    public String getContent(String user) {
        String content = web.getContent(user);
        if (!isUserBlocked(user))
            return content + " Style";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if(classType.equals("Style"))
            blockedUsers.add(user);
        else
            web.blockUser(user,classType);
    }
}