package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_CAPACITY = 20;
    private DigitalVideoDisc[] myCart = new DigitalVideoDisc[MAX_CAPACITY];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_CAPACITY){
            myCart[qtyOrdered] = disc;
            qtyOrdered ++;
            System.out.println("The disc " + disc.getTitle() + " has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for(DigitalVideoDisc disc : dvdList){
            if(qtyOrdered < MAX_CAPACITY){
                myCart[qtyOrdered] = disc;
                qtyOrdered ++;
                System.out.println("The disc " + disc.getTitle() + " has been added.");
            }
            else{
                System.out.println("The car is full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(qtyOrdered + 1 < MAX_CAPACITY){
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }
        else{
            System.out.println("The cart is almost full. Cannot add both DVDs!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for(int i = 0; i < qtyOrdered; i ++){
            if(myCart[i].equals(disc)){
                found = true;
                for(int j = i; j < qtyOrdered - 1; j ++){
                    myCart[j] = myCart[j + 1];
                }
                myCart[qtyOrdered - 1] = null;
                qtyOrdered --;
                System.out.println("Removed " + disc.getTitle());
                break;
            }
        }
        if(!found){
            System.out.println("DVD not found!");
        }
    }

    public float totalCost(){
        float s = 0;
        for(int i = 0; i < qtyOrdered; i ++){
            s += myCart[i].getCost();
        }
        return s;
    }

    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = myCart[i];
            // DVD - [Title] - [category] - [Director] - [Length]: [Price]$
            System.out.printf("%d. DVD - %s - %s - %s - %d: %.2f $\n",
                    dvd.getID(),
                    dvd.getTitle(),
                    dvd.getCategory(),
                    dvd.getDirector(),
                    dvd.getLength(),
                    dvd.getCost()
            );
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }
}