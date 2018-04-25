package sample.View;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class Brush {
    javafx.scene.shape.Circle B;
    double size;
    Color color;
    double x = 0, y = 0;
    int h=0;
    public void getInfog(double x, double y,int h) {
        this.x = x;
        this.y = y;
        this.h=h;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void getsize(double size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }
    public void draw(Object pane) {
        B = new Circle();
        Pane panelo = (Pane) pane;
        if(h==1){
            B.setFill(getColor());
        }
        else{
            B.setFill(Color.WHITESMOKE);
        }
        B.setRadius(size/2);
        B.setCenterX(x);
        B.setCenterY(y);
        panelo.getChildren().add(B);
    }}