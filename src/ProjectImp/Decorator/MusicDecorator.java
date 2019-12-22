package ProjectImp.Decorator;

public class MusicDecorator extends WebDecorator {
    String music;

    public MusicDecorator(AbstractWeb absWeb, String msc, int code,String content) {
        super(code,content);
        web = absWeb;
        music = msc;
    }

    public void onClick() {
        //play music
    }

    @Override
    public String getContent(String user) {
        if (blockedUsers.contains(user))
            throw new RuntimeException();
        return web.getContent(user) + "Link";
    }
}