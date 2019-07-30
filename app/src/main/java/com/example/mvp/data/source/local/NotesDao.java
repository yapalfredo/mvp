package com.example.mvp.data.source.local;

import com.example.mvp.data.Note;
import com.example.mvp.data.source.NotesDataSource;

public class NotesDao {
    public void readRow(NotesDataSource.GetNoteCallback callback) { //5
        //query the database and return a note
        Note mNote = new Note("My Title", "My Subtitle");
        callback.onNoteLoaded(mNote); //6
    }
}
