package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.Media;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void addMedia(Media media){
        if(media == null){
            throw new IllegalArgumentException("Media cannot be null!");
        }

        if(itemsOrdered.contains(media)){
            throw new IllegalArgumentException("Media already exists in cart!");
        }

        itemsOrdered.add(media);
    }

    public void removeMedia(Media media){
        if(!itemsOrdered.contains(media)){
            throw new IllegalArgumentException("Media is not in cart!");
        }

        itemsOrdered.remove(media);
    }

    public void searchById(int id){
        boolean found = false;
        for(Media media : itemsOrdered){
            if(media.getId() == id){
                System.out.println("Successfully found: " + media.toString());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("No media found with id: " + id);
        }
    }

    public void searchByTitle(String title){
        boolean found = false;
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                System.out.println("Successfully found: " + media.toString());
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("No media found with title: " + title);
        }
    }

    public float totalCost(){
        float total = 0;
        for(Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    public void sortByTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("The cart has been sorted by title.");
    }

    public void sortByCost(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("The cart has been sorted by cost.");
    }

    public Media search(String title){
        for(Media media : itemsOrdered){
            if(media.isMatch(title)){
                return media;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++){
            System.out.printf("%d. %s\n", (i + 1), itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }
}