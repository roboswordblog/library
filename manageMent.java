import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
    void addUser(){}
    
    String getUserData(){return "Placeholder";}
}
