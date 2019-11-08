import java.io.*;
import java.util.ArrayList;

public class ItemFile {
    static FileReader in;
    static BufferedReader readFile;
    static String lineOfText;
    
    public static String[] getValues(String str) {
        String[] inv = new String[2];
        File textFile = new File("src/resources/items.dat");
        
        try {
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null) {
                if (lineOfText.contains(str)) {
                    inv = lineOfText.split(",");
                    break;
                }
            }
            readFile.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        return inv;
    }
    
    public static String[] getValues() {
        File textFile = new File("src/resources/items.dat");
        ArrayList<String[]> arr = new ArrayList<>();
        
        try {
            in = new FileReader(textFile);
            readFile = new BufferedReader(in);
            while ((lineOfText = readFile.readLine()) != null) {
                arr.add(lineOfText.split(","));
            }
            readFile.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
            System.err.println("IOException: " + e.getMessage());
        }
        return arr.get((int)(Math.random() * (arr.size() - 1)));
    }
}
