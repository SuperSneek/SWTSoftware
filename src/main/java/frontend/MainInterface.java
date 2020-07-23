package frontend;

import backend.DesignPatterns;
import backend.QuestionManager;
import frontend.questions.Task;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainInterface {

    private JPanel questionPanel;
    private JPanel answerPanel;
    private JPanel answeredPanel;

    private JFrame frame;

    public static void main(String[] args) {
        MainInterface main = new MainInterface();
        main.init();
    }

    private void init() {
        frame = new JFrame();
        frame.setSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout());
        answerPanel = new JPanel(new BorderLayout());
        answerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(questionPanel, BorderLayout.WEST);
        contentPane.add(answerPanel, BorderLayout.EAST);
        questionPanel.add(new JLabel("Question:"), BorderLayout.NORTH);
        answerPanel.add(new JLabel("Answer:"), BorderLayout.NORTH);
        JPanel solutionPanel = new JPanel(new BorderLayout());
        solutionPanel.setBorder(new LineBorder(Color.black));
        solutionPanel.add(new JLabel("Answered Questions"), BorderLayout.NORTH);
        answeredPanel = new JPanel(new FlowLayout());
        answerPanel.setBorder(new LineBorder(Color.black));
        solutionPanel.add(answeredPanel);
        frame.add(solutionPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        new QuestionManager(this);
    }

    public void askNewQuestion(Task task) {
        processTask(task);
    }

    public void processTask(Task task) {
        answerPanel.removeAll();
        questionPanel.removeAll();
        questionPanel.add(new JLabel("Question:"), BorderLayout.NORTH);
        answerPanel.add(new JLabel("Answer:"), BorderLayout.NORTH);
        questionPanel.add(task.getQuestionPanel(), BorderLayout.CENTER);
        answerPanel.add(task.getAnswerPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    public void reset() {
        answeredPanel.removeAll();
    }

    public void newCorrectAnswer(DesignPatterns newAnswer) {
        answeredPanel.add(new JLabel(newAnswer.getName()));
    }

}
