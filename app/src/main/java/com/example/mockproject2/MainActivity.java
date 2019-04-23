package com.example.mockproject2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    ImageView displayedImage;
    TextView instructions;
    TextView caption;
    Button randomize;
    protected Sensor sensor;
    protected SensorManager SM;
    //the arrays for the images and text strings to be displayed, images and text still need to be added.
    int[] memeImages = {
            R.drawable.angry,
            R.drawable.balanced,
            R.drawable.barelysqueezing,
            R.drawable.catcrying,
            R.drawable.doll,
            R.drawable.eyesopen,
            R.drawable.duckfacejpg,
            R.drawable.confusedface,
            R.drawable.conspiracy,
            R.drawable.evilkermit,
            R.drawable.imindanger,
            R.drawable.jontron,
            R.drawable.kermitkeyboard,
            R.drawable.kermitlaptop,
            R.drawable.kermitmeme,
            R.drawable.thanos,
            R.drawable.rewindtime,
            R.drawable.wellyes,
            R.drawable.birdcage,
            R.drawable.blurkrabs,
            R.drawable.blurpat,
            R.drawable.celebsitting,
            R.drawable.fixinggradle,
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
    //thanos memes
    String[] captions = {
            "When the midterm has 4 programing problems instead of 3",
            "When Geoff walks into office hours",
            "When the curly brace doesnt have a friend ;{",
            "When you commit 5 mins before the deadline and it's still grading",
            "When you finish the hw during lecture",
            "PrairieLearn when you miss a semicolon",
            "When you go into the weekly quiz without doing the practice questions",
            "When people are already talking about the app but you haven't cloned",
            "When it asks you to format a String",
            "Expected 0 but found 1",
            "'Failed on a one-carbon molecule'",
            "When you realize your cbtf quiz was yesterday",
            "MPs : 5 hours, 5 points",
            "Reworking the test suites so you pass",
            "When you click test library again without changing anything",
            "When you code on a chromebook",
            "When you present your garbage code",
            "When you look back at MP 0",
            "When it asks you to RotateRight",
            "When you see the words Recursion",
            "For-loop OutOfBoundsException",
            "Trying to figure out ifGameIsStarted",
            "Trying to find the pivot point the 2d array",
            "When you get the hw on your first try",
            "When you finish the app section without the CAs",
            "Adding the missing comment on the MP",
            "Coding with no javadoc comments",
            "When you're not a defensive programmer",
            "When you optimize by using !isTrue vs isTrue == false",
            "Posting code on the forum",
            "When you tell your friend the MP was easy",
            "Two days in trying to complete farthestNorth",
            "When you call rotateRight 3 times to pass rotateLeft",
            "When the CAs try to understand your code",
            "When you try to explain your code",
            "When you see the next group waiting to take the Quiz",
            "NullPointerException",
            "Me, counting my drops",
            "Step 1: Do homework at 11, Step 2: Profit",
            "When all your code is in one conditional",
            "When you're 6 layers deep in for loops",
            "When Ben Nordick doesn't know the answer",
            "When Geoff replies 'No'",
            "When you use Collections methods on Lists",
            "Checkstyle:",
            "l o o p",
            "When you read the programming questions after not paying attention to lecture",
    };
    //Directions and details.
    final String directions = "Tilt device forwards to randomize image and caption. Or tilt device forwards to download.";
    //final String noGyroscope = "We couldn't connect to your gyroscope, please use the 'RANDOMIZE' button to generate memes";
    Random random = new Random();
    //The current and last picked image and text.
    int pickedImage = 0;
    int lastImage = 0;
    int pickedText = 0;
    int lastText = 0;
    protected boolean tilted = false;
    @Override
    public void onSensorChanged(SensorEvent event) {
        //Backward tilt
        if (event.values[2] > 8.5 && !tilted) {
            displayedImage.setImageResource(memeImages[randImage()]);
            caption.setText(captions[randText()]);
            tilted = true;
        }
        //Forward tilt
        if (event.values[2] < -9 && !tilted) {
            tilted = true;
        }
        //Reset Vertical
        if (event.values[1] > 6 && tilted) {
            tilted = false;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Setting up our sensor manager and Senor object
        SM =  (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the caption view, image view, button and instruction view.
        displayedImage = findViewById(R.id.displayedImage);
        instructions = findViewById(R.id.instructions);
        caption = findViewById(R.id.caption);
        randomize = findViewById(R.id.randomize);
        //making the button randomize image and caption
        randomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayedImage.setImageResource(memeImages[randImage()]);
                caption.setText(captions[randText()]);
            }
        });
        //after we put in the library/API for the gyroscope, we put that code here.
        instructions.setText(directions);
    }
    private int randImage() {
        //remove duplicate images.
        do {
            pickedImage = random.nextInt(memeImages.length);
        } while (pickedImage == lastImage);
        lastImage = pickedImage;
        //display random image.
        //remove duplicate text.
        return pickedImage;
    }
    private int randText() {
        do {
            pickedText = random.nextInt(captions.length);
        } while (pickedText == lastText);
        lastText = pickedText;
        //display random text
        return pickedText;
    }
}
