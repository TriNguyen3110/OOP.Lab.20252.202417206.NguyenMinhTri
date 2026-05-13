package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title){
        super();
        this.setTitle(title);
        updateID();
    }

    public DigitalVideoDisc(String category, String title, float cost){
        super();
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        updateID();
    }

    public DigitalVideoDisc(String director, String category, String title, float cost){
        super();
        this.setDirector(director);
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        updateID();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(title, category, director, length, cost);
        updateID();
    }

    private void updateID(){
        nbDigitalVideoDiscs ++;
        this.setId(nbDigitalVideoDiscs);
    }

    public boolean isMatch(String title){
        return this.getTitle().equalsIgnoreCase(title);
    }

    @Override
    public String toString(){
        return  getId() + ".DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }

    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}