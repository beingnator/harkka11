package main.harkka11;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class NoteStorage {

    private static NoteStorage noteStorage = null;
    static ArrayList<Note> notes = new ArrayList<>();

    private NoteStorage() {
    }

    public static NoteStorage getInstance() {
        if (noteStorage == null) {
            noteStorage = new NoteStorage();
        }
        return noteStorage;
    }

    public static void addNote(String itemHeadline, String itemNote){
        Note note = new Note(itemHeadline, itemNote);
        notes.add(note);
    }

    public void sortNotesAlphabetical() {
        Collections.sort(notes, Note.itemHeadlineComparator);
    }

    public void sortNotesTimeStamp() {
        Collections.sort(notes, Note.itemTimeStampComparator);
    }

    public static void saveList(Context context) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(context.openFileOutput("noteList.data", Context.MODE_PRIVATE));
            out.writeObject(notes); // This can be a data structure
            out.close();
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    public static void loadList(Context context) {
        try {
            ObjectInputStream NotesReader = new ObjectInputStream(context.openFileInput("noteList.data"));
            notes = (ArrayList<Note>) NotesReader.readObject();
            NotesReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Muistiinpanojen lukeminen ei onnistunut, tiedostoa ei löydy");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Muistiinpanojen lukeminen ei onnistunut, IO exeption");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Muistiinpanojen lukeminen ei onnistunut, ClassNotFound");
            e.printStackTrace();
        }
    }

    public static ArrayList<Note> getNotes() {
        return notes;
    }

    public static void sortAlphabetically() {
        Collections.sort(notes, Note.itemHeadlineComparator);
    }

    public static void sortByTimeStamp() {
        Collections.sort(notes, Note.itemTimeStampComparator);
    }

    public static void deleteNote(int pos) {
        notes.remove(pos);
    }

}
