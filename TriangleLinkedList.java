package com.bogdan;

import java.io.Serializable;
import java.util.LinkedList;


//Обёртка над List<> для треугольников
public class TriangleLinkedList implements Serializable {
    public LinkedList<Triangle> trList = new LinkedList<>();

    public TriangleLinkedList(){
    }
}
