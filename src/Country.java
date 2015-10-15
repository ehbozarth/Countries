/**
 * Created by earlbozarth on 10/15/15.
 */
public class Country {
    String abrev;
    String name;

    public Country() {
    }

    public Country(String abrev, String name) {
        this.abrev = abrev;
        this.name = name;
    }//End of Country constructor

    public String getAbrev() {
        return abrev;
    }

    public String getName() {
        return name;
    }
}//End of Country Class
