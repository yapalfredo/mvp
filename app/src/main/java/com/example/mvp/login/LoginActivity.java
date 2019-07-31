package com.example.mvp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{


    LoginContract.Presenter presenter;
    EditText titleEditText
            , subEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        titleEditText = findViewById(R.id.etTitle);
        subEditText = findViewById(R.id.etSubtitle);

        presenter = new LoginPresenter(this);
    }

    public void onClickLogin(View view) {

        switch (view.getId()) {
            case R.id.btnPut:
                //presenter -> somebody clicked the button

                String title = titleEditText.getText().toString();
                String subtitle = subEditText.getText().toString();
                titleEditText.setText("");
                subEditText.setText("");
                presenter.onClick(title, subtitle);
                break;

            case R.id.btnGet:
                presenter.getNote(); //Step 1;
                break;
        }


    }

    @Override
    public void setText(String title, String subtitle) {
        TextView textView = findViewById(R.id.textView);  //8
        textView.setText(title + "\t" + subtitle);
    }
}
