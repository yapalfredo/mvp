package com.example.mvp.main;

//3
public interface MainContract {

    /**
     * this will contain methods that presenter will invoke
     * in other words -- presenters's commands to view
     */
    interface View{
        void showToast(String pogi);
    }

    /**
     * this will contain methods that view will invoke
     * in other words -- view's commands to presenter
     */
    interface Presenter{
        void onButtonClicked();
    }

}
