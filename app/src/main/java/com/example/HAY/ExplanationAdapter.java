package com.example.HAY;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExplanationAdapter extends SimpleAdapter {

    Context context;
    Activity activity;
    public ExplanationAdapter(Context context, List<? extends Map<String, ?>> data, int resource,
                              String[] from, int[] to, Activity today) {
        super(context, data, resource, from, to);

        this.context = context;
        this.activity = today;

    }


    @Override
    public int getCount() {
        return super.getCount();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        }


        Button link = convertView.findViewById(R.id.linkButton);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(activity.getText()); // TODO: Update past here
                final EditText input = new EditText(context);
                input.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference dr = mDatabase.child("myList").child(activity.getKey());
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
