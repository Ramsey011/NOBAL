package sample;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Shape {
    List<javafx.scene.shape.Shape> createdshapes = new ArrayList<javafx.scene.shape.Shape>();
    List<javafx.scene.shape.Shape> selected_Shapes = new ArrayList<>();
    List<javafx.scene.shape.Shape> deleted_Shapes = new ArrayList<>();
    List<javafx.scene.shape.Circle> cirlces = new ArrayList<>();
    List<javafx.scene.shape.Rectangle> Rectangles = new ArrayList<>();
    List<javafx.scene.shape.Polygon> triangles = new ArrayList<>();
    List<javafx.scene.shape.Ellipse> ellipse = new ArrayList<>();
    public Shape[] getShapes();
    void setPosition(Point2D position);
    Point2D getPosition();
    void setProperties(Map<String, Double> properties);
    Map<String, Double> getProperties();
    void setColor(Color color);
    Color getColor();
    void setFillColor(Color color);
    Color getFillColor();
    void draw(Object pane,int z);
    void getsize(double x);
    public void get_size2(double x);
    void removeextra(Pane pane);
}

