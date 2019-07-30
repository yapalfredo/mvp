package com.example.mvp.data.source.local;

import com.example.mvp.data.source.NotesDataSource;

public class NotesLocalDataSource implements NotesDataSource {

    NotesDao mNoteDao; //4a

    public NotesLocalDataSource() {
        mNoteDao = new NotesDao(); //4b
    }

    @Override
    public void getNote(GetNoteCallback callback) { //4
        mNoteDao.readRow(callback); //4c
    }
}
