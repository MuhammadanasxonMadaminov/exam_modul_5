package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.bean.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            TypeToken<?> type = TypeToken.getParameterized(java.util.List.class, User.class);

            List<User> userList = gson.fromJson(new FileReader("resource/students.json"), type.getType());
//            System.out.println(userList);

            Double average = userList.stream()
                    .mapToInt(User::getAge)
                    .average()
                    .orElse(0.0);

//            System.out.println("average = " + average);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
