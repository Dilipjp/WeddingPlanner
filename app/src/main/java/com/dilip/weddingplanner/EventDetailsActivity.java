package com.dilip.weddingplanner;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView tvCustomerName, tvDate, tvTime, tvPlace, tvDescription;
    private DatabaseReference mDatabase;
    private String eventId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

//        TextView tvCustomerName = findViewById(R.id.tvCustomerName);
//        TextView tvDate = findViewById(R.id.tvDate);
//        TextView tvPlace = findViewById(R.id.tvPlace);
//        TextView tvTime = findViewById(R.id.tvTime);
//        TextView tvDescription = findViewById(R.id.tvDescription);


        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvPlace = findViewById(R.id.tvPlace);
        tvDescription = findViewById(R.id.tvDescription);
        Button btnBack = findViewById(R.id.btnBack);

        mDatabase = FirebaseDatabase.getInstance().getReference("events");
        eventId = getIntent().getStringExtra("eventId");

        if(eventId != null){
            mDatabase.child(eventId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Event event = dataSnapshot.getValue(Event.class);
                    if (event != null) {
                        tvCustomerName.setText(event.getName());
                        tvDate.setText(event.getDate());
                        tvTime.setText(event.getTime());
                        tvPlace.setText(event.getPlace());
                        tvDescription.setText(event.getDescription());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle possible errors.
                }
            });
        }

//        Intent intent = getIntent();
//        String customerName = intent.getStringExtra("customerName");
//        String date = intent.getStringExtra("date");
//        String place = intent.getStringExtra("place");
//        String time = getIntent().getStringExtra("time");
//        String description = getIntent().getStringExtra("description");
//
//        tvCustomerName.setText(customerName);
//        tvDate.setText(date);
//        tvPlace.setText(place);
//        tvTime.setText(time);
//        tvDescription.setText(description);
        btnBack.setOnClickListener(v -> finish());
    }
}
