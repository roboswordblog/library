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
    ArrayList<String[]> findBooks(String searchedup){
        String[] stopwords = {"a", "an", "the", "and", "but", "or", "for", "nor", "on", "at",
                "with", "of", "by", "from", "to", "under", "i", "me", "my",
                "you", "your", "he", "she", "it", "they", "we", "is", "am",
                "are", "was", "were", "be", "being", "been", "do", "does", "did",
                "which", "who", "whom", "this", "that", "these", "those"};


        java.util.HashSet<String> stopSet = new java.util.HashSet<>();
        for (String word : stopwords) {
            stopSet.add(word);
        }


        String[] searchWords = searchedup.toLowerCase().split("\\W+");
        ArrayList<String> filteredSearch = new ArrayList<>();

        for (String word : searchWords) {
            if (!stopSet.contains(word)) {
                filteredSearch.add(word);
            }
        }

        ArrayList<String[]> findBooks(String searchedup){
        String[] stopwords = {"a", "an", "the", "and", "but", "or", "for", "nor", "on", "at",
                "with", "of", "by", "from", "to", "under", "i", "me", "my",
                "you", "your", "he", "she", "it", "they", "we", "is", "am",
                "are", "was", "were", "be", "being", "been", "do", "does", "did",
                "which", "who", "whom", "this", "that", "these", "those"};

        java.util.HashSet<String> stopSet = new java.util.HashSet<>();
        for (String word : stopwords) stopSet.add(word);

        String[] searchWords = searchedup.toLowerCase().split("\\W+");
        ArrayList<String> filteredSearch = new ArrayList<>();
        for (String word : searchWords) if (!stopSet.contains(word)) filteredSearch.add(word);

        ArrayList<String[]> results = new ArrayList<>();
        String[] lines = libraryString.split("\n");

        for (String item : lines) {
            String[] formatted = item.split(",");
            if (formatted.length >= 2) {
                String title = formatted[0].toLowerCase().trim();
                String author = formatted[1].toLowerCase().trim();

                boolean allMatch = true;
                for (String word : filteredSearch) {
                    // require word to appear in title
                    if (!title.contains(word)) {
                        allMatch = false;
                        break;
                    }
                }

                if (allMatch) {
                    results.add(new String[]{formatted[0], formatted[1]});
                }
            }
        }
        return results;
    }
    boolean bookOpen(String book){
        String[] lines = libraryString.split("\n");

        for (String item : lines) {
            String[] formatted = item.split(",");

            if (formatted.length >= 3 && formatted[2].equals("None") && formatted[0].equals(book)) {
                return true;
            }
        }
        return false;
    }
     void changeBookOwner(String title, String newOwner) throws IOException {
            Path path = Path.of("books.txt");

            // Read all lines
            ArrayList<String> newLines = new ArrayList<>();
            String[] lines = libraryString.split("\n");

            for (String line : lines) {
                String[] formatted = line.split(",");

                // Safety check
                if (formatted.length >= 3) {

                    // If this is the book we want
                    if (formatted[0].equals(title)) {
                        formatted[2] = newOwner; // change owner
                    }

                    // Rebuild line
                    newLines.add(formatted[0] + "," + formatted[1] + "," + formatted[2]);
                }
            }

            // Write everything back to file
            Files.write(path, newLines);

            // 🔥 Update memory so your app stays in sync
            libraryString = String.join("\n", newLines);
        }
}
