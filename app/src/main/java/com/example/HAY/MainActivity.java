package com.example.HAY;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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


public class MainActivity extends AppCompatActivity {

    ArrayList<ListItem> items;

    ListAdapter adapter;

    ListView todolist;

    public void displayRelax(View view) {
        System.out.println("In Relax");
        System.exit(0);
        Intent intent = new Intent(getApplicationContext(), DisplayRelaxation.class);
        startActivity(intent);
    }
    public void displayAware(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayAwareness.class);
        startActivity(intent);
    }
    public void displayCBT(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayCBT.class);
        startActivity(intent);
    }
    public void displayPhys(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplayPhysical.class);
        startActivity(intent);
    }
    public void displaySocial(View view) {
        Intent intent = new Intent(getApplicationContext(), DisplaySocial.class);
        startActivity(intent);
    }

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.relaxButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayRelaxation.class);
                startActivity(intent);
            }
                              }
        );

        findViewById(R.id.physicalButton).setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      Intent intent = new Intent(getApplicationContext(), DisplayPhysical.class);
                                      startActivity(intent);
                                  }
                              }
        );
        findViewById(R.id.awareButton).setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      Intent intent = new Intent(getApplicationContext(), DisplayAwareness.class);
                                      startActivity(intent);
                                  }
                              }
        );

        findViewById(R.id.cbtButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayCBT.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.socialButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplaySocial.class);
                startActivity(intent);
            }
        });



    }

    private void gatherdata() {
        items = new ArrayList<ListItem>();

        DatabaseReference eventref = FirebaseDatabase.getInstance().getReference().child("myList");

        eventref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    if (snapshot.child("text").getValue() != null) {
                        items.add(new ListItem(snapshot.child("text").getValue().toString(),
                                Boolean.parseBoolean(snapshot.child("isCheck").getValue().toString()),
                                snapshot.getKey()));
                    }
                    else{
                        snapshot.getRef().removeValue();
                    }
                }

                //set adapter
                adapter = new ListItemAdapter(MainActivity.this, R.layout.list_row, items);
                todolist.setAdapter(adapter); // These lines of code make the to do items display
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void notification(){
        NotificationManager NM;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


            Notification notify = new Notification(android.R.mipmap.sym_def_app_icon, "HAY", System.currentTimeMillis());
            PendingIntent pending = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(), 0);
//            notify.setLatestEventInfo(getApplicationContext(), subject, body, pending);
            NM.notify(0, notify);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "CHANNEL1")
//                .setSmallIcon(R.drawable.notification_icon)
                .setContentTitle("HAY")
                .setContentText("How are you? Take a moment to check in.")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("How are you? Take a moment to check in."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


//        Intent intent = new Intent(this, AlertDetails.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
////                .setSmallIcon(R.drawable.notification_icon)
//                .setContentTitle("My notification")
//                .setContentText("Hello World!")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                // Set the intent that will fire when the user taps the notification
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true);
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
//
//// notificationId is a unique int for each notification that you must define
//        notificationManager.notify(notificationId, builder.build());


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