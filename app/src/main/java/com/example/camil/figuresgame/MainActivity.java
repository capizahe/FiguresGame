package com.example.camil.figuresgame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

import Model.Figure;

public class MainActivity extends AppCompatActivity {

    private Button red_button,blue_button,green_button;

    private ImageView figure;
    private Figure[] figures;
    private TextView puntaje;
    private TextView vidas;
    private Figure actual_figure;
    private int total = 0;
    private int lives = 3;
    private TextView stado;
    private int option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.figure = (ImageView) findViewById(R.id.actual_figure);
        this.puntaje = (TextView) findViewById(R.id.score);
        this.red_button = (Button) findViewById(R.id.red_button);
        this.blue_button = (Button) findViewById(R.id.blue_button);
        this.green_button = (Button) findViewById(R.id.green_button);

        loadImages();
        this.puntaje.setText("0");
        actual_figure = figures[randomFigure()];
        this.figure.setImageResource(actual_figure.getFigure());
        this.vidas = (TextView) findViewById(R.id.lives);
        this.vidas.setText(lives+"");
        this.stado = (TextView) findViewById(R.id.statusid);
        addListeners();
        randomOption();
    }

    public void addListeners(){
        this.puntaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                randomOption();
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void randomOption(){

        Random random = new Random();
         option = random.nextInt(2);
        if(option == 0){
            red_button.setText("CIRCLE");
            blue_button.setText("TRIANGLE");
            green_button.setText("SQUARE");
        }
        else {
            red_button.setText("RED");
            blue_button.setText("BLUE");
            green_button.setText("GREEN");
        }
    }

    public void onClickBlue(View view){
        if(option == 1) {
            if (actual_figure.getColor().equals("blue")) {
                total += 10;
                puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                updateLives();
                total -= 5;
                puntaje.setText(this.total + "");
            }
        }
        else{
            if (actual_figure.getShape().equals("triangle")) {
                total += 10;
                puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                updateLives();
                total -= 5;
                puntaje.setText(this.total + "");
            }
        }
        checkStatus();
    }
    public void onClickRed(View view){
        if(option == 1) {
            if (actual_figure.getColor().equals("red")) {
                this.total += 10;
                this.puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                total -= 5;
                updateLives();
                puntaje.setText(this.total + "");
            }
        }else{
            if (actual_figure.getShape().equals("circle")) {
                this.total += 10;
                this.puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                total -= 5;
                updateLives();
                puntaje.setText(this.total + "");
            }
        }
        checkStatus();
    }
    public void updateLives(){
        this.vidas.setText(this.lives+"");
    }
    public void onClickRestart(View view){
        this.lives = 3;
        this.total = 0;
        this.puntaje.setText("0");
        this.stado.setText("");
        updateLives();
    }
    public void onClickGreen(View view){

        if(option == 1) {
            if (actual_figure.getColor().equals("green")) {
                this.total += 10;
                this.puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                total -= 5;
                updateLives();
                puntaje.setText(this.total + "");
            }
        }else{

            if (actual_figure.getShape().equals("square")) {
                this.total += 10;
                this.puntaje.setText(this.total + "");
                newFigure();
            } else {
                lives--;
                total -= 5;
                updateLives();
                puntaje.setText(this.total + "");
            }
        }
        checkStatus();
    }

    private void checkStatus(){
        if(lives == 0 ){
        stado.setText("PERDISTE");
        stado.setTextColor(Color.RED);
    }else{
        if (total >= 400) {
            stado.setText("GANASTE");
            stado.setTextColor(Color.GREEN);
        }
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
