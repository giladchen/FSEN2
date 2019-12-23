package ProjectImp.DBObjects;

import ProjectImp.Decorator.AbstractWeb;
import ProjectImp.Decorator.SimpleWeb;

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

    public void addMoreContent(int code, String content){
        for (AbstractWeb web : webs)
            if (web.webCode == code){
                web.addMoreContent(content);
            }

    }
}