package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_choseMusic;
    TextView textView_musicName;
    Button btn_play;
    Button btn_pause;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_choseMusic = findViewById(R.id.btn_choseMusic);
        textView_musicName = findViewById(R.id.textView_musicName);
        btn_play = findViewById(R.id.btn_play);
        btn_pause = findViewById(R.id.btn_pause);


        btn_choseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("click","true");
                Intent intent = new Intent(view.getContext(), ChooseMusicActivity.class);
                view.getContext().startActivity(intent);

            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null){
                    mediaPlayer.stop();
                }
                if (Session.playMusic != null){
                    mediaPlayer =  MediaPlayer.create(MainActivity.this,Session.playMusic.getR());
                    mediaPlayer.start();
                    setMusic();
                }
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null){
                    mediaPlayer.stop();
                }
            }
        });
    }
    private  void setMusic(){
        if (Session.playMusic != null){
            textView_musicName.setText(Session.playMusic.getId() + " : " + Session.playMusic.getName());
        }
    }
}