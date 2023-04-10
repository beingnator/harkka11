package main.harkka11;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteListAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private Context context;
    private ArrayList<Note> notes = NoteStorage.notes;

    public NoteListAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.itemHeadline.setText(notes.get(position).getNameOfItem());
        holder.itemNote.setText(notes.get(position).getNoteOfItem());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                NoteStorage.deleteNote(pos);
                NoteStorage.saveList(context);
                notifyItemRemoved(pos);
            }

        });

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {            // Set text fields edit 'true' of 'false' and save text

                if(!holder.itemHeadline.isEnabled()) {
                    holder.itemHeadline.setEnabled(true);
                    holder.itemNote.setEnabled(true);

                    holder.editButton.setBackgroundColor(Color.GRAY);
                }
                else {
                    holder.itemHeadline.setEnabled(false);
                    holder.itemNote.setEnabled(false);

                    int pos = holder.getAdapterPosition();

                    NoteStorage.getNotes().get(pos).setNameOfItem(holder.itemHeadline.getText().toString()); //Text fields need to be saved to NoteStorage
                    NoteStorage.getNotes().get(pos).setNoteOfItem(holder.itemNote.getText().toString()); //Text fields need to be saved to NoteStorage

                    NoteStorage.saveList(context);

                    holder.editButton.setBackgroundColor(Color.WHITE);
                }

            }
        });





    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}

