import java.io.Serializable;

public class Game implements Serializable {
    private int id;
    private String title;
    private String publisher;
    private int year;
    private boolean deleted;

    public Game() {

    }

    public Game(int id, String title, String publisher, int year, boolean deleted) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String exportTxt() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getId() + "\n");
        sb.append(this.getTitle() + "\n");
        sb.append(this.getPublisher() + "\n");
        sb.append(this.getYear() + "\n");

        return sb.toString();
    }

    public String exportXML() {
        return this.getTitle() + " (" + this.getYear() + ")";
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", deleted=" + deleted +
                '}';
    }
}
