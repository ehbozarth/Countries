import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "countries.txt";
        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        String countryContent = readFile(fileName);
        String [] lines = countryContent.split("\n");

        for (String line : lines){
            String [] columns = line.split("\\|");
            String firstLetter = String.valueOf(line.charAt(0));
            ArrayList<Country> countryList = countryMap.get(firstLetter);
            //ArrayList<String> frstLetters = countryMap.get(firstLetter);
            String abrev = columns[0];
            String name = columns[1];
            Country country = new Country(abrev, name);
            countryMap.put(firstLetter, countryList);

            //ArrayList<String> list = countryMap.get(firstLetter);
            if (countryList == null){
                countryList = new ArrayList();
                country = new Country(abrev, name);
                countryList.add(country);
                countryMap.put(firstLetter, countryList);
            }//End of if. If list is null, Create a new list for that letter, then add name to letter, then put letter and name in groups
            else{
                countryList.add(country);
            }//End of else

        }//End of for Loop
        //System.out.println(countryMap);
        System.out.println("Please enter in a letter:");
        String testLetter = scanner.nextLine().toUpperCase();
        String newFileName = String.format("%s_countries.txt", testLetter);
        //if(countryContent.startsWith(testLetter)) {
            writeFile(newFileName, countryContent);
        //}//End of if statement

    }//End of Main Method

    static String readFile(String fileName){
        File f = new File(fileName);
        try{
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char [] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        }//End of try
        catch (Exception e){
            System.out.println("Error...Error...Error");
            return null;
        }//End of catch
    }//end of readFile

    static void writeFile(String fileName,String fileContent){
        File f = new File(fileName);
        try{
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        }//End of Try
        catch(Exception e){
            System.out.println("Error...Error...Error");
        }//End of Catch
    }//End of wrtieFile
}//End of Countries Class
