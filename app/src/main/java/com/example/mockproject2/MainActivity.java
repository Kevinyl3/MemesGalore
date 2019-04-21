package com.example.mockproject2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //the arrays for the images and text strings to be displayed, images and text still need to be added.
    int[] memeImages = {
            R.drawable.angry,
            R.drawable.birdcage,
            R.drawable.blurkrabs,
            R.drawable.blurpat,
            R.drawable.celebsitting,
            R.drawable.fixinggradle,
            R.drawable.food,
            R.drawable.girlthinking,
            R.drawable.hacker3,
            R.drawable.hak,
            R.drawable.hamsterlurking,
            R.drawable.hidethepain,
            R.drawable.krabsface,
            R.drawable.lookback,
            R.drawable.mohish,
            R.drawable.pat,
            R.drawable.pikachumeme,
            R.drawable.profit,
            R.drawable.repllingdown,
            R.drawable.scaredhamster,
            R.drawable.sitbackfree,
            R.drawable.spongebob,
            R.drawable.spongevertical,
            R.drawable.stop,
            R.drawable.thonk,
            R.drawable.tom,
            R.drawable.celebsitting};
    String[] captions = {
            "When the midterm has 4 programing problems instead of 3",
            "When Geoff walks into office hours",
    };
    final String directions = "Tilt device backwards to randomize image or tilt device forwards to randomize caption.";
    final String noGyroscope = "We couldn't connect to your gyroscope, please use the 'RANDOMIZE' button to generate memes";
    Random random = new Random();
    //The current and last picked image and text.
    int pickedImage = 0;
    int lastImage = 0;
    int pickedText = 0;
    int lastText = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the caption view, image view, button and instruction view.
        final ImageView displayedImage = findViewById(R.id.displayedImage);
        final TextView instructions = findViewById(R.id.instructions);
        final TextView caption = findViewById(R.id.caption);
        final Button randomize = findViewById(R.id.randomize);
        //making the button randomize image and caption
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove duplicate images.
                do {
                    pickedImage = random.nextInt(memeImages.length);
                } while (pickedImage == lastImage);
                lastImage = pickedImage;
                //display random image.
                displayedImage.setImageResource(memeImages[pickedImage]);
                //remove duplicate text.
                do {
                    pickedText = random.nextInt(captions.length);
                } while (pickedText == lastText);
                lastText = pickedText;
                //display random text
                caption.setText(captions[pickedText]);
            }
        });
        //after we put in the library/API for the gyroscope, we put that code here.
        instructions.setText(directions);
    }
}
