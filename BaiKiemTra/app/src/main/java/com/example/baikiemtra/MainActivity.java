package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button btn_choseMusic;
    TextView textView_musicName;
    TextView textView_duration;
    Button btn_play;
    Button btn_pause;
    MediaPlayer mediaPlayer;
    int length;
    int musicPlayRaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_choseMusic = findViewById(R.id.btn_choseMusic);
        textView_musicName = findViewById(R.id.textView_musicName);
        textView_duration = findViewById(R.id.textView_duration);
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
                if (Session.playMusic.getR() != musicPlayRaw){
                    if (mediaPlayer != null)
                        mediaPlayer.stop();
                    mediaPlayer =  MediaPlayer.create(MainActivity.this,Session.playMusic.getR());
                    musicPlayRaw = Session.playMusic.getR();
                    mediaPlayer.start();
                    setMusic();
                }
                else if (mediaPlayer != null){
                    mediaPlayer.seekTo(length);
                    mediaPlayer.start();
                }

            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null){
                    length = mediaPlayer.getCurrentPosition();
                    mediaPlayer.pause();
                }
            }
        });
    }
    private  void setMusic(){
        if (Session.playMusic != null){
            textView_musicName.setText(Session.playMusic.getId() + " : " + Session.playMusic.getName());
            int duration = mediaPlayer.getDuration();
            String time = String.format("%02d min, %02d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
            );

            textView_duration.setText(time);

        }
    }
}