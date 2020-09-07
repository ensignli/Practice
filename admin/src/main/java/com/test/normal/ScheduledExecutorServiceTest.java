package com.test.normal;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author spark
 * @title: ScheduledExecutorServiceTest
 * @description: TODO
 * @date 2019/4/2810:58
 */
public class ScheduledExecutorServiceTest {
    public static void main(String[] args) {
       /* ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (true)
        {
            executorService.execute(()->{
                System.out.printf("dd");
            });
            break;
        }*/
            List<Map<?, ?>> dataList = new ArrayList<Map<?, ?>>();
            String pathName = "F:/security.txt";
            FileInputStream fis = null;
            InputStreamReader isr = null;
            BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
            try {
                String str = "";
                String str1 = "";
                fis = new FileInputStream(pathName);// FileInputStream
                // 从文件系统中的某个文件中获取字节
                isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
                br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
                while ((str = br.readLine()) != null) {
                    str1 += str + "\n";
                }
                // 当读取的一行不为空时,把读到的str的值赋给str1
                JSONObject jsonResult = (JSONObject)JSONObject.parse(str1.trim());
               JSONArray dataArray = jsonResult.getJSONArray("data");
                if(null != dataArray && dataArray.size() > 0) {
                    for (int i = 0; i < dataArray.size(); i++) {
                        Map obj = new HashMap();
                        JSONObject data =  (JSONObject)dataArray.get(i);
                        obj.put("userName",  data.getString("userName"));
                        obj.put("customerNum",  data.getLongValue("customerNum"));
                        obj.put("mobilePhone",  data.getString("mobilePhone"));
                        obj.put("email",  data.getString("email"));
                        dataList.add(obj);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("找不到指定文件");
            } catch (IOException e) {
                System.out.println("读取文件失败");
            } finally {
                try {
                    br.close();
                    isr.close();
                    fis.close();
                    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        dataList.forEach(map->{
            map.keySet().forEach(key-> System.out.println(key+" : "+map.get(key)));
        });
    }

    public static String readToString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }
}
