package com.dilip.weddingplanner;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        TextView tvCustomerName = findViewById(R.id.tvCustomerName);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvPlace = findViewById(R.id.tvPlace);

        Intent intent = getIntent();
        String customerName = intent.getStringExtra("customerName");
        String date = intent.getStringExtra("date");
        String place = intent.getStringExtra("place");

        tvCustomerName.setText(customerName);
        tvDate.setText(date);
        tvPlace.setText(place);
    }
}
