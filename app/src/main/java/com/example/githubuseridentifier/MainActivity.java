package com.example.githubuseridentifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private String [] dataName;
    private String [] dataUsername;
    private String [] dataRepo;
    private String [] dataFollowing;
    private String [] dataFollower;
    private String [] dataCompany;
    private TypedArray dataPhoto;
    private String [] dataLocation;
    private ArrayList <User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            //getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.dark_nav)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary)); //status bar or the time bar at the top
        }

        ListView listView = findViewById(R.id.lv_listview);

        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, users.get(i).getName(), Toast.LENGTH_SHORT).show();

                // parcellable setting
                User user_bawa = new User ();
                user_bawa.setName(users.get(i).getName());
                user_bawa.setUsername(users.get(i).getUsername());
                user_bawa.setLocation(users.get(i).getLocation());
                user_bawa.setPhoto(users.get(i).getPhoto());

                user_bawa.setRepository(users.get(i).getRepository());
                user_bawa.setFollowing(users.get(i).getFollowing());
                user_bawa.setFollower(users.get(i).getFollower());
                user_bawa.setCompany("Halo"+users.get(i).getCompany());

                System.out.println("=============================COMPANY NAME===="+users.get(i).getCompany());

                Intent pdpUser = new Intent(MainActivity.this, UserDetail.class);
                pdpUser.putExtra(UserDetail.EXTRA_USER, user_bawa);
                startActivity(pdpUser);

            }
        });



    }

    private void addItem() {

        users = new ArrayList<>();

        for (int i=0; i< dataName.length; i++) {
            User user = new User();
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setLocation(dataLocation[i]);
            user.setPhoto(dataPhoto.getResourceId(i, -1));
            user.setCompany(dataCompany[i]);
            user.setFollower(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);
            user.setRepository(dataRepo[i]);
            users.add(user);
        }


        adapter.setUsers(users);


    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataPhoto = getResources().obtainTypedArray(R.array.avatar);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepo = getResources().getStringArray(R.array.repository);
        dataFollower = getResources().getStringArray(R.array.followers);
        dataFollowing = getResources().getStringArray(R.array.following);
        dataCompany = getResources().getStringArray(R.array.company);
    }
}