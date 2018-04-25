package sample.Controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.Model.DrawingEngine;
import sample.Shape;

import sample.ShapeFactory;
import sample.View.Brush;
import javafx.util.*;
import sample.View.Circle;
import sample.View.Rectangle;


import javax.swing.*;
import java.awt.*;


public class Controller {
    private javafx.scene.shape.Shape selectedShape;
    DrawingEngine d=null;
    @FXML
    ColorPicker colorpick;
    @FXML
    ColorPicker fillcolorpick;
    @FXML
    Slider slider;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Pane pane;
    @FXML
    Slider sizeslider;
    Brush brusheer = new Brush();
    double x=0,y=0;

private boolean resizeselected=false;
    private boolean lineselected =false;
    private boolean circleselected=false;
    private boolean rectangleselected=false;
    private boolean ellipseselected=false;
    private boolean erasserselected=false;
    private boolean brusherselected=false;
    private  boolean squareselected=false;
    private boolean triangleselected=false;
    private boolean selectselected=false;
    private boolean deleteselected=false;
Shape shape=null;
int del=0;
ShapeFactory shapefactory = new ShapeFactory();
    public void LineSelected(ActionEvent actionEvent) {
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        selectselected=false;
        lineselected^=true;
        deleteselected=false;
        resizeselected=false;
    }

    public void Rectselected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected^=true;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        selectselected=false;
        deleteselected=false;
        resizeselected=false;
    }

    public void Circleselected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected^=true;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
    }

    public void BrusherSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected^=true;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;


    }

    public void ErasserSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected^=true;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
        del=3;
    }
    public void triangleSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected^=true;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
    }

    public void EllipseSeleted(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected^=true;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected=false;
        resizeselected=false;
    }

    public void SquareSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected^=true;
        deleteselected=false;
        resizeselected=false;
    }


    public void MouseDragged(MouseEvent mouseEvent) {
        double x1 = mouseEvent.getScreenX();
        double y1 = mouseEvent.getScreenY();
        if (rectangleselected) {
            shape.removeextra(pane);
            getinforect(x1, y1);
            shape.draw(pane,del);


        }
        else if (lineselected) {
            shape.removeextra(pane);
            getinfoline(x1, y1);
            shape.draw(pane,del);
        }
        else if(circleselected){
            shape.removeextra(pane);
            getinfocircle(x1,y1);
            shape.draw(pane,del);
        }
        else if (ellipseselected) {
            shape.removeextra(pane);
            getinfoellipse(x1, y1);
            shape.draw(pane,del);
        }
        else if (squareselected) {
            shape.removeextra(pane);
            getinfosqr(x1, y1);
            shape.draw(pane,del);
        }
        else if (triangleselected) {
            shape.removeextra(pane);
            getinfotri(x1, y1);
            shape.draw(pane,del);
        } else if (brusherselected) {
            getinfobrush(x1, y1,1);
            brusheer.draw(pane);
        }else if(erasserselected){
            getinfobrush(x1, y1,2);
            brusheer.draw(pane);
        }


    }

    public void MouseMoved(MouseEvent mouseEvent) {

        label1.setText("X: "+mouseEvent.getScreenX()+"");
        label2.setText("Y: "+mouseEvent.getScreenY()+"");

    }

    public void MouseReleased(MouseEvent mouseEvent) {
        double x1 = mouseEvent.getScreenX();
        double y1 = mouseEvent.getScreenY();

        if (rectangleselected) {
            ((sample.View.Rectangle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
        }
        else if (lineselected) {
            ((sample.View.Line) shape).getinfog(x, y, x1, y1);
            shape.draw(pane,del);
        }else if (circleselected)
        {
            ((sample.View.Circle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
        } else if (ellipseselected) {
            ((sample.View.Ellipse) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);

        }
        else if (squareselected) {
            ((sample.View.Square) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);

        }
        else if (triangleselected) {
            ((sample.View.Triangle) shape).getInfog(x, y, x1, y1);
            shape.draw(pane,del);
       }
        else if(brusherselected){
            brusheer.getInfog(x1,y1,1);
            brusheer.draw(pane);
        }else if(erasserselected){
            getinfobrush(x1, y1,2);
            brusheer.draw(pane);
        }

    }

    public void MousePressed(MouseEvent mouseEvent) {

        x = mouseEvent.getScreenX();
        y = mouseEvent.getScreenY();

        if (rectangleselected) {
            shape = shapefactory.constructshape("rectangle");
        }
        else if(lineselected){
            shape=shapefactory.constructshape("line");
        }
        else if(circleselected){
            shape=shapefactory.constructshape("circle");
        }
        else if(ellipseselected){
            shape = shapefactory.constructshape("ellipse");
        }
       else if (squareselected) {
        shape = shapefactory.constructshape("square");}
        else if (triangleselected) {

            shape = shapefactory.constructshape("triangle");}

    }


    public void getinforect(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Rectangle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    private void getinfoline(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Line) shape).getinfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    private void getinfocircle(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Circle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
        shape.get_size2(sizeslider.getValue());
    }
    public void getinfoellipse(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Ellipse) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    public void getinfosqr(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Square) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());
    }
    public void getinfotri(double x1, double y1) {
        shape.setColor(colorpick.getValue());
        shape.setFillColor(fillcolorpick.getValue());
        ((sample.View.Triangle) shape).getInfog(x, y, x1, y1);
        shape.getsize(slider.getValue());

    }


    public void fillcolorpick(ActionEvent actionEvent) {

    }
    private void getinfobrush(double x1, double y1,int h) {
        brusheer.setColor(colorpick.getValue());
        brusheer.getInfog(x1,y1,h);
        brusheer.getsize(slider.getValue());
    }


    public void deleteSelected(ActionEvent actionEvent) {
        lineselected=false;
        rectangleselected=false;
        circleselected=false;
        brusherselected=false;
        ellipseselected=false;
        erasserselected=false;
        triangleselected=false;
        squareselected=false;
        deleteselected^=true;
        resizeselected=false;
        for(int i=0;i<shape.selected_Shapes.size();i++){
            pane.getChildren().remove(shape.selected_Shapes.get(i));
            shape.deleted_Shapes.add(shape.selected_Shapes.get(i));
            shape.selected_Shapes.remove(i);
        }

}

    public void ResizeSelected(ActionEvent actionEvent) {
        lineselected = false;
        rectangleselected = false;
        circleselected = false;
        brusherselected = false;
        ellipseselected = false;
        erasserselected = false;
        triangleselected = false;
        squareselected = false;
        deleteselected = false;
        resizeselected ^= true;
        Circle c = new Circle();
        javafx.scene.shape.Circle c2 = null;
        javafx.scene.shape.Rectangle R2 = null;
        javafx.scene.shape.Polygon T = null;
        javafx.scene.shape.Ellipse E= null;
        for (int i = 0; i < shape.selected_Shapes.size(); i++) {
                if (shape.selected_Shapes.get(i).toString().contains("Circle")) {
                    c2 = (javafx.scene.shape.Circle) shape.selected_Shapes.get(i);
                    shape.cirlces.add(c2);
                    String x1 = JOptionPane.showInputDialog(null, "Enter Radius",0);
                    y = Double.parseDouble(x1);
                    pane.getChildren().remove(c2);
                    shape.cirlces.get(0).setRadius(y);
                    pane.getChildren().remove(c2);
                    pane.getChildren().add(shape.cirlces.get(0));
                    shape.cirlces.remove(0);
                }

            else if (shape.selected_Shapes.get(i).toString().contains("Rectangle")) {
                R2 = (javafx.scene.shape.Rectangle) shape.selected_Shapes.get(i);
                shape.Rectangles.add(R2);
                String x1 = JOptionPane.showInputDialog(null, "Enter Width", 0);
                y = Double.parseDouble(x1);
                String x2 = JOptionPane.showInputDialog(null, "Enter height", 0);
                double y2 = Double.parseDouble(x2);
                pane.getChildren().remove(c2);
                shape.Rectangles.get(0).setWidth(y);
                shape.Rectangles.get(0).setHeight(y2);
                pane.getChildren().remove(R2);
                pane.getChildren().add(shape.Rectangles.get(0));
                shape.Rectangles.remove(0);
            }
            else if (shape.selected_Shapes.get(i).toString().contains("Polygon")) {
                T = (javafx.scene.shape.Polygon) shape.selected_Shapes.get(i);
                shape.triangles.add(T);
                String u = JOptionPane.showInputDialog(null, "Enter  x1", 0);
               double  x1= Double.parseDouble(u);
                String a = JOptionPane.showInputDialog(null, "Enter y1", 0);
                double y1 = Double.parseDouble(a);
                String b = JOptionPane.showInputDialog(null, "Enter x2", 0);
                double x2 = Double.parseDouble(b);
                String w= JOptionPane.showInputDialog(null, "Enter y2", 0);
                double y2 = Double.parseDouble(w);
                String d = JOptionPane.showInputDialog(null, "Enter x3", 0);
                double x3 = Double.parseDouble(d);
                String e = JOptionPane.showInputDialog(null, "Enter y3", 0);
                double y3 = Double.parseDouble(e);
                pane.getChildren().remove(T);
                shape.triangles.get(0).getPoints().addAll(x1,y1,x2,y2,x3,y3);
                pane.getChildren().remove(T);
                pane.getChildren().add(shape.triangles.get(0));
                shape.triangles.remove(0);
            }
            if (shape.selected_Shapes.get(i).toString().contains("Ellipse")) {
                E = (javafx.scene.shape.Ellipse) shape.selected_Shapes.get(i);
                shape.ellipse.add(E);
                String x1 = JOptionPane.showInputDialog(null, "Enter Radius x",0);
                double y2 = Double.parseDouble(x1);
                String x2 = JOptionPane.showInputDialog(null, "Enter Radius y",0);
                double y3 = Double.parseDouble(x2);
                pane.getChildren().remove(T);
                shape.ellipse.get(0).setRadiusX(y2);
                shape.ellipse.get(0).setRadiusY(y3);
                pane.getChildren().remove(E);
                pane.getChildren().add(shape.ellipse.get(0));
                shape.ellipse.remove(0);
            }

        }}

}
