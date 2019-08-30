package Model;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.widget.ImageView;

public class Figure {

    private int figure;
    private String color;
    private String shape;

    public Figure(int src, String color, String shape){
        this.color = color;
        this.figure = src;
        this.shape = shape;

    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFigure() {

        return figure;
    }

    public String getColor() {
        return color;
    }

}
