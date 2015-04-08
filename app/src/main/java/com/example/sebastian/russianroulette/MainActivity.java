package com.example.sebastian.russianroulette;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Random rnd = new Random();
    Button rndBtn;
    TextView status;
    TextView debugInfo;
    TextView deathCounter;
    ImageView statusImage;
    Boolean colorChanger = true;
    Integer deathCount = 0;
    String deathCountStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView)findViewById(R.id.status);
        statusImage = (ImageView)findViewById(R.id.statusImage);
        deathCounter = (TextView)findViewById(R.id.deathCounter);
        debugInfo = (TextView)findViewById(R.id.debugInfo);

        rndBtn = (Button)findViewById(R.id.rndBtn);
        rndBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int rndNum = rnd.nextInt(6);
        debugInfo.setText("Random number is: " + rndNum);
        if (rndNum == 3)
        {
            statusImage.setImageResource(R.drawable.bang);
            status.setText(getString(R.string.statusDead));
            status.setBackgroundColor(Color.RED);
            deathCount+=1;
            deathCountStr = deathCount.toString();
            deathCounter.setText(getString(R.string.deathCounter).replaceAll("\\d", deathCountStr));
        }
        else if (rndNum != 3)
        {
            statusImage.setImageResource(R.drawable.barrel);
            status.setText(getString(R.string.statusAlive));
            if (colorChanger == true)
            {
                status.setBackgroundColor(Color.BLUE);
                colorChanger = false;
            }
            else if (colorChanger == false)
            {
                status.setBackgroundColor(Color.GREEN);
                colorChanger = true;
            }
        }
    }
}
