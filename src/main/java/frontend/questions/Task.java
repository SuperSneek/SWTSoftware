package frontend.questions;

import backend.QuestionManager;

import javax.swing.*;

public abstract class Task {

    protected QuestionManager mng;
    private JPanel questionPanel = null;
    private JPanel answerPanel = null;

    public Task(QuestionManager mng) {
        this.mng = mng;
    }

    public JPanel getQuestionPanel() {
        if(questionPanel == null) {
            return createQuestionPanel();
        }
        return questionPanel;
    }

    protected abstract JPanel createQuestionPanel();

    protected abstract JPanel createAnswerPanel();

    public JPanel getAnswerPanel() {
        if(answerPanel == null) {
            return createAnswerPanel();
        }
        return answerPanel;
    }

    public void answer(boolean correct) {
        mng.taskAnswered(correct);
    }

}
