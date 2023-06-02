package com.yumi.jerrcode;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadYMAL {
    public void test() throws FileNotFoundException, IllegalAccessException {
        Integer t = 1;
        System.out.println(t);
        System.out.println(ErrCode.SUCCESS);
        for (Field field : ErrCode.class.getDeclaredFields()) {
            System.out.println(field.getName());
            System.out.println(field.get(field.getName()));
        }
        ErrCode
        System.out.println(ErrCode.SUCCESS.getCode());
        System.out.println(ErrCode.SUCCESS.format("ggg"));
        String path = ReadYMAL.class.getResource("/ymal").getPath();
        System.out.println(path);
        scan(path);
    }

    private void scan(String dir) throws FileNotFoundException {
        File file = new File(dir);
        if (!file.exists()) {
            return;
        }
        List<String> files = new ArrayList<>();
        getFileNames(file, files);
        System.out.println(files);
        Yaml yaml = new Yaml();
        for (String path : files) {
            InputStream inputStream = new FileInputStream(path);
            Map<String,Object> map = new HashMap<>();
            map = yaml.load(inputStream);
            System.out.println(map);
        }

    }

    private List<String> getFileNames(File file, List<String> fileNames) {
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isDirectory()) {
                getFileNames(f, fileNames);
            } else {
                fileNames.add(f.getAbsolutePath());
            }
        }
        return fileNames;
    }

//    public Map loadYml() throws FileNotFoundException {
//        InputStream inputStream = new FileInputStream(path);
//        Map<String,Object> map = new HashMap<>();
//        map = yaml.load(inputStream);
//        return map;
//    }
}
