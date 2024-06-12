package com.dilip.weddingplanner;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
        TextView tvTime = findViewById(R.id.tvTime);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String customerName = intent.getStringExtra("customerName");
        String date = intent.getStringExtra("date");
        String place = intent.getStringExtra("place");
        String time = getIntent().getStringExtra("time");
        String description = getIntent().getStringExtra("description");

        tvCustomerName.setText(customerName);
        tvDate.setText(date);
        tvPlace.setText(place);
        tvTime.setText(time);
        tvDescription.setText(description);
        btnBack.setOnClickListener(v -> finish());
    }
}
