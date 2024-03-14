import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); //Открываем поток чтения с консоли
        System.out.println("Введите полный путь до файла.");


        try(BufferedReader reader = new BufferedReader(new FileReader(console.nextLine()))) { //EXAMPLE: input.txt
            HashMap<Character, Integer> dictionary = new HashMap<>(); //Создаём HasMap'у в которой будут храняться пары ключ-значение (Символ-Количество)
            while (reader.ready()) {
                String line = reader.readLine();
                for(int i = 0; i < line.length(); i++) {
                    dictionary.put(line.charAt(i), dictionary.getOrDefault(line.charAt(i), 0) + 1); //Здесь записываем их в хешмапу
                }
            }

            System.out.println("Введите полный путь до файла-вывода");
            FileWriter writer = new FileWriter(console.nextLine());
            for(Character x : dictionary.keySet()){
                writer.write(x + " = " + dictionary.get(x) + "\n"); //Красиво выводим в файлик. EXAMPLE: output.txt
            }
            writer.close();

        }
        catch (FileNotFoundException e) { //Обработка исключений
            System.out.println("Файл не найден!");
        }
        catch (IOException e) {
            System.out.println("Упс! Какая-то проблема с чтением/записью файла.");
            throw new RuntimeException(e);
        }
    }
}