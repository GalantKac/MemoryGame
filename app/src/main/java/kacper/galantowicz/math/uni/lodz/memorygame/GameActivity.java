package kacper.galantowicz.math.uni.lodz.memorygame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends Activity {

    TextView playerOne, playerTwo;
    ImageView positionA1, positionA2, positionA3, positionA4, positionB1, positionB2, positionB3, positionB4, positionC1, positionC2, positionC3, positionC4;
    ImageView[] imageViews;
    Integer[] cardsArray = {1, 2, 3, 4, 5, 6, 11, 12, 13, 14, 15, 16};
    int[] images;
    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;
    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageViews = new ImageView[]{
                positionA1, positionA2, positionA3, positionA4,
                positionB1, positionB2, positionB3, positionB4,
                positionC1, positionC2, positionC3, positionC4
        };

        images = new int[]{
                R.drawable.image1, R.drawable.image2, R.drawable.image3,
                R.drawable.image4, R.drawable.image5, R.drawable.image6,
                R.drawable.image11, R.drawable.image12, R.drawable.image13,
                R.drawable.image14, R.drawable.image15, R.drawable.image16
        };
        init();
        setClickListenerOnImageView();
        shuffleArray(images, cardsArray);
    }

    private void setClickListenerOnImageView() {
        for (int indexNumber = 0; indexNumber < imageViews.length; indexNumber++) {
            final int finalIndexNumber = indexNumber;
            imageViews[indexNumber].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageViews[finalIndexNumber].setImageResource(images[finalIndexNumber]);
                    game(imageViews[finalIndexNumber], finalIndexNumber);
                }
            });
        }
    }

    @TargetApi(Build.VERSION_CODES.P)
    private void game(ImageView iv, int card) {
        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 10) {
                firstCard = firstCard - 10;
            }
            cardNumber = 2;
            clickFirst = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 10) {
                secondCard = secondCard - 10;
            }
            cardNumber = 1;
            clickSecond = card;

            for (int i = 0; i < imageViews.length; i++) {
                imageViews[i].setEnabled(false);
            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    comparisonOfCards();
                }
            }, 1000);
        }
    }

    private void comparisonOfCards() {
        if (firstCard == secondCard) {
            for (int i = 0; i < 12; i++) {
                if (clickFirst == i) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                    break;
                }
            }
            for (int i = 0; i < 12; i++) {
                if (clickSecond == i) {
                    imageViews[i].setVisibility(View.INVISIBLE);
                    break;
                }
            }
            if (turn == 1) {
                playerPoints++;
                playerOne.setText("P1: " + playerPoints);
            } else if (turn == 2) {
                cpuPoints++;
                playerTwo.setText("P2: " + cpuPoints);
            }
        } else {
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[i].setImageResource(R.drawable.android);
            }
            if (turn == 1) {
                turn = 2;
                playerOne.setTextColor(Color.GRAY);
                playerTwo.setTextColor(Color.BLACK);
            } else if (turn == 2) {
                turn = 1;
                playerOne.setTextColor(Color.BLACK);
                playerTwo.setTextColor(Color.GRAY);
            }
        }
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setEnabled(true);
        }
        //czy koniec
        checkEnd();

    }

    private void checkEnd() {
        if (checkVisibility()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GameActivity.this);
            alertDialogBuilder.setMessage("GAME OVER!!!\nP1: " + playerPoints + "P2: " + cpuPoints).setCancelable(false)
                    .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(GameActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    private void init() {
        playerOne = findViewById(R.id.t1);
        playerTwo = findViewById(R.id.t2);
        imageViews[0] = findViewById(R.id.a1);
        imageViews[1] = findViewById(R.id.a2);
        imageViews[2] = findViewById(R.id.a3);
        imageViews[3] = findViewById(R.id.a4);
        imageViews[4] = findViewById(R.id.b1);
        imageViews[5] = findViewById(R.id.b2);
        imageViews[6] = findViewById(R.id.b3);
        imageViews[7] = findViewById(R.id.b4);
        imageViews[8] = findViewById(R.id.c1);
        imageViews[9] = findViewById(R.id.c2);
        imageViews[10] = findViewById(R.id.c3);
        imageViews[11] = findViewById(R.id.c4);
        playerTwo.setTextColor(Color.GRAY);
    }

    private boolean checkVisibility() {
        boolean result = false;
        for (int i = 0; i < imageViews.length; i++) {
            if (imageViews[i].getVisibility() == View.INVISIBLE) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    static void shuffleArray(int[] images, Integer[] cards) {
        Random random = new Random();
        for (int i = images.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int tmpImages = images[index];
            int tmpCards = cards[index];
            images[index] = images[i];
            cards[index] = cards[i];
            images[i] = tmpImages;
            cards[i] = tmpCards;
        }
    }
}



