package com.example.zhanglei.denglu;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanglei on 2016/4/17.
 */
public class save {
    public static boolean saveinfo(String name,String pass)
    {
        String user=name+"##"+pass;
        File fi=new File("/data/data/com.example.zhanglei.denglu/file.txt");
        try {
            FileOutputStream fou=new FileOutputStream(fi);
            fou.write(user.getBytes());
            fou.close();
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }



    }
    public static Map<String,String> readinfo()
    {
        Map<String,String> map=new HashMap<String,String>();

        try {
            File file=new File("/data/data/com.example.zhanglei.denglu/file.txt");
            FileInputStream fin=new FileInputStream(file);
            BufferedReader buf=new BufferedReader(new InputStreamReader(fin));
            String str=buf.readLine();
            String name=str.split("##")[0];
            String pass=str.split("##")[1];
            map.put("name",name);
            map.put("pass",pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
