package videoclub.movies;

import videoclub.Movie;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3;
    }

    //NewRelease Movies have also bonus points if (daysRented > 1)
    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return super.calculateFrequentRenterPoints(daysRented) +1;

        return super.calculateFrequentRenterPoints(daysRented);
    }
}
