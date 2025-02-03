package Data;

import java.util.ArrayList;
import java.util.List;

public class FurnitureData {

    private final String [] [] labels = {
            {"LIVING_ROOMS", "C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Karina_comp1.jpg", "Карина - композиция 1", "70542"},
            {"LIVING_ROOMS", "C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Karina_comp2.jpg", "Карина - композиция 2", "78870"},
            {"LIVING_ROOMS", "C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Grase_comp1.jpg", "Грэйс - композиция 1", "60141"},
            {"LIVING_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Grase_comp2.jpg", "Грэйс - композиция 2", "55693"},
            {"LIVING_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Melisa5.jpg", "Мелисса композиция 5", "62354"},
            {"LIVING_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Melisa8.jpg", "Мелисса композиция 8", "71233"},
            {"LIVING_ROOMS", "C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Kamelia_comp1.jpg", "Камелия гостинная 1", "87771"},
            {"LIVING_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\LivingRooms\\Kamelia_comp2.jpg", "Камелия гостинная 2", "84679"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Kraina1.jpg", "Карина - композиция 1", "125502"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Kraina2.jpg", "Карина - композиция 2", "96236"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Grase1.jpg", "Грэйс - композиция 1","160449"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Grase2.jpg", "Грэйс - композиция 2","92641"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Melisa1.jpg", "Мелисса 2021 - 1","61708"},
            {"BEDROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Bedrooms\\Melisa2.jpg", "Мелисса 2021 - 2","86117"},
            {"CHILDRENS_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Childrens\\Grace1.jpg","Грэйс - композиция 1", "91608"},
            {"CHILDRENS_ROOMS","C:\\Course4\\CourseWork\\src\\Img\\ProductIcons\\Childrens\\Grace2.jpg","Грэйс - композиция 2", "73995"},
    };


    int totalProductsCount = labels.length;

    int sliderProductsCount = labels.length;

    int [] sliderItemsIndexes;

    Product [] sliderItems = new Product[sliderProductsCount];

    private ArrayList<Product> cartData = new ArrayList<>();

    Product[] items = new Product[totalProductsCount];

    public FurnitureData(){
        setupProducts();
    }

    public void setsliderItemsIndexes(int[] i){
        sliderProductsCount = i.length;
        sliderItemsIndexes = i;
        setupSliderItems();
    }



    public Product[] getItems(){
        return items;
    }
    public void addProductToCart(Product pr){
        System.out.println(cartData.size());
        cartData.add(pr);
        System.out.println("added" + pr.getName());
    }

    public void removeProductFromCart(Product pr){
        cartData.remove(pr);
    }

    public Product [] getSliderItems(){
        return sliderItems;
    }

    public ArrayList getCartData(){
        return cartData;
    }

    public ArrayList getProductsByCategory(String name){

        ArrayList<Product> result = new ArrayList<>();

        for (Product pr:items){
            if(pr.getRuCatgotyName().equals(name)){
                result.add(pr);
            }
        }
        return result;
    }

    private void setupSliderItems(){
        for (int i = 0; i < sliderProductsCount; i++) {
            String categoryName = labels[sliderItemsIndexes[i]][0];
            Categories category = Categories.valueOf(categoryName);
            String imgPath = labels[sliderItemsIndexes[i]][1];
            String name = labels[sliderItemsIndexes[i]][2];
            int cost = Integer.parseInt(labels[sliderItemsIndexes[i]][3]);

            sliderItems[i] = new Product(category, imgPath, name, cost);
        }
    }

    private void setupProducts(){
        for (int i = 0; i < totalProductsCount; i++) {
            String categoryName = labels[i][0];
            Categories category = Categories.valueOf(categoryName);
            String imgPath = labels[i][1];
            String name = labels[i][2];
            int cost = Integer.parseInt(labels[i][3]);

            items[i] = new Product(category, imgPath, name, cost);

        }
    }

}
