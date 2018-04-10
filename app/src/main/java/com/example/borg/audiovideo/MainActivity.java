package com.example.borg.audiovideo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Remember to create the raw directory in res, and add your rich media files there.


        // find video path
        String file = "android.resource://" + getPackageName() + "/raw/video";

        // find videoView in activity_main
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        // add video URI to videoView
        videoView.setVideoURI(Uri.parse(file));

        // add looping
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer)
            {
                mediaPlayer.setLooping(true);
            }
        });


        // add video controls
        videoView.setMediaController(new MediaController(this));


        videoView.start();

        /*
        // play audio
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.starwars);
        mediaPlayer.start();
*/


    }
}
