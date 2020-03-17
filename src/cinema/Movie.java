package cinema;
import java.util.HashMap;

public class Movie {
    
    //--------ATTRIBUTES----------
    
    private String id;
    private String name;
    private String description;
    private String[] genre;
    private HashMap<String, Integer> rating;
    private String[] directors;
    private String[] actors;
    private String[] language;
    private String countryOfOrigin;
    
    //--------ATTRIBUTES----------
    
    //--------CONSTRUCTOR----------

    public Movie(String id, String name, String description, String[] genre, HashMap<String, Integer> rating, String[] directors, String[] actors, String[] language, String countryOfOrigin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.directors = directors;
        this.actors = actors;
        this.language = language;
        this.countryOfOrigin = countryOfOrigin;
    }
    
    //--------CONSTRUCTOR----------
    
    //--------GETTERS----------

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getGenre() {
        return genre;
    }

    public HashMap<String, Integer> getRating() {
        return rating;
    }

    public String[] getDirectors() {
        return directors;
    }

    public String[] getActors() {
        return actors;
    }

    public String[] getLanguage() {
        return language;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    
    //--------GETTERS----------
    
    //--------SETTERS----------

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public void setRating(HashMap<String, Integer> rating) {
        this.rating = rating;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    
    //--------SETTERS----------
    
    
    

    
}
