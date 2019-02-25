package com.techyourchance.mvc.screens.questiondetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.networking.QuestionSchema;

import java.util.ArrayList;
import java.util.List;

public class QuestionDetailsViewMvcImpl implements QuestionDetailsViewMvc {

    private TextView mTvId;
    private TextView mTvTitle;
    private TextView mTvBody;

    private final View mRootView;

    private final List<Listener> mListeners = new ArrayList<>(1);

    public QuestionDetailsViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent) {
        mRootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false);
        mTvId = findViewById(R.id.id_tv);
        mTvTitle = findViewById(R.id.title_tv);
        mTvBody = findViewById(R.id.body_tv);
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public void bindQuestions(QuestionSchema question) {
        mTvId.setText(question.getId());
        mTvTitle.setText(question.getTitle());
        mTvBody.setText(question.getBody());
    }
}
