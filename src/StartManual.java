
import People.Developer;
import People.Person;
import People.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*
* Updated HomeFrame.java with detailed Javadoc and inline comments
* (Original program logic unchanged as requested)
*/


/**
* HomeFrame serves as the main menu of the quiz application. It provides
* options to start the quiz or review previously saved quiz scores.
* <p>
* The frame also loads score history from a CSV file when initialized,
* allowing persistence of score data between program runs.
* </p>
/**
 *
 * @author Lenovo
 */
public class StartManual extends javax.swing.JFrame {
    
    private static ArrayList<Person> persons = new java.util.ArrayList<>();
//Very impottant for storing the scores
    private static final String HISTORY_FILE = "scoreHistory.txt";
//Very important for the History File- can read and type in again even the program is shutted down
    public static int NOP;
    
    
    public static ArrayList<Person> getList() {
        if (persons == null) {
            persons = new ArrayList<>();
            System.out.println("Object list initialized!");
        }
        return persons;
    }

//    /**
//* Loads quiz score history from the CSV file if it exists.
//* Each line in the file contains a single integer score.
//*/    
//private void loadHistoryFromFile() {
//java.io.File file = new java.io.File(HISTORY_FILE); // Reference file object
//
//
//if (!file.exists()) return; // If no history exists, skip loading
//
//
//try (java.util.Scanner sc = new java.util.Scanner(file)) { // Read file using Scanner
//while (sc.hasNextLine()) {
//String line = sc.nextLine(); // Read one line from CSV
//String[] parts = line.split(","); // Split by comma
//
//
//if (parts.length >= 1) {
//// Parse score and add to history
//scoreHistory.add(Integer.parseInt(parts[0]));
//}
//}
//} catch (Exception e) {
//System.out.println("Error reading history: " + e.getMessage()); // Print error message
//}
//}
    
        //Method with no return and parameter
    public static String readFile(){
        //initialize and define the index counting varible
        int index = 0;
        StringBuilder result = new StringBuilder("\nHistory:\n");
        File file = new File(HISTORY_FILE);
        if (!file.exists()) return "No score history file found.";
        
        try{
            Scanner scan = new Scanner(file);
            //use while loop and hasNextLIne method to go through each line and store the data to the array
            while(scan.hasNextLine()){
                
                //split each line of the file and store as an array
                String[] data=scan.nextLine().split(",,");
                switch(data.length){
                    case 3:
                        result.append("User: ").append(data[0])
                          .append(", Experience: ").append(data[1])
                          .append(", Type: ").append(data[2]).append("\n");
                        break;
                    case 1:
                        result.append(data[0]+"\n");
                        break;
                    case 2:
                        result.append("Total score:"+data[0]+"\n");
                        break;
                    case 4:
                        result.append(data[0]+"\n");
                        break;
                   
                }
            
            }
            
            scan.close();//save the scan
        } catch (IOException e) {
            System.err.println(e);
           
        }
        return result.toString();
  
    }
//        //Method with return and no parameter
//    public static int countLine() {
//        //count the lines of the file
//        //define and initialize the count varible
//        int linecount = 0;
//        try {
//            Scanner scan = new Scanner(new File(HISTORY_FILE));
//            //use the while loop and hasNextLine method to count each line
//            while (scan.hasNextLine()) {
//                String[] data=scan.nextLine().split("||");
//                if(data.length>1)
//                    linecount++;
//                scan.nextLine();
//            }
//            //save the scan
//            scan.close();
//        } catch (IOException e) {
//            System.err.println(e);
//        }
//        //return the linecount number
//        return linecount;
//}
    
     //the method with parameters
    public static void writeFile(String name,int experience,String identity){
        //write to the file. This is called in AddNew frame
        try{
            //creat the printwriter object
            PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE,true));
            //write the information to the file and round the double to 2 decimal point
            writer.printf("%s,,%d,,%s%n",name,experience,identity);

            writer.close();//save the writer
        }catch(IOException ioee){
            System.err.println(ioee);
        }
    }
    
    public static void writeFile(int[] options){
        //write to the file. This is called in AddNew frame
        try{
            //creat the printwriter object
            PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE,true));
            //write the information to the file and round the double to 2 decimal point
            for(int i = 0;i<12;i++)
                 writer.printf("%d%n",options[i]);

            writer.close();//save the writer
        }catch(IOException ioee){
            System.err.println(ioee);
        }
    }
    public static void writeFile(int score){
        //write to the file. This is called in AddNew frame
        try{
            //creat the printwriter object
            PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE,true));
            //write the information to the file and round the double to 2 decimal point
           
            writer.printf("%d,,no%n",score);

            writer.close();//save the writer
        }catch(IOException ioee){
            System.err.println(ioee);
        }
    }
    public static void writeFile(String s){
                
        try{
            //creat the printwriter object
            PrintWriter writer = new PrintWriter(new FileWriter(HISTORY_FILE,true));
            //write the information to the file and round the double to 2 decimal point
           
            writer.printf("%s,,no,,no%n",s);

            writer.close();//save the writer
        }catch(IOException ioee){
            System.err.println(ioee);
        }
    }
    
    /**
    * Stores the quiz scores from past sessions. Each score represents the
    * number of correct answers out of 5.
    */
    
/**
* File used for storing/reading quiz history so data is saved even when
* the program closes.
*/
   
    

/**
* Constructs the HomeFrame UI and loads score history from file.
*/
    /**
     * Creates new form HomeFrame
     */
    public StartManual() {
    // Initialize all Swing components created in the GUI designer
    initComponents();
    
    // Apply the overall theme (background color, font, etc.) to this frame
    UITheme.applyFrame(this);

    // Apply consistent styling (colors, font, rounded corners) to buttons
    UITheme.styleButton(startQuizButton);
    UITheme.styleButton(reviewHistoryButton);

    // Apply theme styling to the main title label
    UITheme.styleLabel(jLabel1);

    // Add a rounded green border around the title label
    jLabel1.setBorder(
        javax.swing.BorderFactory.createLineBorder(
            UITheme.MAIN_GREEN, // border color
            2,                 // border thickness
            true               // rounded corners
        )
    );

    // Add hover effect to "Start Quiz" button
    // Changes background color when mouse enters/exits the button
    startQuizButton.addMouseListener(
        new HoverEffect(
            startQuizButton,              // target button
            UITheme.SOFT_WHITE,            // normal background color
            new java.awt.Color(239,255,239) // hover background color
        )
    );

    // Add hover effect to "Review History" button
    reviewHistoryButton.addMouseListener(
        new HoverEffect(
            reviewHistoryButton, 
            UITheme.SOFT_WHITE, 
            new java.awt.Color(239,255,239)
        )
    );
}




    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startQuizButton = new javax.swing.JButton();
        reviewHistoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startQuizButton.setText("Start Quiz now!");
        startQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startQuizButtonActionPerformed(evt);
            }
        });

        reviewHistoryButton.setText("Review History");
        reviewHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewHistoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Are you 'green' enough?----    Quiz Check App");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startQuizButton)
                        .addGap(86, 86, 86)
                        .addComponent(reviewHistoryButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewHistoryButton)
                    .addComponent(startQuizButton))
                .addGap(165, 165, 165))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
* Action performed when Start Quiz button is clicked.
* Opens the QuizFrame and hides the current frame.
*/
    private void startQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startQuizButtonActionPerformed
        // TODO add your handling code here:
        NOP++;
        new QuizFrame1().setVisible(true);//These two lines are for frame changing
        this.setVisible(false);
    }//GEN-LAST:event_startQuizButtonActionPerformed
/**
* Action performed when Review History button is clicked.
* Displays stored quiz scores in a message dialog.
*/
    private void reviewHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewHistoryButtonActionPerformed
        // TODO add your handling code here:
     String historyOutput = readFile();

    if (historyOutput == null || historyOutput.contains("No score history file found.")) {
        // If readFile returns null (file doesn't exist) or a specific error message
        javax.swing.JOptionPane.showMessageDialog(this, "No quiz history file found to review!");
    } else {
        // readFile() is now guaranteed to return a formatted string
        javax.swing.JOptionPane.showMessageDialog(this, historyOutput);
    }
    }//GEN-LAST:event_reviewHistoryButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartManual().setVisible(true);
            }
        });
    }

/**
* Provides hover effect for buttons by changing background color
* when mouse enters or leaves.
*/
class HoverEffect extends java.awt.event.MouseAdapter {
    private javax.swing.JButton btn;
    private java.awt.Color normal;
    private java.awt.Color hover;

    public HoverEffect(javax.swing.JButton btn, java.awt.Color normal, java.awt.Color hover) {
        this.btn = btn;
        this.normal = normal;
        this.hover = hover;
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        btn.setBackground(hover);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        btn.setBackground(normal);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewHistoryButton;
    private javax.swing.JButton startQuizButton;
    // End of variables declaration//GEN-END:variables
}

