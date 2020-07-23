package backend;

import frontend.MainInterface;
import frontend.questions.PickCategory;
import frontend.questions.Task;

import javax.swing.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuestionManager {

    List<DesignPatterns> patternsToAnswer = new LinkedList<DesignPatterns>();
    Random random = new Random();
    private MainInterface main;
    private int errors;
    private Task currentTask = null;

    public QuestionManager(MainInterface main) {
        Collections.addAll(patternsToAnswer, DesignPatterns.values());
        this.main = main;
        main.askNewQuestion(nextQuestion());
    }

    public Task nextQuestion() {
        if(patternsToAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "You did it! And with only " + errors + " wrong answers!", "Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
            Collections.addAll(patternsToAnswer, DesignPatterns.values());
            main.reset();
            errors = 0;
        }
        int index;
        if(patternsToAnswer.size() == 1) {
            index = 0;
        } else {
            index = random.nextInt(patternsToAnswer.size() - 1);
        }
        errors++;
        DesignPatterns pattern = patternsToAnswer.get(index);
        return new PickCategory(pattern, this);
    }

    public void removePattern(DesignPatterns p) {
        main.newCorrectAnswer(p);
        errors--;
        patternsToAnswer.remove(p);
    }

    public void taskAnswered(boolean correctAnswer) {
        main.askNewQuestion(nextQuestion());
    }

}
