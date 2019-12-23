package ProjectImp.WebDecorator;

public class SimpleWeb extends AbstractWeb {

    public SimpleWeb(int code,String content) {
        super(code,content);
    }

    @Override
    public String getContent(String user) {
        if (!isUserBlocked(user))
            return  content + " Style";
        return null;
    }

    @Override
    public void blockUser(String user, String classType) {
        if(classType.equals("SimpleWeb"))
            blockedUsers.add(user);
    }
}