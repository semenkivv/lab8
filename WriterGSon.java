package com.bogdan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

//Запись списка треугольников в файл, используя библиотеку GSon
public class WriterGSon {

    private String path;
    private TriangleLinkedList tr;

    public WriterGSon(TriangleLinkedList tr, String path){
        if(checkFields(tr,path)){
            this.tr = tr;
            this.path = path;
        }
    }

    //Сохраняет список треугольников, сохранённый в объекте, в файл, используя путь к файлу
    public boolean Save(){
        if(checkFields(this.tr, this.path)){
            try{
                Writer writer = new FileWriter(this.path);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(this.tr);
                PrintWriter printWriter = new PrintWriter(path);
                printWriter.println(json);
                printWriter.flush();
                printWriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Проверка полей объекта на валидность
    private boolean checkFields(TriangleLinkedList tr, String path){
        if(tr == null){
            throw new NullPointerException("ERROR:Triangle object given to TriangleWriter is NULL");
        } else if(path == null || path == ""){
            throw new IllegalArgumentException("ERROR:File path given to TriangleWriter is NULL or equals empty");
        } else if(!checkPath(path)){
            throw new InvalidPathException(path, "Invalid path to file in TriangleWriter");
        } else{
            return true;
        }
    }

    //Проверка пути к папке на доступность
    private boolean checkPath(String path){
        try{
            Paths.get(path);
        }catch(InvalidPathException | NullPointerException e){
            return false;
        }
        return true;
    }

    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }

    public TriangleLinkedList getTriangleLinkedList(){
        return this.tr;
    }

    public void setTriangleLinkedList(TriangleLinkedList tr){
        this.tr = tr;
    }

}
