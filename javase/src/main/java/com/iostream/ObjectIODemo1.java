package com.iostream;

import java.io.*;

public class ObjectIODemo1 {
    public static void main(String[] args) throws Exception {
        //创建Object流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("log.txt"));
        T t = new T();
        t.i = 111;
        oos.writeObject(t);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("log.txt"));
        T tt = (T) ois.readObject();
        System.out.println(tt.toString());
    }
}

class T implements Serializable {
    transient int i = 1;
    int j = 2;
    int k = 3;
    int ii = 11;

    @Override
    public String toString() {
        return "T{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                ", ii=" + ii +
                '}';
    }
}
