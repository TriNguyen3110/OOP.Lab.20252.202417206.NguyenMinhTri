package hust.soict.globalict.aims.media;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        if(length <= 0){
            throw new IllegalArgumentException("Track length must be positive!");
        }
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play(){
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if((obj == null) || !(obj instanceof Track)){
            return false;
        }
        Track item = (Track) obj;
        return this.title.equalsIgnoreCase(item.getTitle()) && this.length == item.getLength();
    }
}