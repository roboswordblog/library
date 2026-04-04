import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

class Main {
    static manageMent dataManage = new manageMent();
    static String user;
    static void landing(){
        JFrame window = new JFrame("LibApp");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        JLabel title = new JLabel();
        title.setText("Lib App");
        title.setFont(new Font("Serif", Font.BOLD, 75));
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(275, 30, 300, 100);
        JLabel subtitle = new JLabel();
        subtitle.setText("The best library app there is.-Someone Very Smart");
        subtitle.setFont(new Font("Serif", Font.ITALIC, 15));
        subtitle.setForeground(new Color(255, 255, 255));
        subtitle.setBounds(250, 105, 350, 100);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(275, 200, 100, 45);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(true);
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(0, 122, 255));
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                loginButton.setBackground(new Color(10, 140, 255));
            }

            public void mouseExited(MouseEvent evt) {
                loginButton.setBackground(new Color(0, 122, 255));
            }
        });
        loginButton.addActionListener(e -> {
            window.dispose(); // close current window
            login();          // open login screen
        });

        JButton signupButton = new JButton("Signup");
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(true);
        signupButton.setOpaque(true);
        signupButton.setBounds(400, 200, 100, 45);
        signupButton.setBackground(new Color(46, 204, 113));
        signupButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                signupButton.setBackground(new Color(46, 204, 113));
            }

            public void mouseExited(MouseEvent evt) {
                signupButton.setBackground(new Color(70, 220, 130));
            }
        });
        signupButton.addActionListener(e -> {
            window.dispose(); // close current window
            signup();          // open login screen
        });
        window.add(title);
        window.add(subtitle);
        window.add(loginButton);
        window.add(signupButton);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }
    static void signup(){
        JFrame window = new JFrame("LibApp Signup");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        JLabel title = new JLabel();
        title.setText("Lib App");
        title.setFont(new Font("Serif", Font.BOLD, 75));
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(275, 30, 300, 100);
        JLabel subtitle = new JLabel();
        subtitle.setText("Sign Up");
        subtitle.setFont(new Font("Serif", Font.PLAIN, 30));
        subtitle.setForeground(new Color(255, 255, 255));
        subtitle.setBounds(340, 105, 350, 100);

        JTextField username = new JTextField("Username");
        username.setSize(300, 50);
        username.setLocation(265, 225);
        username.setBackground(new Color(50, 50, 50)); // dark gray
        username.setForeground(Color.WHITE);          // white text
        username.setCaretColor(Color.WHITE);          // caret color
        username.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70))); // subtle border
        username.setFont(new Font("Consolas", Font.PLAIN, 14)); // IDE-style font

        window.add(username);
        window.getContentPane().setBackground(new Color(30, 30, 30));
        JTextField password = new JTextField("Password");
        password.setSize(300, 50);
        password.setLocation(265, 300);
        password.setBackground(new Color(50, 50, 50)); // dark gray
        password.setForeground(Color.WHITE);          // white text
        password.setCaretColor(Color.WHITE);          // caret color
        password.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70))); // subtle border
        password.setFont(new Font("Consolas", Font.PLAIN, 14)); // IDE-style font

        window.add(password);


        JButton signupButton = new JButton("Signup");
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(true);
        signupButton.setOpaque(true);
        signupButton.setBounds(350, 400, 100, 45);
        signupButton.setBackground(new Color(46, 204, 113));
        signupButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                signupButton.setBackground(new Color(46, 204, 113));
            }

            public void mouseExited(MouseEvent evt) {
                signupButton.setBackground(new Color(70, 220, 130));
            }
        });
        signupButton.addActionListener(e -> {
            window.dispose();// close current window
            try {
                dataManage.addUser(username.getText(), password.getText());
            } catch (IOException ex) {
                System.out.println("So like the file thing for adding went wrong and failed, dont blame it on the owner of the company, blame it on the devs");
            }
            user = username.getText();
            home();          // open login screen
        });
        window.add(title);
        window.add(subtitle);
        window.add(signupButton);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }
    static void login(){
        JFrame window = new JFrame("LibApp Login");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);
        JLabel title = new JLabel();
        title.setText("Lib App");
        title.setFont(new Font("Serif", Font.BOLD, 75));
        title.setForeground(new Color(255, 255, 255));
        title.setBounds(275, 30, 300, 100);
        JLabel subtitle = new JLabel();
        subtitle.setText("Login");
        subtitle.setFont(new Font("Serif", Font.PLAIN, 30));
        subtitle.setForeground(new Color(255, 255, 255));
        subtitle.setBounds(340, 105, 350, 100);

        JTextField username = new JTextField("Username");
        username.setSize(300, 50);
        username.setLocation(265, 225);
        username.setBackground(new Color(50, 50, 50)); // dark gray
        username.setForeground(Color.WHITE);          // white text
        username.setCaretColor(Color.WHITE);          // caret color
        username.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70))); // subtle border
        username.setFont(new Font("Consolas", Font.PLAIN, 14)); // IDE-style font

        window.add(username);
        window.getContentPane().setBackground(new Color(30, 30, 30));
        JTextField password = new JTextField("Password");
        password.setSize(300, 50);
        password.setLocation(265, 300);
        password.setBackground(new Color(50, 50, 50)); // dark gray
        password.setForeground(Color.WHITE);          // white text
        password.setCaretColor(Color.WHITE);          // caret color
        password.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70))); // subtle border
        password.setFont(new Font("Consolas", Font.PLAIN, 14)); // IDE-style font

        window.add(password);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(350, 400, 100, 45);

        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(true);
        loginButton.setOpaque(true);
        loginButton.setBackground(new Color(0, 122, 255));
        loginButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                loginButton.setBackground(new Color(10, 140, 255));
            }

            public void mouseExited(MouseEvent evt) {
                loginButton.setBackground(new Color(0, 122, 255));
            }
        });
        loginButton.addActionListener(e -> {
            window.dispose(); // close current window
            if (dataManage.passwordCorrect(username.getText(), password.getText())){
                user = username.getText();
                home();
            }
            else{
                login();
            }          // open login screen
        });
        window.add(title);
        window.add(subtitle);
        window.add(loginButton);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }

    static void home(){
        JFrame window = new JFrame("LibApp Home");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);

        // 🔹 Title
        JLabel title = new JLabel("Lib App");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(30, 30, 300, 100);

        // 🔹 Checked Out Label (CENTERED)
        JLabel checkedLabel = new JLabel("Checked Out", SwingConstants.CENTER);
        checkedLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        checkedLabel.setForeground(Color.WHITE);
        checkedLabel.setBounds(250, 120, 300, 50);

        // 🔥 PANEL FOR BOOKS (SCROLLABLE)
        JPanel booksPanel = new JPanel();
        booksPanel.setLayout(new BoxLayout(booksPanel, BoxLayout.Y_AXIS));
        booksPanel.setBackground(new Color(18, 18, 20));

        for (String[] item : dataManage.getallBooks(user)) {

            // 🔹 Row container (horizontal like search page)
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            row.setBackground(new Color(18, 18, 20));
            row.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // 🔹 Text panel
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(new Color(18, 18, 20));

            JLabel book = new JLabel(item[0]);
            book.setFont(new Font("Consolas", Font.BOLD, 16));
            book.setForeground(Color.WHITE);

            JLabel description = new JLabel(item[1]);
            description.setFont(new Font("Consolas", Font.PLAIN, 13));
            description.setForeground(Color.LIGHT_GRAY);

            textPanel.add(book);
            textPanel.add(description);

            // 🔥 RETURN BUTTON
            JButton returnBtn = new JButton("Return");
            returnBtn.setMaximumSize(new Dimension(120, 40));
            returnBtn.setFocusPainted(false);
            returnBtn.setBorderPainted(false);
            returnBtn.setContentAreaFilled(true);
            returnBtn.setOpaque(true);
            returnBtn.setForeground(Color.WHITE);

            // 🎨 Red styling (since it's "return")
            returnBtn.setBackground(new Color(231, 76, 60));

            // 🔥 Hover effect
            returnBtn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    returnBtn.setBackground(new Color(255, 99, 71));
                }
                public void mouseExited(MouseEvent evt) {
                    returnBtn.setBackground(new Color(231, 76, 60));
                }
            });

            // 🔥 CLICK ACTION
            returnBtn.addActionListener(e -> {
                try {
                    dataManage.changeBookOwner(item[0], "None"); // return book
                } catch (IOException ex) {
                    System.out.println("Return failed");
                }
                window.dispose();
                home(); // refresh page
            });

            // 🔹 Add everything to row
            row.add(textPanel);
            row.add(Box.createHorizontalGlue()); // pushes button right
            row.add(returnBtn);

 
            booksPanel.add(row);
            booksPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }


        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.setBounds(150, 180, 500, 300); // centered box
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(650, 50, 100, 50);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(true);
        logoutButton.setOpaque(true);
        logoutButton.setBackground(new Color(231, 76, 60));

        logoutButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                logoutButton.setBackground(new Color(255, 99, 71));
            }
            public void mouseExited(MouseEvent evt) {
                logoutButton.setBackground(new Color(231, 76, 60));
            }
        });

        logoutButton.addActionListener(e -> {
            window.dispose();
            landing();
        });

        // 🔹 Search bar
        JTextField search = new JTextField("Search");
        search.setSize(200, 50);
        search.setLocation(300, 50);
        search.setBackground(new Color(50, 50, 50));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        search.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        search.setFont(new Font("Consolas", Font.PLAIN, 14));

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(500, 50, 100, 50);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(true);
        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(10, 140, 255));

        searchButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                searchButton.setBackground(new Color(100, 130, 255));
            }
            public void mouseExited(MouseEvent evt) {
                searchButton.setBackground(new Color(10, 140, 255));
            }
        });

        searchButton.addActionListener(e -> {
            window.dispose();
            searchPage(search.getText());
        });

        // 🔹 Add everything
        window.add(title);
        window.add(checkedLabel);
        window.add(scrollPane);
        window.add(logoutButton);
        window.add(search);
        window.add(searchButton);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }
    static void searchPage(String keywords){
        JFrame window = new JFrame("LibApp Search");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setLayout(null);

        JButton title = new JButton("Lib App");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setBounds(30, 30, 300, 100);

// Make it look like plain text
        title.setContentAreaFilled(false);  // no background
        title.setBorderPainted(false);      // no border
        title.setFocusPainted(false);       // no focus outline
        title.setCursor(new Cursor(Cursor.HAND_CURSOR)); // shows hand cursor on hover

// Optional: hover effect (slightly brighter text)
        title.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                title.setForeground(new Color(200, 200, 255)); // light highlight
            }
            public void mouseExited(MouseEvent evt) {
                title.setForeground(Color.WHITE);
            }
        });

// Click action to go home
        title.addActionListener(e -> {
            window.dispose(); // close current window
            home();           // go to home page
        });
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(650, 50, 100, 50);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(true);
        logoutButton.setOpaque(true);
        logoutButton.setBackground(new Color(231, 76, 60));

        logoutButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) { logoutButton.setBackground(new Color(255, 99, 71)); }
            public void mouseExited(MouseEvent evt) { logoutButton.setBackground(new Color(231, 76, 60)); }
        });

        logoutButton.addActionListener(e -> {
            window.dispose();
            landing();
        });

        JTextField search = new JTextField("Search");
        search.setSize(200, 50);
        search.setLocation(300, 50);
        search.setBackground(new Color(50, 50, 50));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        search.setBorder(BorderFactory.createLineBorder(new Color(70, 70, 70)));
        search.setFont(new Font("Consolas", Font.PLAIN, 14));

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(500, 50, 100, 50);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(true);
        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(10, 140, 255));

        searchButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) { searchButton.setBackground(new Color(100, 130, 255)); }
            public void mouseExited(MouseEvent evt) { searchButton.setBackground(new Color(10, 140, 255)); }
        });

        searchButton.addActionListener(e -> {
            window.dispose();
            searchPage(search.getText());
        });

        // 🔥 SCROLLABLE RESULTS PANEL
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(new Color(18, 18, 20));

        for (String[] item : dataManage.findBooks(keywords)) {

            // 🔹 Row container (horizontal layout)
            JPanel row = new JPanel();
            row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
            row.setBackground(new Color(18, 18, 20));
            row.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // 🔹 Text panel (title + description)
            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
            textPanel.setBackground(new Color(18, 18, 20));

            JLabel book = new JLabel(item[0]);
            book.setFont(new Font("Consolas", Font.BOLD, 16));
            book.setForeground(Color.WHITE);

            JLabel description = new JLabel(item[1]);
            description.setFont(new Font("Consolas", Font.PLAIN, 13));
            description.setForeground(Color.LIGHT_GRAY);

            textPanel.add(book);
            textPanel.add(description);

            // 🔹 Get button
            boolean available = dataManage.bookOpen(item[0]);
            JButton get = new JButton(available ? "Get" : "Unavailable");
            get.setMaximumSize(new Dimension(120, 40)); // fixed width & height
            get.setFocusPainted(false);
            get.setBorderPainted(false);
            get.setContentAreaFilled(true);
            get.setOpaque(true);
            get.setForeground(Color.WHITE);
            get.setBackground(available ? new Color(46, 204, 113) : new Color(60, 80, 70));
            get.setEnabled(available);

            // Hover effect
            get.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) { if (available) get.setBackground(new Color(39, 174, 96)); }
                public void mouseExited(MouseEvent evt) { if (available) get.setBackground(new Color(46, 204, 113)); }
            });

            // Click action
            get.addActionListener(e -> {
                // dataManage.checkoutBook(item[0]); // implement this in manageMent
                try {
                    dataManage.changeBookOwner(item[0],user);
                } catch (IOException ex) {
                    System.out.println("FAILURE U FAILED");
                }
                window.dispose();
                searchPage(keywords);
            });

            // 🔹 Add components to row
            row.add(textPanel);
            row.add(Box.createHorizontalGlue()); // pushes button to the right
            row.add(get);

            // 🔹 Add row to results
            resultsPanel.add(row);
            resultsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing between rows
        }

        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        scrollPane.setBounds(50, 150, 700, 350);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // ADD COMPONENTS
        window.add(title);
        window.add(logoutButton);
        window.add(search);
        window.add(searchButton);
        window.add(scrollPane);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }

    public static void main(String[] args) {
        landing();
    }
}
