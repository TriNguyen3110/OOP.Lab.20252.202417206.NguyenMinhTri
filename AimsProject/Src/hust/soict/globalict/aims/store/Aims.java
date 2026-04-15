package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart myCart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Guy Ritchie", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers", "Action", "Russo Brothers", 143, 29.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Batman", "Action", "Christopher Nolan", 140, 22.50f);

        // Add DVD
        System.out.println("-----ADDING-----");
        myCart.addDigitalVideoDisc(dvd1);
        myCart.addDigitalVideoDisc(dvd2);
        myCart.addDigitalVideoDisc(dvd3);
        myCart.displayCart();

        // Remove DVD
        System.out.println("-----REMOVING-----");
        myCart.removeDigitalVideoDisc(dvd2); // xóa Star Wars
        myCart.displayCart();

        // Remove unknown DVD
        System.out.println("-----TEST REMOVE UNKOWN-----");
        DigitalVideoDisc fakeDVD = new DigitalVideoDisc("Fake", "Test", "Unknown", 100, 10f);
        myCart.removeDigitalVideoDisc(fakeDVD);
        myCart.displayCart();

        System.out.println("\n-----TEST ADD LIST (OVERLOADING)-----");
        DigitalVideoDisc[] dvdList = {dvd4, dvd5};
        myCart.addDigitalVideoDisc(dvdList);
        myCart.displayCart();

        System.out.println("\n-----TEST ADD TWO DVDs (OVERLOADING)-----");
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Spider-Man", "Action", "Jon Watts", 133, 21.00f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Cinderella", "Animation", "Kenneth Branagh", 105, 15.50f);

        myCart.addDigitalVideoDisc(dvd6, dvd7);
        myCart.displayCart();
    }
}