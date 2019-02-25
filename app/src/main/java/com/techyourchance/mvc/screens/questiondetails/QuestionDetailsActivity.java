package com.techyourchance.mvc.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.techyourchance.mvc.common.Constants;
import com.techyourchance.mvc.networking.QuestionDetailsResponseSchema;
import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.screens.common.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionDetailsActivity extends BaseActivity {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    private StackoverflowApi mStackoverflowApi;
    private QuestionDetailsViewMVC mViewMVC;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMVC = new QuestionDetailsViewMVC(LayoutInflater.from(this), null);

        setContentView(mViewMVC.getRootView());

        mStackoverflowApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StackoverflowApi.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestionDetails();
    }

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }

    private void fetchQuestionDetails() {
        mStackoverflowApi.fetchQuestionDetails(getIntent().getStringExtra(EXTRA_QUESTION_ID))
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {

                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {

                    }
                });
    }

    private void bindQuestionDetails() {

    }

}
