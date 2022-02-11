package Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String name, int year, String... authors) {
        this.title = name;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        int compared = o.getTitle().compareTo(this.getTitle());
        if (compared == 0){
            return Integer.compare(o.getYear(), this.getYear());
        }
        return compared;
    }

    @Override
    public String toString() {
        return String.format("%s", this.title);
    }
}
