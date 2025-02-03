package Components;

import Data.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class SliderPanel extends JPanel {

    private int currentIndex = 0; // Индекс текущего изображения
    private Timer timer; // Таймер для автоматической смены слайдов
    private Product [] items;
    private JPanel sliderItem;
    int itemsCount;

    public SliderPanel(int i, Product [] ims) {

        items = ims;
        itemsCount = i;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1200, 500));
        sliderItem = new JPanel();
        sliderItem.setLayout(new BoxLayout(sliderItem, BoxLayout.Y_AXIS));
        add(sliderItem);
        timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextProduct();
            }
        });
        timer.start();

        updateSlider();
    }

    private void updateSlider() {

        sliderItem.removeAll();
        Product currentProduct = items[currentIndex];

        ImageIcon originalIcon = new ImageIcon(currentProduct.getIcon());
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(800, 400, Image.SCALE_SMOOTH);

        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        sliderItem.add(iconLabel);

        JLabel nameLabel = new JLabel(currentProduct.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 22));
        sliderItem.add(nameLabel);

        JLabel costLabel = new JLabel("Цена: " + currentProduct.getCost() + " руб.");
        sliderItem.add(costLabel);

        sliderItem.revalidate();
        sliderItem.repaint();
    }

    private void nextProduct() {
        if (currentIndex == itemsCount - 1) {
            currentIndex = 0;
            updateSlider();
            return;
        }
         currentIndex++;
        updateSlider();
    }

}