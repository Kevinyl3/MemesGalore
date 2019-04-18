package com.example.mockproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //the arrays for the images and text strings to be displayed
        final int[] memeImages = {R.drawable.generic_space_scene_HD};
        final int[] memeCaptions = {};
        setContentView(R.layout.activity_main);
        //initializing the caption view, image view, button and instruction view
        final ImageView displayedImage = findViewById(R.id.displayedImage);
        final TextView instructions = findViewById(R.id.instructions);
        final TextView caption = findViewById(R.id.Caption);
        final Button randomize = findViewById(R.id.randomize);
        //making the button randomize image and caption
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int imageIndex = random.nextInt(8) + 3;
                int captionIndex = random.nextInt(9) + 2;
                caption.setText(memeCaptions[captionIndex]);
                displayedImage.setImageResource(memeImages[imageIndex]);
            }
        });
        instructions.setText("Tilt phone backwards ");
    }
}
