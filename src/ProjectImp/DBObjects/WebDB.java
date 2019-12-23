package ProjectImp.DBObjects;

import ProjectImp.WebDecorator.AbstractWeb;
import ProjectImp.WebDecorator.SimpleWeb;

import java.util.ArrayList;

public class WebDB {
    private ArrayList<AbstractWeb> webs;

    public WebDB() {
        webs = new ArrayList<>();
    }

    public void clear() {
        webs.clear();
    }

    public void addNewWebsite(int code, String content) {
        webs.add(new SimpleWeb(code, content));
    }

    public void addContent(int code, String content) {
        for (AbstractWeb web : webs) {
            if (web.webCode == code)
                web.addContent(content);
            break;
        }
    }

    public AbstractWeb getWeb(int code) {
        for (AbstractWeb web : webs)
            if (web.webCode == code)
                return web;

        return null;
    }

    public void replaceWebs(AbstractWeb oldWeb, AbstractWeb newWeb) {
        webs.remove(oldWeb);
        webs.add(newWeb);
    }
}