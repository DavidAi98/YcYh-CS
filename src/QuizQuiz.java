
import People.Developer;
import People.Person;
import People.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/*
* QuizQuiz.java with complete Javadoc and inline comments
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
public class QuizQuiz extends javax.swing.JFrame {
    private int currentQuestion = 0;

   // Stores 0=A, 1=B, 2=C
   private int[] userChoices = new int[12];

   Person person;

    
    

/** Array of quiz questions shown on screen. */
String[] questions = {
    "1. My digital identity is…",
    "2. The best thing about being online is…",
    "3. When interacting online, my biggest worry is…",
    "4. When it comes to online convenience vs. privacy, I lean toward…",
    "5. I think managing my online identity is…",
    "6. When I'm on public wi-fi…",
    "7. Uploading photos…",
    "8. I think blogs and wikis are…",
    "9. Would you ever consider dating someone you met online?",
    "10. Do you think texting is the same as talking on the phone?",
    "11. Is filesharing or downloading pirated media ok?",
    "12. Online gaming is…"
};

/** 2D array storing answer options for each question. */
String[][] choices = {
    {
        "…not something I worry about. I’m online every day and haven’t had any trouble.",
        "…definitely a big part of my life, but I monitor it carefully.",
        "…non-existent. I’m a really private person."
    },
    {
        "…social media.",
        "…the convenience of banking, shopping, and paying from my phone.",
        "…keeping up my personal brand."
    },
    {
        "…cyberbullying.",
        "…identity theft and keeping my personal information private.",
        "…computer viruses."
    },
    {
        "…keeping my search data and online profiles private.",
        "…convenience. I like sites remembering my profile.",
        "…a middle ground between convenience and privacy."
    },
    {
        "…a piece of cake. I can delete things later.",
        "…manageable, but I worry I’ve missed something.",
        "…really overwhelming."
    },
    {
        "…I avoid using public wi-fi.",
        "…I access online banking.",
        "…I use legit wi-fi and avoid sharing personal info."
    },
    {
        "…is risky because photos contain personal info.",
        "…is fun and I love sharing pictures.",
        "…is good if geotagging is turned off."
    },
    {
        "…creatures from a sci-fi movie.",
        "…cluttering the web with meaningless information.",
        "…a great way to collaborate and showcase work."
    },
    {
        "Yes, why not?",
        "Maybe, but I’d want to learn more first.",
        "Not a chance."
    },
    {
        "Sure! I text more than I call.",
        "Not really — for personal things I prefer calls.",
        "Not at all! Texting can be risky."
    },
    {
        "Yes. Everyone does it.",
        "Not really. It’s still illegal.",
        "Absolutely not. Artists need to get paid."
    },
    {
        "…for socially awkward geeks.",
        "…a gateway to online addiction.",
        "…great and intellectually challenging."
    }
        
        
};



/**
* Creates a new instance of QuizFrame and initializes UI components.
* Also applies theme styling and loads the first question.
*/    
public QuizQuiz() {
    
        initComponents();
        int personIndex = StartManual.NOP - 1;
        java.util.List<Person> personList = StartManual.getList();

        if (personList != null && personIndex >= 0 && personList.size() > personIndex) {
            person = personList.get(personIndex);
        } else {
        // Handle the error gracefully if no user is found
            person = null; 
            JOptionPane.showMessageDialog(this, 
            "Error: Could not load user profile. Please restart or create a new user.", 
            "Fatal Error", 
            JOptionPane.ERROR_MESSAGE);
        // Disable UI elements to prevent further interaction
        confirmButton.setEnabled(false);
        answerTextField.setEnabled(false);
    }
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
private void storeChoicesToPerson(Person person,int[] options){
    
    if(person instanceof Developer developer){
        
        developer.getScores().setOptions(options);
        
        StartManual.writeFile(developer.getScores().getScore());
        
    }else if(person instanceof User user){
        
        user.getScores().setOptions(options);
        
        StartManual.writeFile(user.getScores().getScore());
    }
}
/**
* Displays the current question and its answer choices on screen.
* Resets input field and clears result label.
*/
private void displayQuestion() {
    questionLabel.setText(questions[currentQuestion]);
    optionALabel.setText("A. " + choices[currentQuestion][0]);
    optionBLabel.setText("B. " + choices[currentQuestion][1]);
    optionCLabel.setText("C. " + choices[currentQuestion][2]);
    answerTextField.setText("");
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
        returnHomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        returnHomeButton.setText("Feedback");
        returnHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnHomeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Your Answer？ （A, B, or C)");

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(returnHomeButton)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(answerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton)
                        .addContainerGap(433, Short.MAX_VALUE))))
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
                .addGap(139, 139, 139)
                .addComponent(returnHomeButton)
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


    String input = answerTextField.getText().trim().toUpperCase();

    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter A, B, or C.");
        return;
    }

    char answer = input.charAt(0);

    if (answer < 'A' || answer > 'C') {
        JOptionPane.showMessageDialog(this, "Only A, B, or C is allowed.");
        return;
    }

    // Save answer
    userChoices[currentQuestion] = answer - 'A';
    

    currentQuestion++;

    if (currentQuestion < questions.length) {
        displayQuestion();
    }else{
        // All questions answered (currentQuestion is 12)
        // 1. Inform user
        JOptionPane.showMessageDialog(this, "Quiz finished! Click the 'Feedback' button to see your results and save.");
        
        // 2. Disable the confirmation UI
        confirmButton.setEnabled(false);
        answerTextField.setEnabled(false);
        
        // 3. Highlight the next action (Feedback button) if needed
        returnHomeButton.requestFocusInWindow();
    }


    }//GEN-LAST:event_confirmButtonActionPerformed
/**
* Returns to the HomeFrame window and hides the current quiz frame.
*
* @param evt Button click event
*/
    private void returnHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnHomeButtonActionPerformed
        // TODO add your handling code here:
 
        if (currentQuestion < questions.length) {
            JOptionPane.showMessageDialog(this,"Please answer all the questions");

            return; // Stops the method here, preventing the Feedback frame from opening
        }
        StartManual.writeFile(userChoices);
        storeChoicesToPerson(person,userChoices);  
        returnHomeButton.setEnabled(false);
 
        new Feedback(userChoices).setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_returnHomeButtonActionPerformed

/**
* Saves the user's score to a CSV file named "quiz_history.csv".
* Each entry includes the score, date, and time.
*
* @param score Score achieved in the quiz
*/




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
            java.util.logging.Logger.getLogger(QuizQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizQuiz().setVisible(true);
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
    private javax.swing.JLabel optionALabel;
    private javax.swing.JLabel optionBLabel;
    private javax.swing.JLabel optionCLabel;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JButton returnHomeButton;
    // End of variables declaration//GEN-END:variables
}
