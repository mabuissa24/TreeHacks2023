package com.example.HAY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;



public class DailyActivity extends AppCompatActivity {

//
//    ArrayList<ListItem> items;
    Dictionary<String, String[]> activities;
//
//    ListAdapter adapter;
//
//    ListView todolist;
//
//    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//
//

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] cats = Activities.getCategories();
        String cat = cats[(int)(Math.random() * cats.length)];
        String[] IDs = Activities.getIDs(cat);
        String ID = cats[(int)(Math.random() * IDs.length)];
        String[] randActivity = Activities.getActivity(cat, ID);


    }

//
//    private void gatherdata() {
//        items = new ArrayList<ListItem>();
//
//        DatabaseReference eventref = FirebaseDatabase.getInstance().getReference().child("Activities");
//
//        eventref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                // Cleanup in case I scrooged the database
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    snapshot.getRef().removeValue();
//                }
//
//
//                DatabaseReference dr = mDatabase.child("Activities").push();
//                dr.child("text").setValue("Test text ");
//                dr.child("link").setValue("with link");
//                dr.child("text2").setValue(" and text.");
//
//
//                DatabaseReference dr2 = mDatabase.child("Activities").push();
//                dr2.child("text").setValue("Test text2 ");
//                dr2.child("link").setValue("with link");
//                dr2.child("text2").setValue(" and text.");
//
//                DataSnapshot chosenActivity = null;
//                double maxNum = 0;
//
////                ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
////                HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
////                hashMap.put("name", "Test text3 ");
////                hashMap.put("link","with link");
////                arrayList.add(hashMap);//add the hashmap into
////
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//
//                    double rand = Math.random();
//                    if (rand > maxNum){
//                        chosenActivity = snapshot;
//                        maxNum = rand;
//                    }
//                }
//
////                Activity today = new Activity(chosenActivity.child("text").getValue().toString(),
////                        chosenActivity.child("text2").getValue().toString(),
////                        chosenActivity.child("link").getValue().toString(),
////                        chosenActivity.getKey());
//
//                Activity today = new Activity("Test text0 ",
//                        "with link",
//                        " and text",
//                        "Tester"); // NOTE: Works but doesn't display anything TODO: make it display
//
//
//                //set adapter
////                String[] from={"name","link"};//string array
////                int[] to={R.id.textView,R.id.linkButton};//int array of views id's
////                SimpleAdapter adapter =new SimpleAdapter(this,arrayList,R.layout.list_view_items,from,to);//Create object and set the parameters for simpleAdapter
////                todolist.setAdapter(adapter);
//                adapter = new ExplanationAdapter(DailyEmotion.this, R.layout.list_row, today);
//                todolist.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        // TODO: Find a way to delete children
////        eventref.child("text").removeValue();
////        eventref.
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.addButton) {
//            Intent intent = new Intent(getApplicationContext(), AddItem.class);
//            startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}