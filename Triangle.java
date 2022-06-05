package com.company;

import java.io.Serializable;


//Класс, представляющий собой треугольник
public class Triangle implements Serializable {
    private double a, b, c;
    transient private boolean numbersFlag;

    public Triangle(){}

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        checkNumbers();
    }

    //Проверка соотношения данных сторон
    public boolean checkNumbers() {
        if (a + c > b || c + b > a) {
            numbersFlag = true;
            return true;
        } else {
            System.out.println("Sum of two sides of triangle lesser than third");
            numbersFlag = false;
            return false;
        }
    }

    private void showNumbersError() {
        System.out.println("Wrong numbers");
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    //Возвращает угол между сторонами АВ
    public double getAngleAB() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos(((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b)));
        return result;
    }

    //Возвращает угол между сторонами ВС
    public double getAngleBC() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
        return result;
    }

    //Возвращает угол между сторонами СА
    public double getAngleCA() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double result = Math.acos((Math.pow(c, 2) + Math.pow(a, 2) - Math.pow(b, 2)) / (2 * c * a));
        return result;
    }

    //Вовзращает периметр треугольника
    public double getPerimeter() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        return a + b + c;
    }

    //Возвращает площадь треугольника
    public double getSquare() {
        if (!numbersFlag) {
            showNumbersError();
            return 0.0;
        }
        double p = getPerimeter();
        return Math.floor(Math.sqrt(p*(p-a)*(p-b)*(p-c))*100)/100;
    }
}
