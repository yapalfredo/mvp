package com.example.mvp.data.source;


import com.example.mvp.data.Note;

public interface NotesDataSource {

    interface GetNoteCallback {

        void onNoteLoaded(Note mNote);

    }

    void getNote(GetNoteCallback callback);


}
