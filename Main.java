package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class Main {
    public static String path = "c:/java/";

    public static void main(String[] args) {

        TriangleLinkedList tr = new TriangleLinkedList();
        TriangleLinkedList sqTr = new TriangleLinkedList();
        int n,m = 0;

        BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Enter N: ");
            String str = con.readLine();
            System.out.println("Enter M: ");
            String str2 = con.readLine();
            n = Integer.parseInt(str);
            m = Integer.parseInt(str2);
        }catch(NumberFormatException e){
            System.out.println(e);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        tr = GenerateTriangles.generateTrianglesList(n);
        sqTr = GenerateTriangles.generateTrianglesList(n);

        var squares = tr.trList.stream().map(x -> x.getSquare()).collect(Collectors.toList());
        squares.addAll(sqTr.trList.stream().map(x -> x.getSquare()).collect(Collectors.toList()));
        double max = squares.stream().max(Double::compare).get();
        System.out.println("Max square is: "+max);

        var gipoMin = sqTr.trList.stream().map(x -> {
            if(x.getA() > x.getB() && x.getA() > x.getC()){
                return x.getA();
            } else if(x.getB()>x.getA() && x.getB() > x.getC()){
                return x.getB();
            } else{
                return x.getC();
            }
        }).collect(Collectors.toList()).stream().sorted(Comparator.naturalOrder()).findFirst().get();
        System.out.println("Min gipotenuza is: "+Math.floor(gipoMin*100)/100);

        LinkedList<Triangle> allList = new LinkedList<>();
        TriangleLinkedList all = new TriangleLinkedList();
        all.trList.addAll(tr.trList);
        all.trList.addAll(sqTr.trList);

    }
}

