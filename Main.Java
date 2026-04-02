import javax.swing.*;
import java.awt.*;

class Main {
    static void home(){
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
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(10, 140, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(0, 122, 255));
            }
        });
        JButton signupButton = new JButton("Signup");
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusPainted(false);
        signupButton.setBorderPainted(false);
        signupButton.setContentAreaFilled(true);
        signupButton.setOpaque(true);
        signupButton.setBounds(400, 200, 100, 45);
        signupButton.setBackground(new Color(46, 204, 113));
        signupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupButton.setBackground(new Color(46, 204, 113));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupButton.setBackground(new Color(70, 220, 130));
            }
        });

        window.add(title);
        window.add(subtitle);
        window.add(loginButton);
        window.add(signupButton);

        window.getContentPane().setBackground(new Color(18, 18, 20));
        window.setVisible(true);
    }
    public static void main(String[] args) {
        home();
    }
}
