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

public class QuestionDetailsViewMVC  {

    public interface Listener {
        void onClicked();
    }

    private TextView mTvId;
    private TextView mTvTitle;
    private TextView mTvBody;

    private final View mRootView;

    private final List<Listener> mListeners = new ArrayList<>(1);

    public QuestionDetailsViewMVC(LayoutInflater layoutInflater, ViewGroup parent) {
        mRootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false);
        mTvId = findViewById(R.id.id_tv);
        mTvTitle = findViewById(R.id.title_tv);
        mTvBody = findViewById(R.id.body_tv);
    }

    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    public View getRootView() {
        return mRootView;
    }

    public void bindQuestions(QuestionSchema question) {
        mTvId.setText(question.getId());
        mTvTitle.setText(question.getTitle());
        mTvBody.setText(question.getBody());
    }
}
