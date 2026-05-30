package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, float cost, String category, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName){
        if(authorName == null || authorName.trim().isEmpty()){
            throw new IllegalArgumentException("Author name cannot be empty!");
        }

        if(authors.contains(authorName)){
            throw new IllegalArgumentException(authorName + " already exists!");
        }

        authors.add(authorName);
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            throw new IllegalArgumentException(authorName + " does not exist!");
        }

        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return String.format("Book - %d - %s - %s - Authors: %s: %.2f $", getId(), getTitle(), getCategory(), String.join(", ", authors), getCost());
    }
}
