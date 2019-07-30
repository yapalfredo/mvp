package com.example.mvp.data.source;


import com.example.mvp.data.source.local.NotesLocalDataSource;

/**
 * This class decides whether to get a data from localDB or remoteDB based on connectivity.
 * We will call this as single source of truth.
 */
public class NotesRepository implements NotesDataSource{
    NotesDataSource localDataSource; //3a

    public NotesRepository() {
        localDataSource = new NotesLocalDataSource(); //3b
    }

    @Override
    public void getNote(GetNoteCallback callback) { //3
        //mr localDataSource get me the note
        localDataSource.getNote(callback); //3c
    }
}
