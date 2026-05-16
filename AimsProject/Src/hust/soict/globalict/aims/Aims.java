package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;

import java.util.ArrayList;
import java.util.Arrays;

public class Aims {
    public static void main(String[] args) {
        Cart myCart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);

        Book book1 = new Book(10, "Java Programming", 29.99f, "Education", new ArrayList<>(Arrays.asList("James Gosling", "Joshua Bloch")));
        Book book2 = new Book(11, "Design Patterns", 39.50f, "Technology", new ArrayList<>(Arrays.asList("Erich Gamma")));

        CompactDisc cd1 = new CompactDisc("Beethoven Symphony No. 9", "Classical", "Herbert von Karajan", 74, 15.00f, "Ludwig van Beethoven");

        Track track1 = new Track("Allegro ma non troppo", 18);
        Track track2 = new Track("Molto vivace", 12);
        Track track3 = new Track("Adagio molto e cantabile", 16);

        cd1.addTrack(track1);
        cd1.addTrack(track2);
        cd1.addTrack(track3);

        System.out.println("----- ADDING MULTIPLE TYPES OF MEDIA -----");
        myCart.addMedia(dvd1);
        myCart.addMedia(book1);
        myCart.addMedia(cd1);
        myCart.addMedia(dvd2);
        myCart.addMedia(book2);

        myCart.print();
    }
}