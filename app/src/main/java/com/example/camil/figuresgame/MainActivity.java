package com.example.camil.figuresgame;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.Random;

import Model.Figure;

public class MainActivity extends AppCompatActivity {

    private ImageView figure;
    private Figure[] figures;
    private TextView puntaje;
    private TextView vidas;
    private Figure actual_figure;
    private int total = 0;
    private int lives = 3;
    private TextView stado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.figure = (ImageView) findViewById(R.id.actual_figure);
        this.puntaje = (TextView) findViewById(R.id.score);
        loadImages();
        this.puntaje.setText("0");
        actual_figure = figures[randomFigure()];
        this.figure.setImageResource(actual_figure.getFigure());
        this.vidas = (TextView) findViewById(R.id.lives);
        this.vidas.setText(lives+"");
        this.stado = (TextView) findViewById(R.id.statusid);
        addListeners();
    }

    public void addListeners(){
        this.vidas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.equals("0")){
                    stado.setText("PERDISTE");
                    stado.setTextColor(Color.RED);
                }else{
                    if (total >= 100) {
                        stado.setText("GANASTE");
                        stado.setTextColor(Color.GREEN);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });



    }


    public void onClickBlue(View view){

        if(actual_figure.getColor().equals("blue")) {
            total += 10;
            puntaje.setText(this.total+"");
            newFigure();
        }
        else{
            lives -=1;
            updateLives();
            total-=5;
            puntaje.setText(this.total+"");
        }
    }
    public void onClickRed(View view){

        if(actual_figure.getColor().equals("red")){
            this.total+=10;
            this.puntaje.setText(this.total+"");
            newFigure();
        }
        else{
            total-=5;
            updateLives();
            puntaje.setText(this.total+"");
        }
    }
    public void updateLives(){
        this.vidas.setText(this.lives+"");
    }
    public void onClickChange(View view){
      newFigure();
    }
    public void onClickGreen(View view){

        if(actual_figure.getColor().equals("green")){
            puntaje.setText(this.total+"");
            newFigure();
        }
        else{
            total-=5;
            updateLives();
            puntaje.setText(this.total+"");
        }
    }

    private void newFigure(){
        this.actual_figure = figures[randomFigure()];
        this.figure.setImageResource(actual_figure.getFigure());
    }

    private void loadImages(){

        figures = new Figure[9];
        figures[0] = new Figure(R.drawable.blue_circle, "blue","circle");

        figures[1] = new Figure(R.drawable.red_circle, "red","circle");
        figures[2] = new Figure(R.drawable.green_circle, "green","circle");

        figures[3] = new Figure(R.drawable.blue_triangle, "blue","triangle");
        figures[4] = new Figure(R.drawable.red_triangle, "red","triangle");
        figures[5] = new Figure(R.drawable.green_triangle, "green","triangle");

        figures[6] = new Figure(R.drawable.blue_square, "blue","square");
        figures[7] = new Figure(R.drawable.red_square, "red","square");
        figures[8] = new Figure(R.drawable.green_square, "green","square");

    }

    private int randomFigure(){
        Random random = new Random();
        return random.nextInt(figures.length);
    }

}
