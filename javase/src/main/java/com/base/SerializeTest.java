package com.base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**、
 * 可以
 * @author fanjie
 * @date 2022/8/17 10:19
 */
public class SerializeTest {
    public static void main(String[] args) throws IOException {
        deserialize();
    }

    public static void deserialize() throws IOException {
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("student.bin")));
        try {
            Object o = ois.readObject();
            if (o instanceof Student) {
                Student student = (Student) o;
                System.out.println(student);
            } else {
                throw new RuntimeException("Object is not match!");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void serialize() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("student.bin")));
        Student student = new Student();
        student.setName("zhangsan");
        oos.writeObject(student);
        oos.flush();
    }
}
