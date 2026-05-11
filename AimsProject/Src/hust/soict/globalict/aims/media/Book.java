package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, float cost, String category, List<String> authors) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.category = category;
        this.authors = authors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setAuthors(List<String> authors) {
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
}
