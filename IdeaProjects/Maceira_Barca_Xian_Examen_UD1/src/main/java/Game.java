public class Game {

    private int Id;
    private String title;
    private String publisher;
    private int year;
    private boolean isDeleted;


    public Game() {

    }
    public Game(int id, String title, String publisher, int year, boolean isDeleted) {
        Id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Game{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
