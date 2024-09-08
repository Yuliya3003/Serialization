package homework;

import org.example.UserData;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Yuliya", 25, 4.75);
        FileOutputStream fileOutputStream = new FileOutputStream("students.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        System.out.println("Объект был сериализован");

        FileInputStream fileInputStream = new FileInputStream("students.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        student = (Student) objectInputStream.readObject();
        System.out.println("Объект десериализован");

        System.out.println("Имя: "+ student.getName());
        System.out.println("Возраст: "+ student.getAge());
        System.out.println("Пароль: "+ student.getGPA()); // будет 0.0, потому что мы указали это поле несериализуемым и оно становится нулем по умолчанию.
    }
}
