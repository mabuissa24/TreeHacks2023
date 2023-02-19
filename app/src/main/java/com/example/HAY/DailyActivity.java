package com.example.HAY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Dictionary;


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
        setContentView(R.layout.activity_daily); // TODO: Change
        String[] cats = Activities.getCategories();
        String cat = cats[(int)(Math.random() * cats.length)];
        String[] IDs = Activities.getIDs(cat);
        String ID = IDs[(int)(Math.random() * IDs.length)];
        System.out.println(ID);
        String[] randAct = Activities.getActivity(cat, ID);
        if (randAct == null){
            System.err.println("Failed to find activity");
            System.exit(1);
        }
        TextView one = findViewById(R.id.PromptAText1);
        one.setText(randAct[0]);
        Button link = findViewById(R.id.PromptALink);
        link.setText(randAct[1]);
        TextView two = findViewById(R.id.PromptAText2);
        two.setText(randAct[2]);

    }

    public void exitActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    Intent intent = new Intent(getApplicationContext(), DailyActivity.class);
        startActivity(intent);
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