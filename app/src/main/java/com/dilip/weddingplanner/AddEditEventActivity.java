package com.dilip.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddEditEventActivity extends AppCompatActivity {
    private EditText etName, etDate, etTime, etPlace, etDescription;
    private Button btnSave,btnBack;
    private DatabaseReference mDatabase;
    private String eventId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_event);
        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etPlace = findViewById(R.id.etPlace);
        etDescription = findViewById(R.id.etDescription);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);
        mDatabase = FirebaseDatabase.getInstance().getReference("events");

        eventId = getIntent().getStringExtra("eventId");
        if (eventId != null) {
            mDatabase.child(eventId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Event event = dataSnapshot.getValue(Event.class);
                    if (event != null) {
                        etName.setText(event.getName());
                        etDate.setText(event.getDate());
                        etTime.setText(event.getTime());
                        etPlace.setText(event.getPlace());
                        etDescription.setText(event.getDescription());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(AddEditEventActivity.this, "Failed to load event details", Toast.LENGTH_SHORT).show();

                }
            });
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEvent();
            }
        });
        btnBack.setOnClickListener(v -> finish());
    }

    public void saveEvent(){
        String name = etName.getText().toString().trim();
        String date = etDate.getText().toString().trim();
        String time = etTime.getText().toString().trim();
        String place = etPlace.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (name.isEmpty() || date.isEmpty() || time.isEmpty() || place.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        if (eventId == null) {
            // Add new event
            String id = mDatabase.push().getKey();
            Event event = new Event(name, date, time, place, description);
            mDatabase.child(id).setValue(event);
        } else {
            // Update existing event
            Event event = new Event(name, date, time, place, description);
            mDatabase.child(eventId).setValue(event);
        }

        finish();
    }

}