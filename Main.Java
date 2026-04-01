import javax.swing.*;
import java.awt.*;

class Main{
    public static void main(String[] args) {
    JFrame window = new JFrame("LibApp");
    window.setDefaultClosingOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(800, 600);
    window.setLocationRelativeTo(null);
    window.setResizable(false);

    window.getContentPane().setBackground(new Color(18, 18, 20));
    window.setVisible(true);
    }
}
