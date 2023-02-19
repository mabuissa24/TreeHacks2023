package com.example.HAY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class DailyEmotion extends AppCompatActivity {

    ArrayList<Integer> faces;

    ListAdapter adapter;

    ListView buttonList;

//    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion);


//        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.pullToRefresh);
//        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                gatherdata(); // your code
//                pullToRefresh.setRefreshing(false);
//            }
//        });

//        buttonList = (ListView) findViewById(R.id.toDoList);
//
//        gatherdata();


    }

    public void dailyActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), DailyActivity.class);

//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    Intent intent = new Intent(getApplicationContext(), DailyActivity.class);
        startActivity(intent);
        // TODO: Do something in response to button click
    }

//    private void gatherdata() {
//        items = new ArrayList<ListItem>();
//
//        DatabaseReference eventref = FirebaseDatabase.getInstance().getReference().child("myList");
//
//        eventref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    if (snapshot.child("text").getValue() != null) {
//                        items.add(new ListItem(snapshot.child("text").getValue().toString(),
//                                Boolean.parseBoolean(snapshot.child("isCheck").getValue().toString()),
//                                snapshot.getKey()));
//                    }
//                    else{
//                        snapshot.getRef().removeValue();
//                    }
//                }
//
//                //set adapter
//                adapter = new ListItemAdapter(DailyEmotion.this, R.layout.list_row, items);
//                buttonList.setAdapter(adapter); // These lines of code make the to do items display
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addButton) {
            Intent intent = new Intent(getApplicationContext(), AddItem.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}