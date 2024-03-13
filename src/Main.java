import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution datain_50_1  = new Solution("datain_50.txt");
        Solution datain_50_2  = new Solution("datain_50.txt");
        Solution datain_100_1  = new Solution("datain_100.txt");
        Solution datain_100_2  = new Solution("datain_100.txt");
        Solution datain_200_1  = new Solution("datain_200.txt");
        Solution datain_200_2  = new Solution("datain_200.txt");

        /*
        Do pierwszego losowanie zimportowalem oczywiscie "java.util.Random" poniewaz byl to
        najskuteczniejszy sposob na nasze pierwsze rozwiazanie

        Natomiast w drugim rozwiazaniu wybralem heap sorta poniewaz byl on omawiany na naszych lekcjach i jestem z nim dosyc
        zaprzyjazniony oraz wykonywal 0(n log n) tak jak bylo napisane w poleceniu


         */

        datain_50_1.startRandomSolution();
        datain_100_1.startRandomSolution();
        datain_200_1.startRandomSolution();

        /*
        Porownujac oba wyniki wynioslem, ze w losowym trybie jest minimalnie mniej dopasowan
        co prowadzi do mniejszego zarobku dla naszego kochanego Marka Cukierbega.

         */

        datain_50_2.startHeapSortSolution();
        datain_100_2.startHeapSortSolution();
        datain_200_2.startHeapSortSolution();
    }
}
