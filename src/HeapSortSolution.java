import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HeapSortSolution {
    Client[] clients;
    private float counter;
    List<String> resultsList = new ArrayList<>();



    public HeapSortSolution(Client[] clients) {
        this.clients = clients;
    }

    public void meeting(){
        heapSort();

        int clientOne;
        int clientTwo;

        while (Alone()) {
            heapSort();

            clientOne = clients[0].getID();
            clientTwo = clients[1].getID();



            clients[0].payToken();
            clients[1].payToken();
            counter++;

            resultsList.add(clientOne + "," + clientTwo);
        }
        results();
    }



    public void heapSort(){

        for (int i = clients.length / 2 - 1; i >= 0 ; i--) {
            heap(clients, i, clients.length);
        }

        for (int i = clients.length - 1; i >= 0 ; i--) {
            Client tmp = clients[0];
            clients[0] = clients[i];
            clients[i] = tmp;

            heap(clients, 0, i);
        }
    }

    public void heap(Client[] array, int index, int arrLength){
        int currentIndex = index;
        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;

        if (leftNode < arrLength && array[leftNode].getTokens() < array[currentIndex].getTokens()){
            currentIndex = leftNode;
        }
        if (rightNode < arrLength && array[rightNode].getTokens() < array[currentIndex].getTokens()){
            currentIndex = rightNode;
        }

        if (currentIndex != index) {
            Client tmp = array[index];
            array[index] = array[currentIndex];
            array[currentIndex] = tmp;

            heap(array, currentIndex, arrLength);
        }
    }

    public boolean Alone(){
        int clientsWithCoins = clients.length;
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getTokens() == 0){
                clientsWithCoins--;
            }
        }
        return clientsWithCoins > 1;
    }


    public void results() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results/results-" + clients.length + "-2.txt"));

            writer.write(String.valueOf((int)counter));
            System.out.println((int)counter);
            writer.newLine();
            for (int i = 0; i < resultsList.size(); i++) {
                writer.write(resultsList.get(i));
                System.out.print(resultsList.get(i));
                if (i < resultsList.size() - 1){
                    writer.write(" ");
                    System.out.print(" ");
                }
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
