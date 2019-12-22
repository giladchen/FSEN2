package ProjectImp.Decorator;

public class MenuDecorator extends WebDecorator {
    String menu;

    public MenuDecorator(AbstractWeb absWeb, String mnu, int code,String content) {
        super(code,content);
        web = absWeb;
        menu = mnu;
    }

    @Override
    public String getContent(String user) {
        if (blockedUsers.contains(user))
            throw new RuntimeException();
        return web.getContent(user) + "Link";
    }
}