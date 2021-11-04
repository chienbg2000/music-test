package com.example.baikiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseMusicActivity extends AppCompatActivity {

    private ListView listViewMusic;
    private TextView textView_chooseMusic;
    private ArrayList<Music> musics;
    private Button btn_choseMusic;
    private Music chooseMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_music);

        listViewMusic = findViewById(R.id.listMusic);
        textView_chooseMusic = findViewById(R.id.textView_chooseMusic);
        btn_choseMusic = findViewById(R.id.btn_choseMusic);
        musics = new ArrayList<Music>();
        musics.add(new Music("Bài 1","The Night",R.raw.the_night));
        musics.add(new Music("Bài 2","How to save a life",R.raw.howtosavealife));
        musics.add(new Music("Bài 3","Bất bình thường",R.raw.batbinhthuong));
        musics.add(new Music("Bài 4","Cưới thôi",R.raw.cuoithoi));
        musics.add(new Music("Bài 5","Hoa nở không mau",R.raw.hoanokhongmau));
        musics.add(new Music("Bài 6","Thở",R.raw.tho));


        final ArrayList<String> classes = new ArrayList<>();

        for (Music ms : musics ){
            classes.add(ms.getName());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, classes);

        listViewMusic.setAdapter(adapter);

        //set click functionality for each list item
        listViewMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("User clicked ", classes.get(position));
                chooseMusic = musics.get(position);
                textView_chooseMusic.setText(chooseMusic.getId()+":"+chooseMusic.getName());
            }
        });

        btn_choseMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chooseMusic == null){
                    Toast.makeText(ChooseMusicActivity.this,"Bạn chưa chọn bài hát",Toast.LENGTH_SHORT).show();
                    return;
                }
                Session.playMusic = chooseMusic;
                finish();
            }
        });

    }
}