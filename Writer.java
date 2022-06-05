package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;


//Запись списка треугольников в файл, используя стандартный сериализатор
public class Writer {
    private TriangleLinkedList tr;
    private String path;

    public Writer(TriangleLinkedList tr, String path){
        if(checkFields(tr, path)){
            this.setTriangleLinkedList(tr);
            this.setPath(path);
        }
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

    //Сохраняет список треугольников, сохранённый в объекте, в файл, используя путь к файлу
    public boolean Save(){
        if(checkFields(this.tr,this.path)){
            var clonedList = tr.trList.clone();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(clonedList);
                objectOutputStream.flush();
                objectOutputStream.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else{
            return false;
        }
        return true;
    }

    public TriangleLinkedList getTriangleLinkedList(){
        return this.tr;
    }
    public void setTriangleLinkedList(TriangleLinkedList tr){
        this.tr = tr;
    }

    public String getPath(){
        return this.path;
    }
    public void setPath(String path){
        this.path = path;
    }
}
