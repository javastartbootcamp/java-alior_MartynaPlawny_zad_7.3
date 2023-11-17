import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        readFile();
        iterateAfterMap();
        mapOfNumbers.clear();
    }

    static Map<Integer, Integer> mapOfNumbers = new HashMap<>();

    static void iterateAfterMap() {
        for (Map.Entry<Integer, Integer> entry : mapOfNumbers.entrySet()) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }

    static void readFile() {
        String fileName = "liczby.txt";

        FileReader fileReader;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                if (mapOfNumbers.containsKey(Integer.valueOf(nextLine))) {
                    mapOfNumbers.put(Integer.valueOf(nextLine), mapOfNumbers.get(Integer.valueOf(nextLine)) + 1);
                } else {
                    mapOfNumbers.put(Integer.valueOf(nextLine), 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}