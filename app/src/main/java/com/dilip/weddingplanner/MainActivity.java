package com.dilip.weddingplanner;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", "2024-07-15", "Old Montreal"));
        customers.add(new Customer("Jane Smith", "2024-08-20", "Mount Royal"));
        customers.add(new Customer("Alex Johnson", "2024-09-10", "La Ronde"));
        customers.add(new Customer("Michael Brown", "2024-10-05", "Montreal Botanical Garden"));
        customers.add(new Customer("Emily Davis", "2024-11-25", "Saint Joseph's Oratory"));
        customers.add(new Customer("David Wilson", "2024-12-12", "Biodome"));
        customers.add(new Customer("Linda Martinez", "2024-06-30", "Olympic Stadium"));
        customers.add(new Customer("James Taylor", "2024-05-20", "Montreal Museum of Fine Arts"));
        customers.add(new Customer("Sarah Anderson", "2024-04-15", "Notre-Dame Basilica"));
        customers.add(new Customer("Robert Lee", "2024-03-10", "Jean-Talon Market"));


        CustomerAdapter adapter = new CustomerAdapter(this, customers);
        listView.setAdapter(adapter);
    }
}
