package com.example.wojtekw.tre_i_rad;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThings();

        /*if(savedInstanceState != null)
        {
            rightIntScore = savedInstanceState.getInt("RightIntScore");
            leftIntScore = savedInstanceState.getInt("LeftIntScore");
        }
        else {
            rightIntScore = 0;
            leftIntScore = 0;
        }*/
    }

    /*@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("RightIntScore",rightIntScore);
        savedInstanceState.putInt("LeftIntScore",leftIntScore);

        super.onSaveInstanceState(savedInstanceState);
    }*/

    /*public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        rightIntScore = savedInstanceState.getInt("RightIntScore");
        leftIntScore = savedInstanceState.getInt("LeftIntScore");
    }*/

    private void changeTurn(int position) {

        if (Turns == Turn.Circle) {
            spaces[position].setImageResource(R.drawable.circle);
            spaces[position].setId(GameLogic.O);
            Turns = Turn.Cross;
            viewShow.setText("X tur");
            viewShow.setTypeface(null, Typeface.BOLD);
        } else {
            spaces[position].setImageResource(R.drawable.cross);
            spaces[position].setId(GameLogic.X);
            Turns = Turn.Circle;
            viewShow.setText("O tur");
            viewShow.setTypeface(null, Typeface.BOLD);
        }

        spaces[position].setEnabled(false);
        counter++;

        if (GameLogic.isDone(position + 1, spaces)) {
            viewShow.setText(GameLogic.Champion + " vann");
            viewShow.setTypeface(null, Typeface.BOLD);
            makeLineVisible(GameLogic.Set);
            turnOffAllBoxes();
            /*if(GameLogic.Champion == "X")
            {
                leftIntScore =+ 1;
                leftScore.setText("" + leftIntScore);
            }
            else{
                rightIntScore =+ 1;
                rightScore.setText("" + rightIntScore);
            }*/

        }else if (counter ==9){
            viewShow.setText("Oavgjort. Försök igen");
            viewShow.setTypeface(null, Typeface.BOLD);
        }
    }

    private void makeLineVisible(int line) {

        View view;
        switch (line) {

            case 1:
                view = findViewById(R.id.top_horizontal);
                break;

            case 2:
                view = findViewById(R.id.center_horizontal);
                break;

            case 3:
                view = findViewById(R.id.bottom_horizontal);
                break;

            case 4:
                view = findViewById(R.id.left_vertical);
                break;

            case 5:
                view = findViewById(R.id.center_vertical);
                break;

            case 6:
                view = findViewById(R.id.right_vertical);
                break;

            case 7:
                view = findViewById(R.id.left_right_diagonal);
                break;

            case 8:
                view = findViewById(R.id.right_left_diagonal);
                break;

            default:
                view = findViewById(R.id.top_horizontal);
        }
        view.setVisibility(View.VISIBLE);
    }

    private void turnOffAllBoxes() {

        for (int i = 0; i < 9; i++)
            spaces[i].setEnabled(false);
    }



    private ImageView[] spaces = new ImageView[9];
    private TextView viewShow;
    /*    private TextView leftScore;
        private TextView rightScore;*/
    private ImageView imageRedo;
/*    private int leftIntScore = 0;
    private int rightIntScore = 0;*/

    private enum Turn {Circle, Cross}
    private Turn Turns;

    private int counter = 0;

    private void startThings() {
        viewShow = (TextView) findViewById(R.id.display_board);
        imageRedo = (ImageView) findViewById(R.id.replay);
  /*      leftScore = (TextView) findViewById(R.id.x_score);
        rightScore = (TextView) findViewById(R.id.o_score);

        leftScore.setText("" + leftIntScore);
        rightScore.setText("" + rightIntScore);*/

        imageRedo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                Intent begin = getIntent();
                startActivity(begin);
            }
        });

        for (int position = 0; position < 9; position++) {
            int resId = getResources().getIdentifier("space_" + (position + 1), "id", getPackageName());
            spaces[position] = (ImageView) findViewById(resId);
            final int endPosition = position;
            spaces[position].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    changeTurn(endPosition);
                }
            });

        }

    }
}

