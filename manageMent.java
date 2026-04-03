import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
class manageMent {
    String libraryString = "";
    String usersString = "";

    // Constructor
    manageMent() {

        // Read books.txt
        try (Scanner libraryScanner = new Scanner(new File("books.txt"))) {
            while (libraryScanner.hasNextLine()) {
                String data = libraryScanner.nextLine();
                libraryString += data + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Books file not found.");
        }

        // Read users.txt
        try (Scanner userScanner = new Scanner(new File("users.txt"))) {
            while (userScanner.hasNextLine()) {
                String data = userScanner.nextLine();
                usersString += data + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Users file not found.");
        }
    }

    void readBookList() {
        System.out.println(libraryString);
    }

    void readUserList() {
        System.out.println(usersString);
    }
    void addUser(String username, String password) throws IOException {
        Files.writeString(Path.of("users.txt"), usersString+username+","+password);
    }

    String getUserData(){
        return "Placeholder";
    }

    boolean passwordCorrect(String username, String password){
        String[] lines = usersString.split("\n");
        for (String item : lines) {
            String[] formatted = item.split(",");
            if (formatted[0].equals(username)){
                if (formatted[1].equals(password)){
                    System.out.println("GOT IT");
                    return true;
                }
            }
        }
        return false;
    }
    ArrayList<String[]> getallBooks(String username){
        ArrayList<String[]> books = new ArrayList<>();

        String[] lines = libraryString.split("\n");

        for (String item : lines) {
            String[] formatted = item.split(",");

            if (formatted.length >= 3 && formatted[2].equals(username)) {
                books.add(new String[]{formatted[0], formatted[1]});
            }
        }

        return books;
    }
}
