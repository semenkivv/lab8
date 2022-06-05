package com.company;


//Прямоугольный треугольник, наследованый от обычного
public class SquareTriangle extends Triangle {
    public SquareTriangle(double a, double b, double c) {
        super(a, b, c);
    }

    public boolean checkSquareAngle(){
        if(super.getA() *super.getA()+super.getB()*super.getB() == super.getC()*super.getC()){
            return true;
        } else{
            return false;
        }
    }
}
