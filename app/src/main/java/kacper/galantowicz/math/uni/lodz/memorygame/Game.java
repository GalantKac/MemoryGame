package kacper.galantowicz.math.uni.lodz.memorygame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Game extends Activity {

    TextView t1,t2;
    ImageView a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4;

    //tablica zdjec
    Integer[] cardsArray = {1,2,3,4,5,6,11,12,13,14,15,16};

    // aktualne zdjecia
    int image1, image2, image3, image4, image5, image6,
            image11,image12,image13,image14,image15,image16;

    int firstCard, secondCard;
    int clickFirst, clickSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);

        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);

        a1.setTag("0");
        a2.setTag("1");
        a3.setTag("2");
        a4.setTag("3");
        b1.setTag("4");
        b2.setTag("5");
        b3.setTag("6");
        b4.setTag("7");
        c1.setTag("8");
        c2.setTag("9");
        c3.setTag("10");
        c4.setTag("11");

        //zaladowanie kart
        showCards();

        //potasowanie listy zeby sie nie powtarzala
        Collections.shuffle(Arrays.asList(cardsArray));

        // zmiana koloru drugiego gracza
        t2.setTextColor(Color.GRAY);
        //przekazywanie taga karcie
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(a1, Card);

            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(a2, Card);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(a3, Card);
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(a4, Card);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(b1, Card);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(b2, Card);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(b3, Card);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(b4, Card);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(c1, Card);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(c2, Card);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(c3, Card);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Card = Integer.parseInt((String) v.getTag());
                doStuff(c4, Card);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.P)
    //zdj i jego tag
    private void doStuff(ImageView iv, int card){
        //zamiana imega (odsloniecie go,pokazanie wartosci po drugiej strone)
        if(cardsArray[card] == 1)
        {
            iv.setImageResource(image1);
        }else if(cardsArray[card] == 2)
        {
            iv.setImageResource(image2);
        }else if(cardsArray[card] == 3)
        {
            iv.setImageResource(image3);
        }else if(cardsArray[card] == 4)
        {
            iv.setImageResource(image4);
        }else if(cardsArray[card] == 5)
        {
            iv.setImageResource(image5);
        }else if(cardsArray[card] == 6)
        {
            iv.setImageResource(image6);
        }else if(cardsArray[card] == 11)
        {
            iv.setImageResource(image11);
        }else if(cardsArray[card] == 12)
        {
            iv.setImageResource(image12);
        }else if(cardsArray[card] == 13)
        {
            iv.setImageResource(image13);
        }else if(cardsArray[card] == 14)
        {
            iv.setImageResource(image14);
        }else if(cardsArray[card] == 15)
        {
            iv.setImageResource(image15);
        }else if(cardsArray[card] == 16)
        {
            iv.setImageResource(image16);
        }

        //SPRAWDZANIE KTORY IMAGE JEST WYBRANY I ZAPISANIE GO OD PAMIECI
        if(cardNumber == 1){
            firstCard = cardsArray[card];
            if(firstCard>10){
                firstCard = firstCard - 10;
            }
            cardNumber = 2;
            clickFirst = card;
            //zablokowanie nacisneicia tego samego zdj
            iv.setEnabled(false);
        }else if(cardNumber == 2){
            secondCard = cardsArray[card];
            if(secondCard > 10){
                secondCard= secondCard-10;
            }
            cardNumber = 1;
            clickSecond = card;

            a1.setEnabled(false);
            a2.setEnabled(false);
            a3.setEnabled(false);
            a4.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            c1.setEnabled(false);
            c2.setEnabled(false);
            c3.setEnabled(false);
            c4.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //sprawdza czy zdj sa takie same
                    equaling();

                }
            },1000);
        }
    }

    private void equaling(){
        //jesli sa rowne usuwa(sprawia ze sa niewidzialne) i dodaje punkt
        if(firstCard == secondCard){
            if(clickFirst == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 1){
                a2.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 2){
                a3.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 4){
                b1.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 5){
                b2.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 6){
                b3.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 7){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 8){
                c1.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 9){
                c2.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 10){
                c3.setVisibility(View.INVISIBLE);
            }else if(clickFirst == 11){
                c4.setVisibility(View.INVISIBLE);
            }

            if(clickSecond == 0){
                a1.setVisibility(View.INVISIBLE);
            }else if(clickSecond == 1){
                a2.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 2){
                a3.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 3){
                a4.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 4){
                b1.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 5){
                b2.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 6){
                b3.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 7){
                b4.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 8){
                c1.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 9){
                c2.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 10){
                c3.setVisibility(View.INVISIBLE);
            }else if(clickSecond== 11){
                c4.setVisibility(View.INVISIBLE);
            }

            //dodawanie punktow zawodnika
            if(turn ==1){
                playerPoints++;
                t1.setText("P1: "+ playerPoints);
            } else if(turn == 2)
            {
                cpuPoints++;
                t2.setText("P2: "+ cpuPoints);
            }
        } else {//jesli nie sa rowne pokazuje domyslna postac (zamieni tez te co byly zakceptowane ze rowne ale sa niewidzialne :P )
            a1.setImageResource(R.drawable.android);
            a2.setImageResource(R.drawable.android);
            a3.setImageResource(R.drawable.android);
            a4.setImageResource(R.drawable.android);
            b1.setImageResource(R.drawable.android);
            b2.setImageResource(R.drawable.android);
            b3.setImageResource(R.drawable.android);
            b4.setImageResource(R.drawable.android);
            c1.setImageResource(R.drawable.android);
            c2.setImageResource(R.drawable.android);
            c3.setImageResource(R.drawable.android);
            c4.setImageResource(R.drawable.android);
            //zmiana kolejnosci zawodnika
            if(turn == 1){
                turn = 2;
                t1.setTextColor(Color.GRAY);
                t2.setTextColor(Color.BLACK);
            }else if(turn == 2){
                turn = 1;
                t1.setTextColor(Color.BLACK);
                t2.setTextColor(Color.GRAY);
            }
        }
//mozna spowrotem naciskac karty
        a1.setEnabled(true);
        a2.setEnabled(true);
        a3.setEnabled(true);
        a4.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        c1.setEnabled(true);
        c2.setEnabled(true);
        c3.setEnabled(true);
        c4.setEnabled(true);
//czy koniec
        checkEnd();

    }
    private void checkEnd(){
        if(//jesli wszystkie sa niewidzialne rzuca dialog
        a1.getVisibility()==View.INVISIBLE &&
        a2.getVisibility()==View.INVISIBLE &&
        a3.getVisibility()==View.INVISIBLE &&
        a4.getVisibility()==View.INVISIBLE &&
        b1.getVisibility()==View.INVISIBLE &&
        b2.getVisibility()==View.INVISIBLE &&
        b3.getVisibility()==View.INVISIBLE &&
        b4.getVisibility()==View.INVISIBLE &&
        c1.getVisibility()==View.INVISIBLE &&
        c2.getVisibility()==View.INVISIBLE &&
        c3.getVisibility()==View.INVISIBLE &&
        c4.getVisibility()==View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Game.this);
            alertDialogBuilder.setMessage("GAME OVER!!!\nP1: " + playerPoints + "P2: "+ cpuPoints).setCancelable(false)
                    .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),Game.class);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Game.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    private void showCards(){
        image1 = R.drawable.image1;
        image2 = R.drawable.image2;
        image3 = R.drawable.image3;
        image4 = R.drawable.image4;
        image5 = R.drawable.image5;
        image6 = R.drawable.image6;
        image11 = R.drawable.image11;
        image12 = R.drawable.image12;
        image13 = R.drawable.image13;
        image14 = R.drawable.image14;
        image15 = R.drawable.image15;
        image16 = R.drawable.image16;

    }
}



