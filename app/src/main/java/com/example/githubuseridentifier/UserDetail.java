package com.example.githubuseridentifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetail extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);


        if (Build.VERSION.SDK_INT >= 21) {
            //getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.dark_nav)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary)); //status bar or the time bar at the top
        }

        CircleImageView gambar = findViewById(R.id.pdp_photo);
        TextView nama = findViewById(R.id.pdp_name);
        TextView usernama = findViewById(R.id.pdp_username);
        TextView alamat = findViewById(R.id.pdp_location);
        TextView repo = findViewById(R.id.pdp_repository);
        TextView following = findViewById(R.id.pdp_following);
        TextView follower = findViewById(R.id.pdp_follower);
        TextView company = findViewById(R.id.pdp_company);

        User users = getIntent().getParcelableExtra(UserDetail.EXTRA_USER);

        nama.setText(users.getName());
        usernama.setText(users.getUsername());
        alamat.setText(users.getLocation());
        repo.setText(users.getRepository());
        following.setText(users.getFollowing());
        follower.setText(users.getFollower());
        company.setText(users.getCompany());
        gambar.setImageResource(users.getPhoto());
    }
}