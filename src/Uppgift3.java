import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Uppgift3 {
    public static void main(String[] args) {
        System.out.println("- Assignment 3: Film library -");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create relevant ArrayLists
        ArrayList<String> filmLibTitles = new ArrayList<>();
        ArrayList<String> filmLibGenres = new ArrayList<>();
        ArrayList<Integer> filmLibReleaseYears = new ArrayList<>();
        ArrayList<Double> filmLibRating = new ArrayList<>();

        // Add some recipes
        addMovie(filmLibTitles, filmLibGenres, filmLibReleaseYears, filmLibRating, "The Shawshank Redemption", "Epic Period Drama Prison Drama Drama", 1994, 9.3f);
        addMovie(filmLibTitles, filmLibGenres, filmLibReleaseYears, filmLibRating, "The Godfather", "Epic Gangster Tragedy Crime Drama", 1972, 9.2f);
        addMovie(filmLibTitles, filmLibGenres, filmLibReleaseYears, filmLibRating, "The Dark Knight", "Action Epic Epic Superhero Tragedy Action Crime Drama Thriller", 2008, 9.1f);
        addMovie(filmLibTitles, filmLibGenres, filmLibReleaseYears, filmLibRating, "The Godfather Part II", "Epic Gangster Tragedy Crime Drama", 1974, 9.0f);
        addMovie(filmLibTitles, filmLibGenres, filmLibReleaseYears, filmLibRating, "12 Angry Men", "Legal Drama Psychological Drama Crime Drama", 1957, 9.0f);
    }

    public static void addMovie(
            ArrayList<String> filmLibraryTitles,
            ArrayList<String> filmLibraryGenres,
            ArrayList<Integer> filmLibraryReleaseYears,
            ArrayList<Double> filmLibraryRating,
            String title,
            String genre,
            int releaseYear,
            double rating
    ) {
        filmLibraryTitles.add(title);
        filmLibraryGenres.add(genre);
        filmLibraryReleaseYears.add(releaseYear);
        filmLibraryRating.add(rating);
        System.out.printf("Added movie \"%s\" %d!\n", title, releaseYear);
    }

//    public static void visaAllaFilmer(ArrayList<String> filmLibraryTitles, ArrayList<String> filmLibraryGenres, ArrayList<Integer> år, ArrayList<Double> betyg) {
//
//    }
//
//    public static ArrayList<String> filtreraGenre(ArrayList<String> filmLibraryTitles, ArrayList<String> filmLibraryGenres, String valdGenre) {
//
//    }
//
//    public static ArrayList<String> bästaFilmer(ArrayList<String> filmLibraryTitles, ArrayList<Double> betyg, double minBetyg) {
//
//    }
//
//    public static double genomsnittsbetyg(ArrayList<Double> betyg) {
//
//    }
//
//    public static ArrayList<String> filmFrånÅr(ArrayList<String> filmLibraryTitles, ArrayList<Integer> år, int årtal) {
//
//    }
}
