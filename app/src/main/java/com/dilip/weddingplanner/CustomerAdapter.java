package com.dilip.weddingplanner;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {

    private Context context;
    private List<Customer> customers;

    public CustomerAdapter(Context context, List<Customer> customers) {
        this.context = context;
        this.customers = customers;
    }

    @Override
    public int getCount() {
        return customers.size();
    }

    @Override
    public Object getItem(int position) {
        return customers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        Customer customer = customers.get(position);

        TextView tvCustomerName = convertView.findViewById(R.id.tvCustomerName);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvPlace = convertView.findViewById(R.id.tvPlace);
        Button btnView = convertView.findViewById(R.id.btnView);

        tvCustomerName.setText(customer.getName());
        tvDate.setText(customer.getDate());
        tvPlace.setText(customer.getPlace());

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                intent.putExtra("customerName", customer.getName());
                intent.putExtra("date", customer.getDate());
                intent.putExtra("place", customer.getPlace());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}



