/**
 * Created by madgriff on 7/6/14.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PasswordCrack {

    private static ArrayList<String> dictionary;
    private static ArrayList<User> users;
    private static String inputFile;
    private static String dictionaryFile;
    private static boolean verbose;

    public static void main(String[] args){
        /* Comment out to remove print statements */
        verbose = true;
        try{
            scanArgs(args);
        }
        catch (NullPointerException ex){
            System.out.println("Invalid input");
        }

        run();
    }
    /* scan input file arguments and store */
    public static void scanArgs(String[] args) {
        inputFile = args[1];
        dictionaryFile = args[0];

        if(verbose) System.out.println("Dictionary Name = " + dictionaryFile);
        if(verbose) System.out.println("Filename = " + inputFile);

    }
    public static void run(){
        try {
            readDictFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            readUserFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /* parse through the dictionary file and create dictionary
    * to use for password cracking                              */
    public static void readDictFile() throws FileNotFoundException {
        if(verbose) System.out.println("Creating Dictionary...");
        Scanner scan = new Scanner(new FileInputStream(dictionaryFile));
        dictionary = new ArrayList<String>();
        while(scan.hasNextLine()){
            dictionary.add(scan.nextLine().replaceAll("\n", ""));
        }

    }
    /* read the user file and add new user to the arrayList */
    public static void readUserFile() throws FileNotFoundException {
        if(verbose) System.out.println("Reading File...");
        Scanner scan = new Scanner(new FileInputStream(inputFile));
        users = new ArrayList<User>();
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            User user = parsePWLine(line);
            users.add(user);
        }

    }
    /* parse line and create a new user object, storing appropriate fields */
    public static User parsePWLine(String line){
       User newUser = new User();
       String[] tokens = line.split(":");
       if(verbose) System.out.println("Tokens : " + Arrays.toString(tokens));
       newUser.setUserID(tokens[0]);
       String temp = tokens[1];
       String salt = temp.substring(0,2);
       String pw = temp.substring(2);
       newUser.setSalt(salt);
       newUser.setPassword(pw);
       newUser.setName(tokens[4]);

        if(verbose) System.out.println("Created new user: " + newUser.toString());
       return newUser;
    }
}
