package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.CartScreen; // Import CartScreen instead of StoreScreen for testing
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        initSetup();

        cart.addMedia(store.getItemsInStore().get(0));
        cart.addMedia(store.getItemsInStore().get(3));
        cart.addMedia(store.getItemsInStore().get(6));

        System.out.println("Launching AIMS Graphical User Interface (Cart Screen)...");

        new CartScreen(cart);
    }

    public static void initSetup(){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Avatar: The Way of Water", "Sci-Fi", "James Cameron", 192, 29.99f);

        Book book1 = new Book(10, "Java Programming", 29.99f, "Education", new ArrayList<>(Arrays.asList("James Gosling", "Joshua Bloch")));
        Book book2 = new Book(11, "Design Patterns", 39.95f, "Software Engineering", new ArrayList<>(Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson")));
        Book book3 = new Book(12, "Clean Code", 45.00f, "Computer Science", new ArrayList<>(Arrays.asList("Robert C. Martin")));

        CompactDisc cd1 = new CompactDisc("Beethoven Symphony No. 9", "Classical", "Herbert von Karajan", 74, 15.00f, "Ludwig van Beethoven");
        cd1.addTrack(new Track("Allegro ma non troppo", 18));
        cd1.addTrack(new Track("Molto vivace", 12));

        CompactDisc cd2 = new CompactDisc("Dark Side of the Moon", "Rock", "Pink Floyd", 43, 18.50f, "Pink Floyd");
        cd2.addTrack(new Track("Speak to Me", 1));
        cd2.addTrack(new Track("Breathe", 3));
        cd2.addTrack(new Track("Time", 7));

        CompactDisc cd3 = new CompactDisc("Random Access Memories", "Electronic", "Daft Punk", 74, 21.00f, "Daft Punk");
        cd3.addTrack(new Track("Give Life Back to Music", 4));
        cd3.addTrack(new Track("Instant Crush", 5));
        cd3.addTrack(new Track("Get Lucky", 6));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
    }
}