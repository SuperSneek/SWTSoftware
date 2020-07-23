package frontend.questions;

import backend.Categories;
import backend.DesignPatterns;
import backend.QuestionManager;

import javax.swing.*;
import java.awt.*;

public class PickCategory extends Task {


    private DesignPatterns pattern;

    public PickCategory(DesignPatterns pattern, QuestionManager mng) {
        super(mng);
        this.pattern = pattern;
    }

    @Override
    protected JPanel createQuestionPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(new JLabel(pattern.getName()));
        return panel;
    }

    @Override
    protected JPanel createAnswerPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setPreferredSize(new Dimension(400,300));
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Categories category: Categories.values()) {
            JButton button = new JButton(category.name);
            button.addActionListener(x -> recieveAnswer(category));
            panel.add(button);
        }
        return panel;
    }

    public void recieveAnswer(Categories category) {
        if(category == pattern.category) {
            mng.removePattern(pattern);
        }
        answer(category == pattern.category);
    }

}
