package com.example.githubuseridentifier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<User> users = new ArrayList<>();


    public UserAdapter (Context context) {
        this.context = context;
    }

    public void setUsers (ArrayList <User> users) {
        this.users = users;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User)getItem(position);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {

        private TextView txtName;
        private  TextView txtUsername;
        private TextView txtLocation;
        private CircleImageView imageView;



        ViewHolder (View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtUsername = view.findViewById(R.id.txt_username);
            imageView = view.findViewById(R.id.img_photo);
            txtLocation = view.findViewById(R.id.txt_location);

        }

        void bind(User user) {
            txtName.setText(user.getName());
            txtUsername.setText(user.getUsername());
            imageView.setImageResource(user.getPhoto());
            txtLocation.setText(user.getLocation());



        }
    }
}
