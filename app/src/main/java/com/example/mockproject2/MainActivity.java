package com.example.mockproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //the arrays for the images and text strings to be displayed, images and text still need to be added
    final String caption1 = "when the midterm has 4 programing problems instead of 3";
    final String caption2 = "when Geoff walks into office hours";
    final int[] memeImages = {R.drawable.generic_space_scene_HD};
    final String[] memeCaptions = {caption1, caption2};
    final String directions = "Tilt device backwards to randomize image or tilt device forwards to randomize caption.";
    final String noGyroscope = "We couldn't connect to your gyroscope, please use the 'RANDOMIZE' button to generate memes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        //after we put in the library/API for the gyroscope, we put that coed here
        instructions.setText(directions);
    }
}
