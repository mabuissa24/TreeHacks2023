//copy daily over
//delete button fucntion
//put button function into main
package com.example.HAY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Dictionary;


public class DisplayRelaxation extends AppCompatActivity {

    //
//    ArrayList<ListItem> items;
    Dictionary<String, String[]> activities;

    //
//    ListAdapter adapter;
//
//    ListView todolist;
//
//    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public void displayRelax(View view) {
        System.out.println("In Relax");
        System.exit(0);
        Intent intent = new Intent(getApplicationContext(), DisplayRelaxation.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relaxation); // TODO: Change
//        String[] cats = Activities.getCategories();
//        String cat = cats[(int) (Math.random() * cats.length)];
//        String[] IDs = Activities.getIDs("Relaxation");
//        TextView relax = findViewById(R.id.relax1);

//        String ID = IDs[(int) (Math.random() * IDs.length)];
//        System.out.println(ID);
//        String[] randAct = Activities.getActivity(cat, ID);
//        if (randAct == null) {
//            System.err.println("Failed to find activity");
//            System.exit(1);
//        }
//        TextView one = findViewById(R.id.PromptAText1);
//        one.setText(randAct[0]);
//        Button link = findViewById(R.id.PromptALink);
//        link.setText(randAct[1]);
//        TextView two = findViewById(R.id.PromptAText2);
//        two.setText(randAct[2]);
    }
}