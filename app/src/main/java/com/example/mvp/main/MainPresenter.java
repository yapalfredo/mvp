package com.example.mvp.main;

//2
public class MainPresenter implements  MainContract.Presenter {//5
    MainContract.View view; //9

    public MainPresenter(MainActivity mainActivity)
    {
        view = mainActivity;  //10 - wiring
    }


    @Override
    public void onButtonClicked() {//8
        //presenter: show a Toast
        view.showToast("Pogi"); //11
    }

}
