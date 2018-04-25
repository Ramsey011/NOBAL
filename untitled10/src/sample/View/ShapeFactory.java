package sample;


import sample.View.*;

public class ShapeFactory {
    public sample.Shape constructshape(String type)
    {
        if (type.equalsIgnoreCase("rectangle")){
            return new Rectangle();
            }
        else if(type.equalsIgnoreCase("circle"))
            return new Circle();
        else if(type.equalsIgnoreCase("ellipse"))
            return new Ellipse();
        else if(type.equalsIgnoreCase("square"))
            return new Square();
        else if(type.equalsIgnoreCase("line"))
            return new Line();
        else if(type.equalsIgnoreCase("triangle"))
            return new Triangle();
        else
            return null;
    }}
