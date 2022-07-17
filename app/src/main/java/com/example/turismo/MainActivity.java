package com.example.turismo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CardView Cv1, Cv2, Cv3, Cv4, Cv5, Cv6;
    ArrayList<String> details_place = new ArrayList<String>();
    ArrayList<String> images_place = new ArrayList<String>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cv1=findViewById(R.id.id1);
        Cv2=findViewById(R.id.id2);
        Cv3=findViewById(R.id.id3);
        Cv4=findViewById(R.id.id4);
        Cv5=findViewById(R.id.id5);
        Cv6=findViewById(R.id.id6);


        Cv1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.volcan_baru_cima, R.drawable.volcan_baru_cruz, R.drawable.volcan_baru_cima2, R.array.place0);
            }
        });

        Cv2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.bio_figura, R.drawable.bio_animales, R.drawable.bio_acuario2, R.array.place1);
            }
        });

        Cv3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.cerro, R.drawable.cerro2, R.drawable.cerro3, R.array.place2);
            }
        });

        Cv4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.boquete1, R.drawable.boquete2, R.drawable.boquete3, R.array.place3);
            }
        });

        Cv5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.valle_anton1, R.drawable.anton2, R.drawable.valle_anton3, R.array.place4);
            }
        });

        Cv6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                formatIntent(R.drawable.punta_chame, R.drawable.punta_chame1, R.drawable.punta_chame2, R.array.place5);
            }
        });
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void formatIntent(Integer idImg0, Integer idImg1, Integer idImg2, int idPlace){
        try{
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);

            images_place.add(0, String.valueOf(idImg0));
            images_place.add(1, String.valueOf(idImg1));
            images_place.add(2, String.valueOf(idImg2));
            intent.putStringArrayListExtra("images_place", images_place);


            String[] details = getResources().getStringArray(idPlace);
            for(int i =0; i<details.length; i++){
                details_place.add(i, details[i]);
            }
            intent.putStringArrayListExtra("details_place", details_place);

            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(MainActivity.this, "No sirve", Toast.LENGTH_SHORT).show();
        }
    }
}