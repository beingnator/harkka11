package main.harkka11;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Note implements Serializable {
    private String nameOfItem;
    private String noteOfItem;
    private LocalDateTime lastEditDate;

    public Note(String itemHeadline, String itemNote) {
        this.nameOfItem = itemHeadline;
        this.noteOfItem = itemNote;
        this.lastEditDate = LocalDateTime.now();
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public String getNoteOfItem() {
        return noteOfItem;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public void setNoteOfItem(String noteOfItem) {
        this.noteOfItem = noteOfItem;
    }

    public static Comparator<Note> itemHeadlineComparator = new Comparator<Note>() {

        public int compare(Note s1, Note s2) {
            String StudentName1 = s1.getNameOfItem().toUpperCase();
            String StudentName2 = s2.getNameOfItem().toUpperCase();

            //ascending order
            return StudentName1.compareTo(StudentName2);

        }};



    public static Comparator<Note> itemTimeStampComparator = new Comparator<Note>() {

        public int compare(Note s1, Note s2) {
            LocalDateTime StudentName1 = s1.getLastEditDate();
            LocalDateTime StudentName2 = s2.getLastEditDate();

            //ascending order
            return StudentName1.compareTo(StudentName2);

        }};
}
