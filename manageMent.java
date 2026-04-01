import java.util.Scanner;
import java.io.File; 


class manageMent{
  String libraryString = "";
  String usersString = "";
  manageMent{
    try (Scanner libraryScanner = new Scanner(new File("books.txt"));) { //
        while (fileScanner.hasNextLine()) { //
            String data = fileScanner.nextLine(); //
            fileStringy += data;
            fileStringy += "\n";
        }
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred: File not found.");
        e.printStackTrace();
    }}

  try (Scanner userScanner = new Scanner(new File("users.txt"));) { //
        while (fileScanner.hasNextLine()) { //
            String data = fileScanner.nextLine(); //
            fileStringy += data;
            fileStringy += "\n";
        }
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred: File not found.");
        e.printStackTrace();
    }}
  }

  void readBookList(){}
  
  void readUserList(){}
}
