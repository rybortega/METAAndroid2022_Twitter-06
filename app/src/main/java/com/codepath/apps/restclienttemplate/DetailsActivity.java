package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcel;
import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    TextView userID;
    TextView tweetBody;
    ImageView profileImage;
    ImageView tweetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Tweet tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        userID = findViewById(R.id.userID);
        tweetBody = findViewById(R.id.tweetBody);
        profileImage = findViewById(R.id.profileImage);
        tweetImage = findViewById(R.id.tweetImage);

        userID.setText(tweet.user.screenName);
        tweetBody.setText(tweet.body);
        Glide.with(DetailsActivity.this).load(tweet.user.profileImageUrl).into(profileImage);
        if (tweet.hasMedia) {
            tweetImage.setVisibility(View.VISIBLE);
            Glide.with(DetailsActivity.this).load(tweet.firstEmbeddedImage).into(tweetImage);
        } else {
            tweetImage.setVisibility(View.GONE);
        }
    }
}