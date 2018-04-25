package sample.Model;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import sample.Shape;

public interface DrawingEngine {
     void refresh(Object pane);
     void resize(MouseEvent e,  javafx.scene.shape.Shape selectedShape);
     javafx.scene.shape.Shape move (javafx.scene.shape.Shape shape);
     void addShape(Shape shape);
     public void removeShape(javafx.scene.shape.Shape shape);
     public void updateShape(javafx.scene.shape.Shape old_shape , javafx.scene.shape.Shape new_shape);
     Shape[] getShapes();
     void undo();
     void redo();
     void save(String path);
     void load(String path);
}