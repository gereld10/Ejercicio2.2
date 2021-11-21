package com.example.comsumirapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<Post> {

    private  Context context;
    private List<Post> post1;

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<Post> post1) {
        super(context, resource, post1);
        this.context = context;
        this.post1 = post1;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.activity_list_item,parent,false);

        TextView txtid =(TextView) row.findViewById(R.id.txtListID);
        TextView txtNom =(TextView) row.findViewById(R.id.txtListname);
        TextView txtusername =(TextView) row.findViewById(R.id.txtListusername);
        TextView txtemail =(TextView) row.findViewById(R.id.txtListEmail);

        txtid.setText("ID: " + post1.get(position).getId());
        txtNom.setText("user: " + post1.get(position).getName());
        txtusername.setText("UserName: " + post1.get(position).getUsername());
        txtemail.setText("Email: " + post1.get(position).getEmail());



        return row;
    }
}
