package Components;

import Data.FurnitureData;
import Data.Product;
import javax.swing.*;
import java.awt.*;

public class FurnitureMainPage extends Page {

    private JMenu headerMenu;
    private SliderPanel mainPageSlider;
    private Product [] sliderData;
    private int [] sliderItemsIndexes;
    private int sliderItemsCount = 3;
    private String pageName = "Главная";

    public FurnitureMainPage(FurnitureData d){
        super("Главная");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 1000));
        setCurrentSliderItems();
        FurnitureData data = new FurnitureData();
        data.setsliderItemsIndexes(sliderItemsIndexes);
        Product[] sliderItems = data.getSliderItems();
        mainPageSlider = new SliderPanel(sliderItemsCount, sliderItems);
        add(mainPageSlider, BorderLayout.CENTER);
    }

    public String getPageName(){
        return pageName;
    }

    private void setCurrentSliderItems() {
        sliderItemsIndexes = new int[]{2, 3, 5};
    }


}
