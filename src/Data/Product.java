package Data;

public class Product {

    private String icon;
    private String name;
    private int cost;
    private Categories category;

    Product(Categories ct, String i, String n, int c){
        category = ct;
        icon = i;
        name = n;
        cost = c;
    }

    public String getIcon(){
        return icon;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    String getRuCatgotyName(){
        return category.getRuName();
    }

}
