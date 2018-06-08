package com.ptp.phamtanphat.youtubeapi1903;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String API_KEY = "AIzaSyDRnAsb1dRo960Us8AzLkKG-g14XRYbeHY";
    YouTubePlayerView youTubePlayerView;
    int Request_Code_Youtube = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youTubePlayerView = findViewById(R.id.youtubeplayerview);

        //String s =  API_KEY
        youTubePlayerView.initialize(API_KEY,this );
    }
    //cach 1
//    public YouTubePlayer.OnInitializedListener onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//        @Override
//        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
////                youTubePlayer.cueVideo();
//            youTubePlayer.loadVideo("4KJl71NE0zI");
//        }
//
//        @Override
//        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//            if (youTubeInitializationResult.isUserRecoverableError()) {
//                youTubeInitializationResult.getErrorDialog(MainActivity.this, Request_Code_Youtube);
//            }
//        }
//    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Request_Code_Youtube){
            youTubePlayerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo("4KJl71NE0zI");
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    if(youTubeInitializationResult.isUserRecoverableError()){
                        youTubeInitializationResult.getErrorDialog(MainActivity.this,Request_Code_Youtube);
                    }
                }
            });
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("4KJl71NE0zI");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(MainActivity.this, Request_Code_Youtube);
        }
    }
}
