import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "src/input.txt";
        int wordCount = wordCounter("src/input.txt");
        System.out.println("Word count: " + wordCount);
        String longestWord = findLongestWord("src/input.txt");
        System.out.println("Самое длинное слово: " + longestWord);
        wordFrequency(filename);

    }
    public static int wordCounter(String filename) {
        int fruitCount = 0;
        try{
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                scanner.next();
                fruitCount++;
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
        return fruitCount;
    }
    public static String findLongestWord(String filename){
        String longestWord = "";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String word = scanner.next();
            if(word.length() > longestWord.length()) {
                longestWord = word;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
        return longestWord;
    }
    public static void wordFrequency(String filename){
        HashMap<String, Integer> fruitBasket = new HashMap<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (fruitBasket.containsKey(word)){
                    fruitBasket.put(word, fruitBasket.get(word) + 1);
                } else {
                    fruitBasket.put(word, 1);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("File not found: " + filename);
            e.printStackTrace();
        }
        for (String word : fruitBasket.keySet()){
            int count = fruitBasket.get(word);
            System.out.println(word + ": " + count);
        }
    }
}