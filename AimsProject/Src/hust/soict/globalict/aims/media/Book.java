package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, float cost, String category, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println(authorName + " has been added to the author list.");
        }
        else{
            System.out.println(authorName + " already exists in the author list.");
        }
    }

    public void removeAuthor(String authorName){
        if(authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println(authorName + " has been removed out of the author list.");
        }
        else{
            System.out.println(authorName + " does not exist in the author list.");
        }
    }

    @Override
    public String toString() {
        return String.format("Book - %d - %s - %s - Authors: %s: %.2f $", getId(), getTitle(), getCategory(), String.join(", ", authors), getCost());
    }
}
