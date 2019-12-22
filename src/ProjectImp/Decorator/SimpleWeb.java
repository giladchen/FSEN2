package ProjectImp.Decorator;

public class SimpleWeb extends AbstractWeb {

    public SimpleWeb(int code,String content) {
        super(code,content);
    }

    @Override
    public String getContent(String user) {
        return "Content: " + content;
    }
}