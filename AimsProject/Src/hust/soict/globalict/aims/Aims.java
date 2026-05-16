package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initSetup(); // Set up the store;

        while (true){
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    viewCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS.");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public static void initSetup(){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        Book book1 = new Book(10, "Java Programming", 29.99f, "Education", new ArrayList<>(Arrays.asList("James Gosling", "Joshua Bloch")));

        CompactDisc cd1 = new CompactDisc("Beethoven Symphony No. 9", "Classical", "Herbert von Karajan", 74, 15.00f, "Ludwig van Beethoven");
        cd1.addTrack(new Track("Allegro ma non troppo", 18));
        cd1.addTrack(new Track("Molto vivace", 12));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu(){
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore(){
        while (true){
            store.printStore();
            storeMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: // See a media's details
                    System.out.println("Enter the title of the media: ");
                    String title = sc.nextLine();
                    Media media = store.search(title);
                    if(media != null){
                        System.out.println(media.toString());
                        handleMediaDetailsMenu(media);
                    }
                    else{
                        System.out.println("Media not found!");
                    }
                    break;
                case 2: // Add a media to cart
                    System.out.println("Enter the title of the media to add to cart: ");
                    String tAdd = sc.nextLine();
                    Media mAdd = store.search(tAdd);
                    if(mAdd != null){
                        cart.addMedia(mAdd);
                    }
                    else{
                        System.out.println("Media not found!");
                    }
                    break;
                case 3: // Play a media
                    System.out.println("Enter the title of the media to play: ");
                    String tPlay = sc.nextLine();
                    Media mPlay = store.search(tPlay);
                    if(mPlay != null){
                        playMedia(mPlay);
                    }
                    else{
                        System.out.println("Media not found!");
                    }
                    break;
                case 4: // See a current cart
                    viewCart();
                    break;
                case 0: // Back
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void handleMediaDetailsMenu(Media media){
        mediaDetailsMenu();
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1: // Add to cart
                cart.addMedia(media);
                break;
            case 2: // Play
                playMedia(media);
                break;
            case 0: // Back
                return;
            default:
                System.out.println("Invalid option!");
        }
    }

    private static void updateStore(){
        System.out.println("\n1. Add a media to Store");
        System.out.println("2. Remove a media from the Store");
        System.out.println("Please enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1){ // Add a new media
            System.out.println("\nChoose media type: ");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            int mChoice = sc.nextInt();
            sc.nextLine();

            if(mChoice == 1){ // Add new book
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter title: ");
                String title = sc.nextLine();

                System.out.println("Enter category: ");
                String category = sc.nextLine();

                System.out.println("Enter cost: ");
                float cost = sc.nextFloat();
                sc.nextLine();

                ArrayList<String> authors = new ArrayList<>();

                System.out.print("Enter number of authors: ");
                int n = sc.nextInt();
                sc.nextLine();

                for (int i = 1; i <= n; i++) {
                    System.out.print("Enter author " + (i) + ": ");
                    String author = sc.nextLine();
                    authors.add(author);
                }
                Book newBook = new Book(id, title, cost, category, authors);
                store.addMedia(newBook);
            }
            else if(mChoice == 2){ // Add new DVD
                System.out.println("Enter title: ");
                String title = sc.nextLine();

                System.out.println("Enter category: ");
                String category = sc.nextLine();

                System.out.println("Enter director: ");
                String director = sc.nextLine();

                System.out.print("Enter length: ");
                int length = sc.nextInt();

                System.out.print("Enter cost: ");
                float cost = sc.nextFloat();
                sc.nextLine();

                DigitalVideoDisc newDVD = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(newDVD);
            }
            else if(mChoice == 3){ // Add new CD
                System.out.print("Enter title: ");
                String title = sc.nextLine();

                System.out.print("Enter category: ");
                String category = sc.nextLine();

                System.out.print("Enter artist: ");
                String artist = sc.nextLine();

                System.out.print("Enter director: ");
                String director = sc.nextLine();

                System.out.print("Enter cost: ");
                float cost = sc.nextFloat();
                sc.nextLine();

                CompactDisc newCD = new CompactDisc(title, category, director, 0, cost, artist);

                System.out.println("Enter the number of tracks: ");
                int n = sc.nextInt();
                sc.nextLine();

                for(int i = 1; i <= n; i ++){
                    System.out.println("\nTrack " + (i) + ": ");

                    System.out.print("Enter track title: ");
                    String trackTitle = sc.nextLine();

                    System.out.print("Enter track length: ");
                    int trackLength = sc.nextInt();
                    sc.nextLine();

                    Track track = new Track(trackTitle, trackLength);

                    newCD.addTrack(track);
                }
                store.addMedia(newCD);
            }
            else{
                System.out.println("Invalid media type!");
            }
        }
        else if(choice == 2){ // Remove a media
            System.out.println("Enter media title to remove: ");
            String title = sc.nextLine();

            Media media = store.search(title);
            if(media != null){
                store.removeMedia(media);
            }
            else{
                System.out.println("Media does not exist in the store.");
            }
        }
        else{
            System.out.println("Invalid option!");
        }
    }

    private static void viewCart(){
        while (true){
            cart.print();
            cartMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: // Filter medias in cart
                    System.out.println("\n1. Filter by ID");
                    System.out.println("2. Filter by title");
                    int fChoice = sc.nextInt();
                    sc.nextLine();

                    if(fChoice == 1){
                        System.out.println("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        cart.searchById(id);
                    }
                    else{
                        System.out.println("Enter title: ");
                        String title = sc.nextLine();
                        cart.searchByTitle(title);
                    }
                    break;
                case 2: // Sort medias in cart
                    System.out.println("\n1. Sort by title");
                    System.out.println("2. Sort by cost");
                    int sChoice = sc.nextInt();
                    sc.nextLine();

                    if(sChoice == 1){
                        cart.sortByTitle();
                    }
                    else{
                        cart.sortByCost();
                    }
                    break;
                case 3: // Remove media from a cart
                    System.out.println("Enter media title to remove from the cart: ");
                    String rTitle = sc.nextLine();
                    Media rMedia = cart.search(rTitle);
                    if(rMedia != null){
                        cart.removeMedia(rMedia);
                    }
                    else{
                        System.out.println("Media not found in the cart!");
                    }
                    break;
                case 4: // Play
                    System.out.println("Enter media title to play from cart: ");
                    String pTitle = sc.nextLine();
                    Media pMedia = cart.search(pTitle);
                    if(pMedia != null){
                        playMedia(pMedia);
                    }
                    else{
                        System.out.println("Media not found in cart!");
                    }
                    break;
                case 5: // Place order
                    System.out.println("An order has been created successfully!");
                    cart = new Cart();
                    break;
                case 0: // Back
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void playMedia(Media media){
        if(media instanceof Playable){
            ((Playable)media).play();
        }
        else{
            System.out.println("This media cannot be played!");
        }
    }
}