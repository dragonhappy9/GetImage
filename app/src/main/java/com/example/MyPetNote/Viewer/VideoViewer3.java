package com.example.MyPetNote.Viewer;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MyPetNote.R;

public class VideoViewer3 extends AppCompatActivity {
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoviewer);

        vv= findViewById(R.id.vv);

        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/raw/cat_raser");

        vv.setMediaController(new MediaController(this));

        vv.setVideoURI(videoUri);

        vv.setOnPreparedListener(mediaPlayer -> {

            vv.start();
        });

    }
    @Override
    protected void onPause() {
        super.onPause();

        if(vv!=null && vv.isPlaying()) vv.pause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (vv != null) vv.stopPlayback();
    }
}

