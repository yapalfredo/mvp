package com.example.mvp.data.source.local;

import com.example.mvp.data.source.local.NoteContract.NoteEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mvp.data.Note;
import com.example.mvp.data.source.NotesDataSource;

public class NotesDao {
    public void readRow(NotesDataSource.GetNoteCallback callback) { //5
        //query the database and return a note
        /*Note mNote = new Note("My Title", "My Subtitle");
        callback.onNoteLoaded(mNote); //6*/
        Cursor cursor =
                //database.rawQuery("select * from notes",null);
                database.query(NoteEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToLast();//move to the last row of the queried result
        int titleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);
        callback.onNoteLoaded(new Note(title,subtitle));
    }


    DBHelper dbHelper;
    SQLiteDatabase database;

    public NotesDao(Context context) {

        dbHelper = new DBHelper(context);
    }


    public void openDb() {
        database = dbHelper.getWritableDatabase();
    }

    public void closeDb() {
        database.close();
    }

    public void createRow(String mtitle, String msubtitle) {
        ContentValues values = new ContentValues();
        values.put(NoteEntry.COLUMN_NAME_TITLE, mtitle);
        values.put(NoteEntry.COLUMN_NAME_SUBTITLE, msubtitle);
        database.insert(NoteEntry.TABLE_NAME, null, values);

    }

    public Note readRow() {
        Cursor cursor =
                //database.rawQuery("select * from notes",null);
                database.query(NoteEntry.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToLast();//move to the last row of the queried result
        int titleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);

        return new Note(title, subtitle);
        //return title+"\n"+subtitle;
    }


    public void getTodoNote(NotesDataSource.GetNoteCallback callback) {
        //open the db and query for the note and return the note
        //TodoNote note = new TodoNote("mytitle","mysubtitle");
        callback.onNoteLoaded(readRow());//dd
    }

    public void putNote(Note note) {
        ContentValues values = new ContentValues();
        values.put(NoteEntry.COLUMN_NAME_TITLE, note.getTitle());
        values.put(NoteEntry.COLUMN_NAME_SUBTITLE, note.getSubtitle());
        database.insert(NoteEntry.TABLE_NAME, null, values);
    }

    /*public void getNotes(NotesDataSource.GetNotes callback) {
        //database.rawQuery("select * from notes",null);
        Cursor cursor =

                database.query(NoteEntry.TABLE_NAME, null,
                        null, null, null,
                        null, null);
        callback.onNo(cursor);

    }*/
}
