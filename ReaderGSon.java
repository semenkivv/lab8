package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;


//Загрузка файла, в котором сохранён список с треугольниками, средствами библотеки GSon
public class ReaderGSon {
    private String path;
    private TriangleLinkedList tr = new TriangleLinkedList();

    public ReaderGSon(String path){
        if(checkPath(path)){
            this.path = path;
        }
    }

    //Загружает файл из папки, используя путь, указанный при созднии объекта
    public boolean Load(){
        if(checkPath(this.path)){
            try{
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                this.tr = gson.fromJson(new FileReader(path),TriangleLinkedList.class);
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
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

    //Возвращает путь, указанный в объекте
    public String getPath(){
        return this.path;
    }

    //Принимает путь и записывает в объект
    public void setPath(){
        this.path = path;
    }

    //Возвращает список треугольников из объекта
    public TriangleLinkedList getTriangleLinkedList(){
        return this.tr;
    }

    //Принимает список треугольников и записывает в объект
    public void setTriangleLinkedList(TriangleLinkedList tr){
        this.tr = tr;
    }
}
