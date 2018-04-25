package sample.View;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Shape;

import java.util.HashMap;
import java.util.Map;

public class Line implements Shape {
    javafx.scene.shape.Line selected_shape;
    private Map<String, Double> properties =new HashMap<>();
    double size;
    Color color;
    Color fill_colour;
    double x=0,y=0;
    double x1=0;
    double y1=0;
    javafx.scene.shape.Line L;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    Pane panelo=new Pane();

    public void getinfog(double x,double y,double x1,double y1){
        this.x=x;
        this.y=y;
        this.x1=x1;
        this.y1=y1;
    }


    @Override
    public Shape[] getShapes() {
        return new Shape[0];
    }

    @Override
    public void setPosition(Point2D position) {

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
        this.color=color;

    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {this.fill_colour=color;

    }

    @Override
    public Color getFillColor() {
        return this.fill_colour;
    }



    @Override
    public void draw(Object pane ,int z) {
        Pane p = (Pane) pane;
        L=new javafx.scene.shape.Line();
        L.setOnMousePressed(circleOnMousePressedEventHandler);
        L.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        L.setFill(getFillColor());
        L.setStartX(x);
        L.setStartY(y);
        L.setEndX(x1);
        L.setEndY(y1);
        L.setCursor(Cursor.HAND);
        L.setStrokeWidth(size);
        L.setStroke(getColor());
        EventHandler<MouseEvent> OnMousePressedEventHandler =
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent t) {
                        if(t.getButton().equals(MouseButton.PRIMARY)){
                            if(t.getClickCount() == 2) {
                                selected_shape=(javafx.scene.shape.Line) t.getSource();
                                if(selected_Shapes.isEmpty())
                                    selected_Shapes.add(selected_shape);
                                else{
                                    for(int j=0;j<selected_Shapes.size();j++){
                                        if(!(selected_shape.equals(selected_Shapes.get(j))))
                                              selected_Shapes.add(selected_shape);
                                         }

                                }}
                            if(t.getClickCount()==3){
                                selected_shape=(javafx.scene.shape.Line) t.getSource();
                                for(int i=0;i<selected_Shapes.size();i++)
                                { if(selected_Shapes.get(i).equals(selected_shape))
                                     selected_Shapes.remove(selected_shape); }
                            }
                        }}

                };
        L.setOnMouseClicked(OnMousePressedEventHandler);
        createdshapes.add(L);
        p.getChildren().add(L);
       this.panelo=p;
    }

    @Override
    public void getsize(double x) {
this.size=x;
    }

    @Override
    public void get_size2(double x) {

    }

    @Override
    public void removeextra(Pane pane) {
pane.getChildren().remove(L);this.panelo=pane;
    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    panelo.getChildren().remove(L);
                    orgTranslateX = ((javafx.scene.shape.Line)(t.getSource())).getTranslateX();
                    orgTranslateY = ((javafx.scene.shape.Line)(t.getSource())).getTranslateY();
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

                    ((javafx.scene.shape.Line)(t.getSource())).setTranslateX(newTranslateX);
                    ((javafx.scene.shape.Line)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

}
