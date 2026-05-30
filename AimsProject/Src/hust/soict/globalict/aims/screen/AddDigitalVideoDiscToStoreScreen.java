package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);

        Container cp = getContentPane();

        JPanel center = new JPanel(new GridLayout(6, 2, 10, 10));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        JButton btnAdd = new JButton("Add DVD");

        center.add(new JLabel("Title"));
        center.add(tfTitle);

        center.add(new JLabel("Category"));
        center.add(tfCategory);

        center.add(new JLabel("Director"));
        center.add(tfDirector);

        center.add(new JLabel("Length"));
        center.add(tfLength);

        center.add(new JLabel("Cost"));
        center.add(tfCost);

        center.add(new JLabel(""));
        center.add(btnAdd);

        cp.add(center, BorderLayout.CENTER);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                try {
                    int length = Integer.parseInt(tfLength.getText());

                    float cost = Float.parseFloat(tfCost.getText());

                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

                    store.addMedia(dvd);

                    JOptionPane.showMessageDialog(null, "DVD added successfully!");

                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfDirector.setText("");
                    tfLength.setText("");
                    tfCost.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Length và Cost phải là số hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cp.revalidate();
        cp.repaint();
    }
}