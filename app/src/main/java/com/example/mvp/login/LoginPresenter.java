package com.example.mvp.login;

import com.example.mvp.data.Note;
import com.example.mvp.data.source.NotesDataSource;
import com.example.mvp.data.source.NotesRepository;

public class LoginPresenter implements LoginContract.Presenter, NotesDataSource.GetNoteCallback { //2c
    LoginContract.View view;
    NotesDataSource repository; //2

    public LoginPresenter(LoginActivity loginActivity) {
        view = loginActivity;
        repository = new NotesRepository(loginActivity); //2a
    }

    @Override
    public void onClick(String title, String subtitle) {

        //presenter -> hey mr view please set the text
        //view.setText(title, subtitle);
        repository.putNote(new Note(title,subtitle));
    }

    @Override
    public void getNote() {
        //hey mr repository get me the note. -- we will get the note onNoteLoaded()
        repository.getNote(this); //Step 2b
    }

    @Override
    public void onNoteLoaded(Note mNote) { //2d
        view.setText(mNote.getTitle(), mNote.getSubtitle());  //7
    }
}
