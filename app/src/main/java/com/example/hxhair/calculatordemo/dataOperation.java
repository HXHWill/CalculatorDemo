package com.example.hxhair.calculatordemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by HXHAIR on 2017/3/28.
 */

public class dataOperation implements Serializable{
    String MainPath;
    public String getData(String path) throws IOException, ClassNotFoundException {

        ObjectInputStream objectInputStream =
                null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = (String) objectInputStream.readObject();

        objectInputStream.close();
        return str;

    }
    public void saveData(String str,String path) {
        MainPath=path+"/hxh.txt";
        File file=new File(MainPath);
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(MainPath));
            oos.writeObject(str);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
