ArrayList<String[]> findBooks(String searchedup){
        String[] stopwords = {"a", "an", "the", "and", "but", "or", "for", "nor", "on", "at",
                "with", "of", "by", "from", "to", "under", "i", "me", "my",
                "you", "your", "he", "she", "it", "they", "we", "is", "am",
                "are", "was", "were", "be", "being", "been", "do", "does", "did",
                "which", "who", "whom", "this", "that", "these", "those"};

        // Convert stopwords to HashSet (faster lookup)
        java.util.HashSet<String> stopSet = new java.util.HashSet<>();
        for (String word : stopwords) {
            stopSet.add(word);
        }

        // 🔹 Clean search input (remove stopwords)
        String[] searchWords = searchedup.toLowerCase().split("\\W+");
        ArrayList<String> filteredSearch = new ArrayList<>();

        for (String word : searchWords) {
            if (!stopSet.contains(word)) {
                filteredSearch.add(word);
            }
        }

        ArrayList<String[]> results = new ArrayList<>();
        String[] lines = libraryString.split("\n");

        // 🔹 Search through books
        for (String item : lines) {
            String[] formatted = item.split(",");

            if (formatted.length >= 2) {
                String title = formatted[0].toLowerCase();
                String author = formatted[1].toLowerCase();

                // Check if ANY filtered word matches
                for (String word : filteredSearch) {
                    if (title.contains(word) || author.contains(word)) {
                        results.add(new String[]{formatted[0], formatted[1]});
                        break; // avoid duplicates
                    }
                }
            }
        }

        return results;
    }

}
