package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JPanel{

    private final ActionListener actionListener;
    int linksCount;
    Image logo;
    JLabel [] links;
    String [] linksList;
    final String logoPath = "C:\\Course4\\CourseWork\\src\\Img\\MainPage\\logo.png";

    Menu(ActionListener al){
        actionListener = al;
        setPreferredSize(new Dimension(1200, 100));
        setLayout(new FlowLayout());
        setLinksList();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ImageIcon originalLogo = new ImageIcon(logoPath);
        Image originalLogoImage = originalLogo.getImage();

        logo = originalLogoImage.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(logo));

        add(iconLabel, FlowLayout.LEFT);

        linksCount = linksList.length;
        links = new JLabel[linksCount];
        for (int i = 0; i < linksCount; i++) {
            links[i] = new JLabel(linksList[i]);
            String name = linksList[i];
            links[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            JLabel currentLink = links[i];
            links[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, name));
                }
                @Override
                public void mouseEntered(MouseEvent e){
                    currentLink.setForeground(Color.BLUE);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    currentLink.setForeground(Color.BLACK); // Возврат к исходному цвету
                }
            });
            links[i].setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
            add(links[i]);
        }
    }

    private void setLinksList(){
        linksList = new String[]{"Главная", "Каталог", "Корзина"};
    }

}
