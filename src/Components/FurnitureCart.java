package Components;

import Data.FurnitureData;
import Data.Product;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FurnitureCart extends Page{

    ArrayList<Product> items;
    FurnitureData data;
    JPanel content;
    int totalItemsCost = 0;
    JPanel costCont;
    JButton buy;

    FurnitureCart(FurnitureData d) {
        super("Корзина");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1200, 1000));
        this.data = d;
        items = data.getCartData();

        content = new JPanel(new GridLayout(0,1));
        content.setPreferredSize(new Dimension(1000, 1000));
        JPanel leftSideMenu = new JPanel();
        leftSideMenu.setPreferredSize(new Dimension(400, 500));
        costCont = new JPanel();
        buy = new JButton("Оформить заказ");
        buy.setForeground(Color.RED);
        buy.addActionListener(e -> {
            items.clear();
            JOptionPane.showMessageDialog(this, "Заказ на сумму "+totalItemsCost+" оформлен", "Информация", JOptionPane.INFORMATION_MESSAGE);
            totalItemsCost = 0;
            updatePage();
        });
        leftSideMenu.setLayout(new BoxLayout(leftSideMenu, BoxLayout.Y_AXIS));
        leftSideMenu.add(costCont);
        updatePage();
        add(content, BorderLayout.CENTER);
        add(leftSideMenu, BorderLayout.WEST);

    }

    public void updatePage() {
        content.removeAll();

        JPanel gridPanel = new JPanel(new GridLayout(0, 5));
        gridPanel.setMaximumSize(new Dimension(1200, 300));

        for (Product currentProduct : items) {
            System.out.println(items.size());
            System.out.println(currentProduct.getName());
            JPanel currentItemContainer = new JPanel(new GridLayout(3, 1));
            currentItemContainer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            currentItemContainer.setPreferredSize(new Dimension(400, 400));
            currentItemContainer.setMaximumSize(new Dimension(400, 400));

            ImageIcon originalIcon = new ImageIcon(currentProduct.getIcon());
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(400, 200, Image.SCALE_SMOOTH);

            JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
            currentItemContainer.add(iconLabel);

            JLabel nameLabel = new JLabel(currentProduct.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 19));
            nameLabel.setPreferredSize(new Dimension(400, 50));
            currentItemContainer.add(nameLabel);

            JLabel costLabel = new JLabel("Цена: " + currentProduct.getCost() + " руб.");
            totalItemsCost += currentProduct.getCost();
            JPanel costContainer = new JPanel(new FlowLayout());
            costContainer.add(costLabel);

            JButton toCart = new JButton("Удалить");
            toCart.setForeground(Color.RED);
            toCart.addActionListener(e -> {
                data.removeProductFromCart(currentProduct);
                updatePage();
            });

            costContainer.add(toCart);
            currentItemContainer.add(costContainer);

            gridPanel.add(currentItemContainer);
        }

        costCont.removeAll();
        JLabel costdiscr = new JLabel("Общая стоимость товаров в корзине");
        JLabel totalCost = new JLabel(String.valueOf(totalItemsCost) + " руб.");
        costCont.add(costdiscr);
        costCont.add( totalCost);
        costCont.add(buy);
        costCont.revalidate();
        costCont.repaint();

        content.add(gridPanel);
        content.revalidate(); // Обновляем панель
        content.repaint(); // Перерисовываем панель
    }

}
