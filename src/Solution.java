import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    String fileName;
    int[] Array;
    Client[] clients;

    public Solution(String fileName) {
        this.fileName = fileName;
        readData();
    }

    public void readData() {
        String path = "DataIn/" + this.fileName;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));

            String obj = reader.readLine();
            int lenght = Integer.parseInt(obj.split(" ")[0]);
            reader.close();

            Array = new int[lenght];
            for (int i = 1; i <= Array.length; i++) {
                Array [i - 1] = Integer.parseInt(obj.split(" ")[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startRandomSolution() {
        RandomSolution randomOne = new RandomSolution(Array);

        randomOne.meeting();
    }
    public void startHeapSortSolution() {
        clients = new Client[Array.length];
        for (int i = 0; i < Array.length; i++) {
            clients[i] = new Client(i + 1, Array[i]);
        }

        HeapSortSolution heapSortSolution = new HeapSortSolution(clients);
        heapSortSolution.meeting();
    }
}