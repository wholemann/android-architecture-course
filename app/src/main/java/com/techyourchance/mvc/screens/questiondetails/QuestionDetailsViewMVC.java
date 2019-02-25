package com.techyourchance.mvc.screens.questiondetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;

public class QuestionDetailsViewMVC  {

    private TextView mTvId;
    private TextView mTvTitle;
    private TextView mTvBody;

    private final View mRootView;

    public QuestionDetailsViewMVC(LayoutInflater layoutInflater, ViewGroup parent) {
        mRootView = layoutInflater.inflate(R.layout.layout_question_details, parent, false);
        mTvId = findViewById(R.id.id_tv);
        mTvTitle = findViewById(R.id.title_tv);
        mTvBody = findViewById(R.id.body_tv);
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
}
