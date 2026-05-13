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
        if(tracks.contains(inputTrack)){
            System.out.println("Track " + inputTrack.getTitle() + " is already in the list.");
        }
        else{
            tracks.add(inputTrack);
            System.out.println("Track " + inputTrack.getTitle() + " has been added to the list.");
        }
    }

    public void removeTrack(Track inputTrack){
        if(tracks.contains(inputTrack)){
            tracks.remove(inputTrack);
            System.out.println("Track " + inputTrack.getTitle() + " has been removed out of the list.");
        }
        else{
            System.out.println("Track " + inputTrack.getTitle() + " does not exist in the list.");
        }
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
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        for(Track track : tracks){
            track.play();
        }
    }
}
