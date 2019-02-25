package com.techyourchance.mvc.screens.questiondetails;

import android.view.View;

import com.techyourchance.mvc.networking.QuestionSchema;

interface QuestionDetailsViewMvc {

    public interface Listener {
        void onClicked();
    }

    void registerListener(QuestionDetailsViewMvcImpl.Listener listener);

    void unregisterListener(QuestionDetailsViewMvcImpl.Listener listener);

    View getRootView();

    void bindQuestions(QuestionSchema question);
}
