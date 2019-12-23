package ProjectImp.WebDecorator;

public class Link extends WebDecorator {
    String link;

    public Link(int code, String content, AbstractWeb absWeb, String lnk) {
        super(code,content);
        web = absWeb;
        link = lnk;
    }

    public void onClick() {
        //opens web page
    }

    @Override
    public String getContent(String user) {
        String content = web.getContent(user);
        if (!isUserBlocked(user))
            return  content + " Link";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if(classType.equals("Link"))
            blockedUsers.add(user);
        else
            web.blockUser(user,classType);
    }
}