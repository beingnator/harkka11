package main.harkka11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    ImageView profileImage;
    EditText itemHeadline, itemNote;
    ImageView deleteButton, editButton;


    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        //profileImage = itemView.findViewById(R.id.ivProfile);
        itemHeadline = itemView.findViewById(R.id.etItemHeadline);
        itemNote = itemView.findViewById(R.id.etItemNote);
        deleteButton = itemView.findViewById(R.id.btnDelete);
        editButton = itemView.findViewById(R.id.btnEdit);
    }

    public void enableEditing(View view) {
        itemHeadline.setEnabled(true);
    }

    public void disableEditing(View view) {
        itemHeadline.setEnabled(false);
    }

}
