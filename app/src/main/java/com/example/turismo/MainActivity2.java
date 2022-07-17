package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
//import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<String> images_place;
    ArrayList<String> details_place;
    TextView place, province, description;
    Button btn_share, btn_send, btn_website, btn_location;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_share = findViewById(R.id.btn_share);
        btn_location = findViewById(R.id.btn_location);
        btn_send = findViewById(R.id.btn_send);
        btn_website = findViewById(R.id.btn_website);

        images_place = new ArrayList<String>();
        images_place = getIntent().getStringArrayListExtra("images_place");

        details_place = new ArrayList<String>();
        details_place = getIntent().getStringArrayListExtra("details_place");

        ImageCarousel carousel = findViewById(R.id.carousel);
        carousel.registerLifecycle(getLifecycle());
        List<CarouselItem> listCarousel = new ArrayList<>();


        try{
            place = findViewById(R.id.place_name);
            province = findViewById(R.id.province);
            description = findViewById(R.id.description);

            place.setText(details_place.get(0));
            province.setText(details_place.get(1));
            description.setText(details_place.get(2));
        }catch (Exception e){
            Toast.makeText(MainActivity2.this, "Error a setear details_place", Toast.LENGTH_SHORT).show();
        }


// Image drawable with caption

        listCarousel.add(
                new CarouselItem(
                        Integer.parseInt(images_place.get(0))
                )
        );

        listCarousel.add(
                new CarouselItem(
                        Integer.parseInt(images_place.get(1))
                )
        );

        listCarousel.add(
                new CarouselItem(
                        Integer.parseInt(images_place.get(2))
                )
        );

        carousel.setData(listCarousel);


        btn_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.share_link));
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");

                try {
                    startActivity(intent);

                } catch (Exception e) {
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse(getResources().getString(R.string.share_whatsapp)));
                    startActivity(intent1);
                }
            }
        });

        btn_location.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("google.navigation:q="+details_place.get(3)));
                startActivity(intent);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + String.valueOf(details_place.get(4))));
                startActivity(intent);

                /*if(!TextUtils.isEmpty(details_place.get(4))) {
                    String dial = "tel:" + details_place.get(4);
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(MainActivity2.this, "Ingresa un número celular", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        btn_website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(details_place.get(5)));
                startActivity(intent);
            }
        });

    }
}