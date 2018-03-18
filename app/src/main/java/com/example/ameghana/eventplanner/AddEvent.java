package com.example.ameghana.eventplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

    }

    public void submitEvent(View view){
        EditText a = (EditText)findViewById(R.id.nameOfEvent);
        String title = a.getText().toString();
        EditText b = (EditText)findViewById(R.id.venueOfEvent);
        String venue = b.getText().toString();
        EditText c = (EditText)findViewById(R.id.chiefGuest);
        String chiefguest = c.getText().toString();
        EditText d = (EditText)findViewById(R.id.date);
        String date = d.getText().toString();
        Intent intent = new Intent(AddEvent.this, NavigationDrawer.class);
        intent.putExtra("title", title);
        intent.putExtra("venue", venue);
        intent.putExtra("chiefguest", chiefguest);
        intent.putExtra("date", date);
        startActivity(intent);
    }
}
