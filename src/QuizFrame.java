/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*
* QuizFrame.java with complete Javadoc and inline comments
*/


/**
* QuizFrame represents the quiz gameplay window. It displays questions,
* accepts user answers, checks correctness, updates score, and saves results
* to a CSV file. This class also handles navigation back to the HomeFrame.
*
* <p>The quiz consists of 5 sustainability-related questions, each with
* three multiple-choice answers (A, B, C). The user types their choice into
* a text field, and the program evaluates correctness.</p>
*
* <p>This class uses Swing for GUI components and a lightweight green theme
* for visual styling.</p>
/**
 *
 * @author Lenovo
 */
public class QuizFrame extends javax.swing.JFrame {
/** Index of the currently displayed question. */
int index = 0;//essential to the question display
/** Tracks the user's score across the quiz. */
int score = 0;//essential to the score calculate
/** Array of quiz questions shown on screen. */
String[] questions = {//Array for the question Label
    "1. What is sustainable development?",
    "2. Which action best reduces carbon footprint?",
    "3. Which resource is renewable?",
    "4. What is the purpose of recycling?",
    "5. Which agreement focuses on climate change?"
};
/** 2D array storing answer options for each question. */
String[][] options = {//2D-Array for the question choices
    {"A. Only take stuffs we need without harming future generations", "B. Use all resources now", "C. I don't care, moement right now is reality, future is too far for me"},
    {"A. Drive alone daily", "B. Use public transit / bike", "C. Throw waste anywhere"},
    {"A. Coal", "B. Nuclear energy", "C. Solar energy"},
    {"A. Reduce waste", "B. Increase pollution", "C. Create more landfill"},
    {"A. Kyoto Protocol", "B. NATO Treaty", "C. Geneva Convention"}
};
/** Correct answers corresponding to each question. */
char[] correctAnswers = {'A', 'B', 'C', 'A', 'A'};//the array for the correct answers

    /**
     * Creates new form QuizFrame
     */
/**
* Creates a new instance of QuizFrame and initializes UI components.
* Also applies theme styling and loads the first question.
*/    
public QuizFrame() {
        initComponents();
        displayQuestion();//not mentioned in the origin program, declared because of its not a button
    //Below is GUI, not important

        // --- 自然绿色主题样式 ---
        getContentPane().setBackground(new java.awt.Color(224, 242, 221)); // 背景浅绿

        java.awt.Color leafGreen = new java.awt.Color(69, 132, 73); // 深叶绿
        java.awt.Color softWhite = new java.awt.Color(250, 250, 245); // 柔白

        // 题目字体大一点，居中且优雅
        questionLabel.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 22));
        questionLabel.setForeground(leafGreen);

        // 选项字体统一
        optionALabel.setFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 18));
        optionBLabel.setFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 18));
        optionCLabel.setFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 18));

        optionALabel.setForeground(new java.awt.Color(60, 90, 60));
        optionBLabel.setForeground(new java.awt.Color(60, 90, 60));
        optionCLabel.setForeground(new java.awt.Color(60, 90, 60));

        // 输入框柔和圆角背景
        answerTextField.setBackground(new java.awt.Color(245, 255, 245));
        answerTextField.setForeground(leafGreen);
        answerTextField.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 18));
        answerTextField.setBorder(javax.swing.BorderFactory.createLineBorder(leafGreen, 2, true));

        // 确认按钮自然风
        confirmButton.setBackground(softWhite);
        confirmButton.setForeground(leafGreen);
        confirmButton.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 18));
        confirmButton.setFocusPainted(false);

        // 返回按钮一致风格
        returnHomeButton.setBackground(softWhite);
        returnHomeButton.setForeground(leafGreen);
        returnHomeButton.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 16));
        returnHomeButton.setFocusPainted(false);

        // 鼠标悬停效果
        confirmButton.addMouseListener(new Hover(confirmButton, softWhite, new java.awt.Color(239, 255, 239)));
        returnHomeButton.addMouseListener(new Hover(returnHomeButton, softWhite, new java.awt.Color(239, 255, 239)));

    
        
    }
/**
* Displays the current question and its answer choices on screen.
* Resets input field and clears result label.
*/
private void displayQuestion() {//Can see from the Design page, displaying questions and choices
    questionLabel.setText(questions[index]);
    optionALabel.setText(options[index][0]);
    optionBLabel.setText(options[index][1]);
    optionCLabel.setText(options[index][2]);
    answerTextField.setText("");
    resultLabel.setText("");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionLabel = new javax.swing.JLabel();
        optionALabel = new javax.swing.JLabel();
        optionBLabel = new javax.swing.JLabel();
        optionCLabel = new javax.swing.JLabel();
        answerTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        returnHomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionLabel.setText("Question label");

        optionALabel.setText("A");

        optionBLabel.setText("B");

        optionCLabel.setText("C");

        answerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerTextFieldActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        resultLabel.setText("Results");

        returnHomeButton.setText("Return Home");
        returnHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnHomeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Your Answer？ （A, B, or C)");

        jLabel2.setText("Earth is our home, she needs everyone to care about her...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(optionALabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(optionCLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(optionBLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                        .addComponent(returnHomeButton)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(answerTextField))
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(questionLabel)
                .addGap(18, 18, 18)
                .addComponent(optionALabel)
                .addGap(34, 34, 34)
                .addComponent(optionBLabel)
                .addGap(33, 33, 33)
                .addComponent(optionCLabel)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton)
                    .addComponent(jLabel1))
                .addGap(39, 39, 39)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnHomeButton)
                    .addComponent(jLabel2))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void answerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerTextFieldActionPerformed
// When the user presses Enter in the answer text field, treat it as
// if they clicked the Confirm button for convenience.
confirmButtonActionPerformed(null);
    }//GEN-LAST:event_answerTextFieldActionPerformed
/**
* Triggered when the Confirm button is clicked.
* Validates the user's input, updates the score, advances questions,
* and finalizes the quiz. Defensive checks are added to avoid
* out-of-bounds errors and to provide user feedback on invalid input.
*
* @param evt Button click event (may be null when called from Enter key)
*/
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
String text = answerTextField.getText();
if (text == null || text.trim().isEmpty()) {
// Prompt user to enter an answer instead of silently returning.
javax.swing.JOptionPane.showMessageDialog(this, "Please enter A, B, or C.");
return;
}


// Normalize input and validate (only first character matters).
char userAnswer = Character.toUpperCase(text.trim().charAt(0));
if (userAnswer != 'A' && userAnswer != 'B' && userAnswer != 'C') {
javax.swing.JOptionPane.showMessageDialog(this, "Invalid answer. Please type A, B, or C.");
return;
}


// Defensive: ensure index is within bounds before accessing arrays.
if (index < 0 || index >= correctAnswers.length) {
// This should not normally happen, but guard against misuse.
javax.swing.JOptionPane.showMessageDialog(this, "Quiz state invalid. Please return home and try again.");
return;
}


// Update score if answer is correct.
if (userAnswer == correctAnswers[index]) {
score++;
}


// Move to the next question.
index++;


if (index < questions.length) {
// Display next question normally.
displayQuestion();
} else {
// Quiz finished: show final result, save history, and disable inputs
resultLabel.setText("Score: " + score + "/5 | Correct: A B C A A");
HomeFrame.scoreHistory.add(score);
saveScoreToFile(score);


// Prevent further input to avoid IndexOutOfBounds on repeated clicks.
confirmButton.setEnabled(false);
answerTextField.setEnabled(false);


// Optionally suggest user to return or restart.
javax.swing.JOptionPane.showMessageDialog(this, "Quiz finished! Your score: " + score + "/5");
}

    }//GEN-LAST:event_confirmButtonActionPerformed
/**
* Returns to the HomeFrame window and hides the current quiz frame.
*
* @param evt Button click event
*/
    private void returnHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnHomeButtonActionPerformed
        // TODO add your handling code here:
        new HomeFrame().setVisible(true);//These two lines are for frame changing
        this.setVisible(false);
    }//GEN-LAST:event_returnHomeButtonActionPerformed

/**
* Saves the user's score to a CSV file named "quiz_history.csv".
* Each entry includes the score, date, and time.
*
* @param score Score achieved in the quiz
*/
private void saveScoreToFile(int score) {
try (java.io.FileWriter fw = new java.io.FileWriter("quiz_history.csv", true)) {
String date = java.time.LocalDate.now().toString();
String time = java.time.LocalTime.now().withSecond(0).toString();
fw.write(score + "," + date + "," + time + "");
} catch (Exception e) {
System.out.println("Error writing to history: " + e.getMessage());
}
}

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
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizFrame().setVisible(true);
            }
        });
    }

//Not important below, GUI design
class Hover extends java.awt.event.MouseAdapter {
    private javax.swing.JButton btn;
    private java.awt.Color normal;
    private java.awt.Color hover;

    public Hover(javax.swing.JButton btn, java.awt.Color normal, java.awt.Color hover) {
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
    private javax.swing.JTextField answerTextField;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel optionALabel;
    private javax.swing.JLabel optionBLabel;
    private javax.swing.JLabel optionCLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JButton returnHomeButton;
    // End of variables declaration//GEN-END:variables
}
