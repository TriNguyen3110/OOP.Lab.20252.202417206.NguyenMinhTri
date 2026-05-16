package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media){
        if(!itemsInStore.contains(media)){
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
        else{
            System.out.println("The media " + media.getTitle() + " is already in the store");
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed out of the store.");
        }
        else{
            System.out.println("The media " + media.getTitle() + " does not exist in the store.");
        }
    }

    public Media search(String title){
        for(Media media : itemsInStore){
            if(media.isMatch(title)){
                return media;
            }
        }
        return null;
    }

    public void printStore(){
        System.out.println("\n***********************STORE***********************");
        if(itemsInStore.isEmpty()){
            System.out.println("The store is empty.");
        }
        else{
            for(Media media : itemsInStore){
                System.out.println(media.toString());
            }
        }
        System.out.println("***************************************************");
    }
}
