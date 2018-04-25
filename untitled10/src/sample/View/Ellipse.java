package sample.View;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Model.DrawingEngine;
import sample.Shape;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class Ellipse implements Shape,DrawingEngine {
    javafx.scene.shape.Ellipse selected_shape;
    private Map<String, Double> properties =new HashMap<>();
    Point2D position;
    javafx.scene.shape.Ellipse E;
    double size;
    Color color;
    Color fill_color;
    double x = 0, y = 0;
    double x1, y1;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Pane panelo=new Pane();
    public void getInfog(double x, double y, double x1, double y1) {
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void refresh(Object pane) {

    }

    @Override
    public void resize(MouseEvent e,  javafx.scene.shape.Shape selectedShape) {
        // TODO Auto-generated method stub

        double x2 = e.getX();
        double y2 = e.getY();
        double cx = ((javafx.scene.shape.Circle) selectedShape).getCenterX();
        double cY =( (javafx.scene.shape.Circle) selectedShape).getCenterY();
        if (x2>= cx && y2 >= cY) {
            ( (javafx.scene.shape.Circle) selectedShape).setRadius((x2 - cx));
        }

    }


    public javafx.scene.shape.Shape move(javafx.scene.shape.Shape shape) {
        shape.setOnMousePressed(circleOnMousePressedEventHandler);
        shape.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        return shape;
    }

    @Override
    public void addShape(Shape shape) {

    }

    @Override
    public void removeShape(javafx.scene.shape.Shape shape)  {

    }

    @Override
    public void updateShape(javafx.scene.shape.Shape old_shape, javafx.scene.shape.Shape new_shape) {

    }

    @Override
    public Shape[] getShapes() {
        return new Shape[0];
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void save(String path) {

    }

    @Override
    public void load(String path) {

    }

    @Override
    public void setPosition(Point2D position) {
        this.position = position;
    }

    @Override
    public Point2D getPosition() {
        return null;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties=properties;

    }

    @Override
    public Map<String, Double> getProperties() {
        return this.properties;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fill_color = color;
    }

    @Override
    public Color getFillColor() {
        return this.fill_color;
    }



    @Override
    public void draw(Object pane ,int z) {
        Pane p = (Pane) pane;

        E = new javafx.scene.shape.Ellipse();
        E.setCursor(Cursor.MOVE);
        double centerY = (abs(y1) + abs(y)) / 2;
        double centerX = (abs(x1) + abs(x)) / 2;
        E.setCenterX(centerX);
        E.setCenterY(centerY);
        if(x1>x&&y1>y){
            E.setRadiusY(y1-y);
            E.setRadiusX(x1 - x);
        }else if(x>x1&&y>y1) {
            E.setRadiusX(x - x1);
            E.setRadiusY(y - y1);
        }else if(x==x1&&y==y1){
        }else if(x>x1&&y1>y){
            E.setRadiusX(x - x1);
            E.setRadiusY(y1 - y);
        }else if(x1>x&&y>y1){
            E.setRadiusX(x1 - x);
            E.setRadiusY(y - y1);
        }   E= (javafx.scene.shape.Ellipse) move(E);
        E.setStroke(getColor());
        E.setFill(getFillColor());
        E.setStrokeWidth(size);
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Ellipse) t.getSource();
                                selected_shape.setStrokeWidth(2);
                                selected_shape.setStroke(Color.RED);
                                if(selected_Shapes.isEmpty())
                                        selected_Shapes.add(selected_shape);
                                else{
                                     for(int j=0;j<selected_Shapes.size();j++){
                                      if(!(selected_shape.equals(selected_Shapes.get(j))))
                                       selected_Shapes.add(selected_shape);
                                      }

                            }}
                             if(t.getClickCount()==3){
                                 selected_shape=(javafx.scene.shape.Ellipse) t.getSource();
                                selected_shape.setStroke(Color.WHITE);
                                for(int i=0;i<selected_Shapes.size();i++)
                                { if(selected_Shapes.get(i).equals(selected_shape))
                                    selected_Shapes.remove(selected_shape);

                                }
                            }
}}

                };

        E.setOnMouseClicked(OnMousePressedEventHandler);
        createdshapes.add(E);
        p.getChildren().add(E);
}

    @Override
    public void getsize(double size) {
        this.size = size;

    }

    @Override
    public void get_size2(double x) {

    }


    @Override
    public void removeextra(Pane pane) {
        pane.getChildren().remove(E);
        this.panelo=pane;
    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    panelo.getChildren().remove(E);
                    orgTranslateX = ((javafx.scene.shape.Ellipse)(t.getSource())).getTranslateX();
                    orgTranslateY = ((javafx.scene.shape.Ellipse)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((javafx.scene.shape.Ellipse)(t.getSource())).setTranslateX(newTranslateX);
                    ((javafx.scene.shape.Ellipse)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

}
