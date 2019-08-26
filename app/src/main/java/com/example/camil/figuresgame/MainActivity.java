package com.example.camil.figuresgame;

import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private Figure actual_figure;
    private int total = 0;

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
    }

    public void onClickBlue(View view){

        if(actual_figure.getColor().equals("blue")) {
            total += 10;
            puntaje.setText(this.total+"");
            newFigure();
        }
        else{
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
            puntaje.setText(this.total+"");
        }
    }
    public void onClickChange(View view){
      newFigure();
    }
    public void onClickGreen(View view){

        if(actual_figure.getColor().equals("green")){
            total+=10;
            puntaje.setText(this.total+"");
            newFigure();
        }
        else{
            total-=5;
            puntaje.setText(this.total+"");
        }
    }

    private void newFigure(){
        this.actual_figure = figures[randomFigure()];
        this.figure.setImageResource(actual_figure.getFigure());
    }

    private void loadImages(){

        figures = new Figure[9];
        figures[0] = new Figure(R.drawable.blue_circle, "blue");
        figures[1] = new Figure(R.drawable.red_circle, "red");
        figures[2] = new Figure(R.drawable.green_circle, "green");

        figures[3] = new Figure(R.drawable.blue_triangle, "blue");
        figures[4] = new Figure(R.drawable.red_triangle, "red");
        figures[5] = new Figure(R.drawable.green_triangle, "green");

        figures[6] = new Figure(R.drawable.blue_square, "blue");
        figures[7] = new Figure(R.drawable.red_square, "red");
        figures[8] = new Figure(R.drawable.green_square, "green");

    }

    private int randomFigure(){
        Random random = new Random();
        return random.nextInt(figures.length);
    }

}
