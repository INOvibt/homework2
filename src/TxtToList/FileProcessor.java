package TxtToList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    String name;
    int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class FileProcessor {
    public static List<User> readUsersFromFile(String filePath) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                users.add(new User(name, age));
            }
        }
        return users;
    }

    public static void writeUsersToJson(List<User> users, String jsonFilePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write("[\n");
            for (User user : users) {
                fileWriter.write("    {\n");
                fileWriter.write("        \"name\": \"" + user.name + "\",\n");
                fileWriter.write("        \"age\": " + user.age + "\n");
                fileWriter.write("    },\n");
            }
            fileWriter.write("]\n");
        }
    }

    public static void main(String[] args) {
        try {
            String inputFile = "C:\\Users\\Пользователь\\IdeaProjects\\homework2\\src\\TxtToList\\file.txt";
            String outputFile = "C:\\Users\\Пользователь\\IdeaProjects\\homework2\\src\\TxtToList\\user.json";

            List<User> users = readUsersFromFile(inputFile);

            writeUsersToJson(users, outputFile);

            System.out.println("Conversion successful. Please check the user.json file for the output.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
