package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);

        Container cp = getContentPane();

        JPanel center = new JPanel(new GridLayout(7, 2, 10, 10));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        JButton btnAdd = new JButton("Add CD");

        center.add(new JLabel("Title"));
        center.add(tfTitle);

        center.add(new JLabel("Category"));
        center.add(tfCategory);

        center.add(new JLabel("Director"));
        center.add(tfDirector);

        center.add(new JLabel("Artist"));
        center.add(tfArtist);

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
                String artist = tfArtist.getText();

                try {
                    int length = Integer.parseInt(tfLength.getText());
                    float cost = Float.parseFloat(tfCost.getText());

                    CompactDisc cd = new CompactDisc(title, category, director, length, cost, artist);

                    store.addMedia(cd);

                    JOptionPane.showMessageDialog(null, "CD added successfully!");

                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfDirector.setText("");
                    tfArtist.setText("");
                    tfLength.setText("");
                    tfCost.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Length and Cost must be valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cp.revalidate();
        cp.repaint();
    }
}