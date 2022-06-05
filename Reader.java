package com.company;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.LinkedList;


//Загрузка файла, в котором сохранён список с треугольниками, средствами стандартного десериализатора
public class Reader {
    private TriangleLinkedList tr = new TriangleLinkedList();
    private String path;

    public Reader(String path){
        if(checkPath(path)){
            this.setPath(path);
        }
    }

    //Загружает файл из папки, используя путь, указанный при созднии объекта
    public boolean Load(){
        if(checkPath(this.path)){
            try{
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tr.trList = (LinkedList<Triangle>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else{
            return false;
        }
    }

    //Проерка пути к папке на доступность
    private boolean checkPath(String path){
        if(path == null || path == ""){
            throw new IllegalArgumentException("ERROR:File path given to TriangleWriter is NULL or equals empty");
        } else {
            try {
                Paths.get(path);
            } catch (InvalidPathException | NullPointerException e) {
                return false;
            }
        }
        return true;
    }

    //Возвращает список треугольников из объекта
    public TriangleLinkedList getTriangleLinkedList(){
        return this.tr;
    }

    //Принимает список треугольников и записывает в объект
    private void setTriangleLinkedList(TriangleLinkedList tr){
        this.tr = tr;
    }

    //Возвращает путь, указанный в объекте
    public String getPath(){
        return this.path;
    }

    //Принимает путь и записывает в объект
    public void setPath(String path){
        this.path = path;
    }
}
