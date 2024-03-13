import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSolution {
    int[] dataArray;
    private float counter;
    List<String> resultList = new ArrayList<>();

    public RandomSolution(int[] dataArray) {
        this.dataArray = dataArray;
    }

    public void results() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results/results-" + dataArray.length + "-1.txt"));
            writer.write(String.valueOf((int)counter));
            System.out.println((int)counter);
            writer.newLine();
            for (int i = 0; i < resultList.size(); i++) {
                writer.write(resultList.get(i));
                System.out.println(resultList.get(i));

                if (i < resultList.size() - 1) {
                    writer.write(" ");
                    System.out.println(" ");
                }

            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int useToken() {
        Random use = new Random();
        int rValue = use.nextInt(dataArray.length);
        return rValue;
    }

    public boolean Alone() {
        int clientsWithTokens = dataArray.length;
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == 0) {
                clientsWithTokens--;
            }
        }
        return clientsWithTokens > 1;
    }


    public void meeting() {
        int clientOne;
        int clientTwo;

        while (Alone()) {
            clientOne = useToken();
            clientTwo = useToken();
            while (clientOne == clientTwo || dataArray[clientOne] <= 0 || dataArray[clientTwo] <= 0) {
                clientOne = useToken();
                clientTwo = useToken();
            }

            dataArray[clientOne]--;
            dataArray[clientTwo]--;
            counter++;
            resultList.add((clientOne + 1) + "," + (clientTwo + 1));
        }
        results();
    }
}
