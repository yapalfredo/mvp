package com.example.mvp.login;

public interface LoginContract {
    
    interface View{
        void setText(String title, String subtitle);
    }
    
    interface Presenter{
        void onClick(String title, String subtitle);
    }
    
}
