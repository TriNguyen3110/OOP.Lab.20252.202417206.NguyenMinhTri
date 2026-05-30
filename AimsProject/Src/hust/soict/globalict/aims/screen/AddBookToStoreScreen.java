package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);

        Container cp = getContentPane();

        JPanel center = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();

        JButton btnAdd = new JButton("Add Book");

        center.add(new JLabel("Title"));
        center.add(tfTitle);

        center.add(new JLabel("Category"));
        center.add(tfCategory);

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

                try {
                    float cost = Float.parseFloat(tfCost.getText());

                    Book book = new Book(title, category, cost);

                    store.addMedia(book);

                    JOptionPane.showMessageDialog(null, "Book added successfully!");

                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfCost.setText("");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Cost must be a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cp.revalidate();
        cp.repaint();
    }
}