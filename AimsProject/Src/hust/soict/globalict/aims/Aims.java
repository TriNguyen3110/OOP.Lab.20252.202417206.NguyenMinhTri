package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Aims {
    public static void main(String[] args) {
        Cart myCart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Guy Ritchie", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers", "Action", "Russo Brothers", 143, 29.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Batman", "Action", "Christopher Nolan", 140, 22.50f);

        System.out.println("-----ADDING-----");
        myCart.addMedia(dvd1);
        myCart.addMedia(dvd2);
        myCart.addMedia(dvd3);
        myCart.print();

        System.out.println("-----REMOVING-----");
        myCart.removeMedia(dvd2);
        myCart.print();

        System.out.println("-----TEST REMOVE UNKNOWN-----");
        DigitalVideoDisc fakeDVD = new DigitalVideoDisc("Fake", "Test", "Unknown", 100, 10f);
        myCart.removeMedia(fakeDVD);
        myCart.print();

        System.out.println("\n-----TEST ADD LIST-----");
        Media[] dvdList = {dvd4, dvd5};
        for (Media m : dvdList) {
            myCart.addMedia(m);
        }
        myCart.print();

        System.out.println("\n-----TEST ADD TWO DVDs-----");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Spider-Man", "Action", "Jon Watts", 133, 21.00f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Cinderella", "Animation", "Kenneth Branagh", 105, 15.50f);

        myCart.addMedia(dvd6);
        myCart.addMedia(dvd7);
        myCart.print();

        System.out.println("\n-----TEST SEARCH-----");
        myCart.searchByTitle("Aladdin");
        myCart.searchById(1);
    }
}