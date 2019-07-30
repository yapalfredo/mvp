package com.example.mvp.login;

public class LoginPresenter implements  LoginContract.Presenter {
    LoginContract.View view;

    public LoginPresenter(LoginActivity loginActivity) {
        view = loginActivity;
    }

    @Override
    public void onClick(String title, String subtitle) {
        //presenter -> hey mr view please set the text

        view.setText(title, subtitle);
    }
}
