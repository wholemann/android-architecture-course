package com.techyourchance.mvc.screens.questionslist;

import android.os.Bundle;

import com.techyourchance.mvc.screens.common.controllers.BaseActivity;

public class QuestionsListActivity extends BaseActivity {

    private QuestionListController mQuestionListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionsListViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mQuestionListController = getCompositionRoot().getQuestionsListController();

        mQuestionListController.bindView(viewMvc);

        setContentView(viewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQuestionListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mQuestionListController.onStop();
    }

}
