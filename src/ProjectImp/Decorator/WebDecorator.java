package ProjectImp.Decorator;

public abstract class WebDecorator extends AbstractWeb {
    AbstractWeb web;

    public WebDecorator(int code,String content) {
        super(code,content);
    }
}