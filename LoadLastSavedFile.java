package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

//Загрузка последнего сохранённого файла
public class LoadLastSavedFile {
    //Загружает самый новый из сохранённых файлов, используя стандартный путь к папке
    public TriangleLinkedList Load(){
        File[] folder = new File(FilePaths.normalPath).listFiles();
        Arrays.sort(folder, (File f1, File f2) -> Long.valueOf(f1.lastModified()).compareTo(f2.lastModified()));
        var f = folder[folder.length-1].getName();
        var readerGSon = new ReaderGSon(FilePaths.normalPath+f);
        if(readerGSon.Load()){
            return readerGSon.getTriangleLinkedList();
        }else {
            return null;
        }

    }
}
