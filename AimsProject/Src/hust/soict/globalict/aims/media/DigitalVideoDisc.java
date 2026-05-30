package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
        if (length <= 0) {
            throw new IllegalArgumentException("ERROR: DVD length must be positive!");
        }
        updateID();
    }

    private void updateID(){
        nbDigitalVideoDiscs ++;
        this.setId(nbDigitalVideoDiscs);
    }

    @Override
    public String toString() {
        return String.format("DVD - %d - %s - %s - %s - %d: %.2f $", getId(), getTitle(), getCategory(), getDirector(), getLength(), getCost());
    }

    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() <= 0){
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}