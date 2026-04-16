package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
    public DigitalVideoDisc itemsInStore[];
    private int qtyInStore = 0;
    private static final int max_items = 1000;

    public Store(){
        itemsInStore = new DigitalVideoDisc[max_items];
    }

    public void addDVD(DigitalVideoDisc dvd){
        if(qtyInStore < max_items){
            itemsInStore[qtyInStore] = dvd;
            qtyInStore ++;
            System.out.println("The DVD " + dvd.getTitle() + " has been addded to the store");
        }
        else{
            System.out.println("The store is almost full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd){
        boolean check = false;
        for(int i = 0; i < qtyInStore; i ++){
            if(itemsInStore[i].equals(dvd)){
                for(int j = i; j < qtyInStore - 1; j ++){
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore --;
                check = true;
                System.out.println("The DVD " + dvd.getTitle() + " has been removed out of the store");
                break;
            }
        }
        if(!check){
            System.out.println("The DVD " + dvd.getTitle() + " was not found in the store");
        }
    }
}
