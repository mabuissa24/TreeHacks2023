package com.example.personaltodolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<ListItem> items;

    ListAdapter adapter;

    ListView todolist;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                gatherdata(); // your code
                pullToRefresh.setRefreshing(false);
            }
        });

        todolist = (ListView) findViewById(R.id.toDoList);

        gatherdata();


    }

    private void gatherdata() {
        items = new ArrayList<ListItem>();

        DatabaseReference eventref = FirebaseDatabase.getInstance().getReference().child("myList");

        eventref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    items.add(new ListItem(snapshot.child("text").getValue().toString(),
                            Boolean.parseBoolean(snapshot.child("isCheck").getValue().toString()),
                            snapshot.getKey()));
                }

                //set adapter
                adapter = new ListItemAdapter(MainActivity.this, R.layout.list_row, items);
                todolist.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

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