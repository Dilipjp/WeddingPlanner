package com.dilip.weddingplanner;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AdminEventAdapter extends BaseAdapter {

    private Context context;
    private List<Event> events;

    public AdminEventAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.admin_list_item, parent, false);
        }

        final Event event = events.get(position);

        TextView tvCustomerName = convertView.findViewById(R.id.tvCustomerName);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvPlace = convertView.findViewById(R.id.tvPlace);
        Button btnView = convertView.findViewById(R.id.btnView);
        Button btnEdit = convertView.findViewById(R.id.btnEdit);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);

        tvCustomerName.setText(event.getName());
        tvDate.setText(event.getDate());
        tvPlace.setText(event.getPlace());

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("eventId", event.getId());
                context.startActivity(intent);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddEditEventActivity.class);
                intent.putExtra("eventId", event.getId());
                context.startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Event")
                        .setMessage("Are you sure you want to delete this event?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("events");
                                mDatabase.child(event.getId()).removeValue();
                                Toast.makeText(context, "Event deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });



        return convertView;
    }
}



