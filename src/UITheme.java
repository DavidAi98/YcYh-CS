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

/**
 * UITheme is a utility class used to keep the application's
 * colors, fonts, and styling consistent across all frames.
 * 
 * All methods are static so no UITheme object is required.
 */
public class UITheme {

    // Background color used for frames
    public static final Color BG_COLOR = new Color(224, 242, 221);

    // Main theme color (used for text, borders, accents)
    public static final Color MAIN_GREEN = new Color(69, 132, 73);

    // Soft white color for buttons
    public static final Color SOFT_WHITE = new Color(250, 250, 245);

    // Font used for title labels
    public static final Font TITLE_FONT = new Font("Serif", Font.BOLD, 18);

    // Font used for buttons
    public static final Font BUTTON_FONT = new Font("Serif", Font.BOLD, 16);

    /**
     * Applies general styling to a JFrame
     * @param frame the JFrame to style
     */
    public static void applyFrame(JFrame frame) {
        // Set background color of the frame
        frame.getContentPane().setBackground(BG_COLOR);

        // Set fixed window size
        frame.setSize(800, 500);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
    }

    /**
     * Styles a JButton with the app's theme
     * @param btn the JButton to style
     */
    public static void styleButton(JButton btn) {
        // Set button background color
        btn.setBackground(SOFT_WHITE);

        // Set text color
        btn.setForeground(MAIN_GREEN);

        // Apply theme font
        btn.setFont(BUTTON_FONT);

        // Remove focus border when button is clicked
        btn.setFocusPainted(false);
    }

    /**
     * Styles a JLabel with the app's theme
     * @param lbl the JLabel to style
     */
    public static void styleLabel(JLabel lbl) {
        // Set label text color
        lbl.setForeground(MAIN_GREEN);

        // Apply title font
        lbl.setFont(TITLE_FONT);
    }
}

