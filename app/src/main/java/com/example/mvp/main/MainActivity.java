      package com.example.mvp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvp.R;

      /**
       * MainAcitivity is a view in mvp
       */


      //1
public class MainActivity extends AppCompatActivity implements MainContract.View { //4

    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this); //6
    }

    public void clickListener(View view){
        //view: hey my presenter somebody clicked on me
        presenter.onButtonClicked();//7
    }

          @Override
          public void showToast(String pogi) {
              Toast.makeText(this, pogi, Toast.LENGTH_SHORT).show();
          }
      }
