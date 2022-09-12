package videoclub;

public abstract class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateAmount(int daysRented);

    //All movies get 1 point by default
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
