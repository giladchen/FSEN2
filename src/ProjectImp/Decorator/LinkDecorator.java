package ProjectImp.Decorator;

public class LinkDecorator extends WebDecorator {
    String link;

    public LinkDecorator(AbstractWeb absWeb, String lnk, int code,String content) {
        super(code,content);
        web = absWeb;
        link = lnk;
    }

    public void onClick() {
        //opens web page
    }

    @Override
    public String getContent(String user) {
        if (blockedUsers.contains(user))
            throw new RuntimeException();
        return web.getContent(user) + "Link";
    }
}