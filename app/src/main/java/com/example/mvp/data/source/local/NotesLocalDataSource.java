package com.example.mvp.data.source.local;

import android.content.Context;

import com.example.mvp.data.Note;
import com.example.mvp.data.source.NotesDataSource;

public class NotesLocalDataSource implements NotesDataSource {

    NotesDao mNoteDao; //4a

    public NotesLocalDataSource(Context mContext) {

        mNoteDao = new NotesDao(mContext); //4b
        mNoteDao.openDb();
    }

    @Override
    public void putNote(Note note) {
        mNoteDao.putNote(note);
    }

    @Override
    public void getNote(GetNoteCallback callback) { //4
        mNoteDao.readRow(callback); //4c
    }
}
