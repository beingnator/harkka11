package main.harkka11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Context context = MainActivity.this;
    private NoteStorage noteStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteStorage.loadList(context); // Load list if such already exists

        noteStorage = NoteStorage.getInstance();

        recyclerView = findViewById(R.id.rvNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NoteListAdapter(getApplicationContext(), NoteStorage.getNotes()));


    }

    public void addNote(View view) {
        NoteStorage.addNote( getString(R.string.standard_item_name), getString(R.string.standard_item_note)); // Set new note with standard input
        recyclerView.setAdapter(new NoteListAdapter(getApplicationContext(), NoteStorage.getNotes()));
    }

    public void sortAlphabetical(View view) {
        NoteStorage.sortAlphabetically();
        recyclerView.setAdapter(new NoteListAdapter(getApplicationContext(), NoteStorage.getNotes()));

    }

    public void sortTimeStamp(View view) {
        NoteStorage.sortByTimeStamp();
        recyclerView.setAdapter(new NoteListAdapter(getApplicationContext(), NoteStorage.getNotes()));
    }


}