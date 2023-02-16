package com.example.personaltodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItem extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        EditText newItemText = findViewById(R.id.newItemText);
        Button add = findViewById(R.id.addItem);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dr = mDatabase.child("myList").push();
                dr.child("text").setValue(newItemText.getText().toString());
                dr.child("isCheck").setValue(false);

                Toast.makeText(getApplicationContext(), "Added!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}