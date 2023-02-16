package com.example.personaltodolist;

import android.content.DialogInterface;
import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class ListItemAdapter extends ArrayAdapter<ListItem> {
    Context context;
    ArrayList<ListItem> itemsList = null;

    public ListItemAdapter(Context context, int resource, ArrayList<ListItem> arrayListItems) {
        super(context, resource, arrayListItems);
        this.context = context;
        this.itemsList = arrayListItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem listItem = itemsList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        }


        CheckBox cb = convertView.findViewById(R.id.itemText);
        Button edit = convertView.findViewById(R.id.editButton);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dr = mDatabase.child("myList").child(listItem.getKey());
                dr.child("isCheck").setValue(cb.isChecked());
            }
        });

        cb.setText(listItem.getText());
        cb.setChecked(listItem.isChecked);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Edit to-do");
                final EditText input = new EditText(context);
                input.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference dr = mDatabase.child("myList").child(listItem.getKey());
                        dr.child("text").setValue(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });


        return convertView;
    }
}
