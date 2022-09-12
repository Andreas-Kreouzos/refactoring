package videoclub;

class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int calcFrequentRenterPoints() {
        return movie.calculateFrequentRenterPoints(daysRented);
    }

    public double calculateRentalAmount() {
        return movie.calculateAmount(daysRented);
    }

    public String getTitle() {
        return movie.getTitle();
    }
}
