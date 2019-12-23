package ProjectImp.WebDecorator;

public class Music extends WebDecorator {
    String music;

    public Music(int code, String content, AbstractWeb absWeb, String msc) {
        super(code, content);
        web = absWeb;
        music = msc;
    }

    public void onClick() {
        //play music
    }

    @Override
    public String getContent(String user) {
        String content = web.getContent(user);
        if (!isUserBlocked(user))
            return content + " Music";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if (classType.equals("Music"))
            blockedUsers.add(user);
        else
            web.blockUser(user, classType);
    }
}