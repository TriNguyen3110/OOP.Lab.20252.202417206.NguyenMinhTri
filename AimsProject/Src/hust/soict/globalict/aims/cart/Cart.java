package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media){
        if(!itemsOrdered.contains(media)){
            itemsOrdered.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the cart.");
        }
        else{
            System.out.println("The media " + media.getTitle() + " is already in the .");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            itemsOrdered.remove((media));
            System.out.println("The media " + media.getTitle() + " has been removed out of the cart.");
        }
        else{
            System.out.println("The media " + media.getTitle() + " is not in the cart.");
        }
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