package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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

    public void displayCart(){
        System.out.println("----- MY CART -----");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-3d\t%-15s\t%7.2f\n", 
                i + 1, 
                myCart[i].getTitle(), 
                myCart[i].getCost()
            );
        }
        System.out.printf("Total Cost\t%.2f\n", totalCost());
    }
}