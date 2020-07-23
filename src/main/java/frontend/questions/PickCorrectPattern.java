package frontend.questions;

import backend.DesignPatterns;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PickCorrectPattern extends JFrame {

    public PickCorrectPattern(DesignPatterns pattern, PickCategory task) {
        setSize(new Dimension(1000, 800));
        setLayout(new FlowLayout());
        JButton button = new JButton();
        button.setIcon(pattern.image);
        button.addActionListener(x -> {
            task.patternPicked(true);
            dispose();
        });
        LinkedList<JButton> patternsToAdd = new LinkedList<>();
        patternsToAdd.add(button);
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            DesignPatterns randomPattern = DesignPatterns.values()[rand.nextInt(DesignPatterns.values().length - 1)];
            if(randomPattern == pattern) {
                continue;
            }
            JButton randButton = new JButton();
            randButton.setIcon(randomPattern.image);
            randButton.addActionListener(x -> {
                task.patternPicked(false);
                dispose();
            });
            if(rand.nextInt() == 1) {
                patternsToAdd.addFirst(randButton);
            } else {
                patternsToAdd.addLast(randButton);
            }
        }
        for(JButton b : patternsToAdd) {
            getContentPane().add(b);
        }
        setVisible(true);
    }



}
