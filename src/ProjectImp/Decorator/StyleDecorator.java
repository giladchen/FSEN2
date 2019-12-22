package ProjectImp.Decorator;

public class StyleDecorator extends WebDecorator {
    String style;

    public StyleDecorator(AbstractWeb absWeb, String sty) {
        web = absWeb;
        style = sty;
    }

    @Override
    public String getContent() {
        return web.getContent() + "Style";
    }
}