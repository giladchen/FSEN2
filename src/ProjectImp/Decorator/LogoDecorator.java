package ProjectImp.Decorator;

public class LogoDecorator extends WebDecorator {
    String logo;

    public LogoDecorator(AbstractWeb absWeb, String lgo, int code,String content) {
        super(code,content);
        web = absWeb;
        logo = lgo;
    }

    public void onClick() {
        //opens company web page
    }

    @Override
    public String getContent(String user) {
        if (blockedUsers.contains(user))
            throw new RuntimeException();
        return web.getContent(user) + "Logo";
    }
}