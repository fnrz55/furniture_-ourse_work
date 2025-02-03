package Components;

import javax.swing.*;

public class Page extends JPanel {
    String name;

    Page(String n){
        name = n;
    }

    public void updatePage(){

    }

    public String getPageName(){
        return name;
    }
}
