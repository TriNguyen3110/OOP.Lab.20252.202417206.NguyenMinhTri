package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track inputTrack){
        if(inputTrack == null){
            throw new IllegalArgumentException("Track cannot be null!");
        }

        if(tracks.contains(inputTrack)){
            throw new IllegalArgumentException("Track already exists!");
        }

        tracks.add(inputTrack);
    }

    public void removeTrack(Track inputTrack){
        if(!tracks.contains(inputTrack)){
            throw new IllegalArgumentException("Track does not exist!");
        }

        tracks.remove(inputTrack);
    }

    @Override
    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play(){
        if(this.getLength() <= 0){
            throw new IllegalArgumentException("CD length is non-positive!");
        }

        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        for(Track track : tracks){
            track.play();
        }
    }

    @Override
    public String toString() {
        return String.format("CD - %d - %s - %s - Artist: %s - Director: %s - Length: %d: %.2f $", getId(), getTitle(), getCategory(), getArtist(), getDirector(), getLength(), getCost());
    }
}
