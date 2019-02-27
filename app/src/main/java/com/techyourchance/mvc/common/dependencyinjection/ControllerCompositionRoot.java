package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.techyourchance.mvc.networking.StackoverflowApi;
import com.techyourchance.mvc.questions.FetchLastActiveQuestionsUseCase;
import com.techyourchance.mvc.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.mvc.screens.common.toastshelper.ToastsHelper;
import com.techyourchance.mvc.screens.common.screensnavigator.ScreensNavigator;
import com.techyourchance.mvc.screens.common.ViewMvcFactory;
import com.techyourchance.mvc.screens.questionslist.QuestionListController;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private StackoverflowApi getStackoverflowApi() {
        return mCompositionRoot.getStackoverflowApi();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
        return new FetchLastActiveQuestionsUseCase(getStackoverflowApi());
    }

    public QuestionListController getQuestionsListController() {
        return new QuestionListController(
                getFetchLastActiveQuestionsUseCase(),
                getScreensNavigator(), getMessagesDisplayer()
        );
    }

    private Context getContext() {
        return mActivity;
    }

    public ToastsHelper getMessagesDisplayer() {
        return new ToastsHelper(getContext());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getContext());
    }
}
