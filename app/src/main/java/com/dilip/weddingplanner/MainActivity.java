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

        List<Event> events = new ArrayList<>();
        events.add(new Event("John Doe", "2024-07-15", "18:00", "Old Montreal", "A beautiful evening wedding at the historical Old Montreal."));
        events.add(new Event("Jane Smith", "2024-08-20", "14:00", "Mount Royal", "A serene afternoon ceremony overlooking the city from Mount Royal."));
        events.add(new Event("Alex Johnson", "2024-09-10", "10:00", "La Ronde", "A fun-filled wedding at the amusement park, La Ronde."));
        events.add(new Event("Michael Brown", "2024-10-05", "17:00", "Montreal Botanical Garden", "A picturesque wedding at the Montreal Botanical Garden."));
        events.add(new Event("Emily Davis", "2024-11-25", "12:00", "Saint Joseph's Oratory", "A grand wedding at the magnificent Saint Joseph's Oratory."));
        events.add(new Event("David Wilson", "2024-12-12", "19:00", "Biodome", "A unique wedding experience at the Biodome."));
        events.add(new Event("Linda Martinez", "2024-06-30", "15:00", "Olympic Stadium", "A memorable wedding at the iconic Olympic Stadium."));
        events.add(new Event("James Taylor", "2024-05-20", "16:00", "Montreal Museum of Fine Arts", "An elegant wedding at the Montreal Museum of Fine Arts."));
        events.add(new Event("Sophia Harris", "2024-04-18", "13:00", "Parc Jean-Drapeau", "A charming wedding at Parc Jean-Drapeau."));
        events.add(new Event("Robert Lee", "2024-03-10", "11:00", "Montreal Science Centre", "An interesting wedding at the Montreal Science Centre."));


        EventAdapter adapter = new EventAdapter(this, events);
        listView.setAdapter(adapter);
    }
}
