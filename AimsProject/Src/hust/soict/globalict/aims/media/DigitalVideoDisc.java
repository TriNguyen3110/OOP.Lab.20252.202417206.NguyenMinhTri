package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;

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
        this.director = director;
        this.setCategory(category);
        this.setTitle(title);
        this.setCost(cost);
        updateID();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
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
        return  getId() + ".DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
    }

    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }

    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }
}