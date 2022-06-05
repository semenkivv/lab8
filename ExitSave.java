package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//Класс, отвечающий за сохранение списка в файл с временной меткой
//Использует WriterGson для записи в файл, типа .json
public class ExitSave {

    public ExitSave(){
    }

    //Принимает список треугольников, путь к папке, и записывает принятый список в виде .json файла
    //с текущей датой и временем в имени
    public boolean Save(TriangleLinkedList tr, String path){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        var modifiedPath = path+time+FileExtensionsStrings.json;

        WriterGSon gson = new WriterGSon(tr,modifiedPath);

        if(gson.Save()){
            System.out.println("Exit save completed");
            return true;
        }else {
            System.out.println("Failed exit save");
            return false;
        }

    }
}
