package Components;

import Data.FurnitureData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class FurnitureStoreApp {
    static FurnitureData data = new FurnitureData();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Мебельный магазин");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);

        FurnitureMainPage mp = new FurnitureMainPage(data);
        FurnitureCatalog ct = new FurnitureCatalog(data);
        FurnitureCart cr = new FurnitureCart(data);

        Page [] pages = {mp, ct, cr};
        JPanel currentPage = new JPanel();
        currentPage.setPreferredSize(new Dimension(1200, 1000));
        currentPage.add(pages[0]);
        Menu headerMenu = new Menu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                currentPage.removeAll();
                Page page = getPageByName(command, pages);
                if (command.equals("Корзина")){
                    page.updatePage();
                }
                currentPage.add(page);
                currentPage.revalidate();
                currentPage.repaint();
            }
        });
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(headerMenu, BorderLayout.NORTH);
        frame.getContentPane().add(currentPage, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    static Page getPageByName(String name, Page [] pages){
        for (Page page : pages) {
            if (name.equals(page.getPageName())){
                return page;
            }
        }
        return pages[0];
    }
}
