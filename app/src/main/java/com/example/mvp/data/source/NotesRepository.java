package com.example.mvp.data.source;


import android.content.Context;

import com.example.mvp.data.Note;
import com.example.mvp.data.source.local.NotesLocalDataSource;
import com.example.mvp.login.LoginActivity;

/**
 * This class decides whether to get a data from localDB or remoteDB based on connectivity.
 * We will call this as single source of truth.
 */
public class NotesRepository implements NotesDataSource{
    NotesDataSource localDataSource; //3a

    public NotesRepository(Context mContext) {
        localDataSource = new NotesLocalDataSource(mContext); //3b
    }

    @Override
    public void putNote(Note note) {
        localDataSource.putNote(note);
    }

    @Override
    public void getNote(GetNoteCallback callback) { //3
        //mr localDataSource get me the note
        localDataSource.getNote(callback); //3c
    }
}
