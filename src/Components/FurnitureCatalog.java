package Components;

import Data.Categories;
import Data.FurnitureData;
import Data.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FurnitureCatalog extends Page{
    JPanel leftSideMenu;
    JLabel [] categories;
    Categories [] categoriesArray = Categories.values();
    private final ActionListener actionListener;
    ArrayList<Product> items;
    FurnitureData data;
    private String pageName = "Каталог";
    private JPanel content;

    FurnitureCatalog(FurnitureData d){
        super("Каталог");
        this.data = d;
        this.actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        setPreferredSize(new Dimension(1200, 1000));
        setLayout(new BorderLayout());
        String currentCaategoryName = Categories.BEDROOMS.getRuName();
        items = data.getProductsByCategory(currentCaategoryName);

        content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(1000,1000));

        updateContent();
        leftSideMenu = new JPanel();
        leftSideMenu.setLayout(new BoxLayout(leftSideMenu, BoxLayout.Y_AXIS));
        leftSideMenu.setPreferredSize(new Dimension(200,1000));
//        leftSideMenu.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));
        for(Categories category: categoriesArray){
            String currentName = category.getRuName();
            JLabel categoryItem = new JLabel(currentName);
            categoryItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    items = data.getProductsByCategory(currentName);
                    updateContent();
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    categoryItem.setForeground(Color.BLUE);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    categoryItem.setForeground(Color.BLACK);
                }
            });
            categoryItem.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
            leftSideMenu.add(categoryItem);
        }
        add(leftSideMenu, BorderLayout.WEST);
        add(content, BorderLayout.CENTER);
    }

    private void updateContent() {
        content.removeAll();

        JPanel gridPanel = new JPanel(new GridLayout(0, 3));
        gridPanel.setPreferredSize(new Dimension(1000,300));
        gridPanel.setMaximumSize(new Dimension(1000,300));

        for (Product currentProduct : items) {

            JPanel currentItemContainer = new JPanel(new GridLayout(3, 1));
            currentItemContainer.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            currentItemContainer.setPreferredSize(new Dimension(400,400));
            currentItemContainer.setMaximumSize(new Dimension(400,400));
            JPanel costContainer = new JPanel(new FlowLayout());
            costContainer.setPreferredSize(new Dimension(400,50));
            ImageIcon originalIcon = new ImageIcon(currentProduct.getIcon());
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);

            JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
            currentItemContainer.add(iconLabel);

            JLabel nameLabel = new JLabel(currentProduct.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 19));
            nameLabel.setPreferredSize(new Dimension(400,50));
            currentItemContainer.add(nameLabel);

            JLabel costLabel = new JLabel("Цена: " + currentProduct.getCost() + " руб.");
            costContainer.add(costLabel);

            JButton toCart = new JButton(new ImageIcon("C:\\Course4\\CourseWork\\src\\Img\\MainPage\\Vector.png"));
            toCart.addActionListener(e -> data.addProductToCart(currentProduct));

            costContainer.add(toCart, FlowLayout.CENTER);

            currentItemContainer.add(costContainer, BorderLayout.SOUTH);

            gridPanel.add(currentItemContainer);
        }

        content.add(gridPanel);

        content.revalidate();
        content.repaint();
    }

}
