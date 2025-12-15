/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UITheme {

    public static final Color BG_COLOR = new Color(224, 242, 221);
    public static final Color MAIN_GREEN = new Color(69, 132, 73);
    public static final Color SOFT_WHITE = new Color(250, 250, 245);

    public static final Font TITLE_FONT = new Font("Serif", Font.BOLD, 18);
    public static final Font BUTTON_FONT = new Font("Serif", Font.BOLD, 16);

    public static void applyFrame(JFrame frame) {
        frame.getContentPane().setBackground(BG_COLOR);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
    }

    public static void styleButton(JButton btn) {
        btn.setBackground(SOFT_WHITE);
        btn.setForeground(MAIN_GREEN);
        btn.setFont(BUTTON_FONT);
        btn.setFocusPainted(false);
    }

    public static void styleLabel(JLabel lbl) {
        lbl.setForeground(MAIN_GREEN);
        lbl.setFont(TITLE_FONT);
    }
}
