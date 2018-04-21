import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Armaghan on 4/10/2018.
 */
public class InputGenerator {
    String[] randoms = new String[100];
    String[] first100 = new String[100];
    String[] allAdds = new String[500];

    public InputGenerator(int i) {
            writeToFile(i);
            //readFromFile();
    }

    private void writeToFile(int co) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("result"+ co + ".txt"));
            for (int v = 0; v < 100; v++) {
                String address = "";
                for (int i = 0; i < 32; i++) {
                    address = address.concat(binNumber());
                }

                randoms[v] = address;
            }
            generateOthers();
            for (int i = 0; i < 500; i++) {
                bw.write(allAdds[i]);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateOthers() {
        int x = 5;
        for (int i = 0; i < 100/x ; i++) {
            first100[i * x] = randoms[i];
            for (int j = i * x + 1; j < (i + 1) * x; j++) {
                first100[j] = plusOne(first100[j - 1]);

            }
        }
        for (int i = 0; i < x; i++) {
            boolean b[] = new boolean[100/x];
            for (int j = 0; j < b.length; j++) {
                b[i] = false;
            }
            Random rg;
            int n;

            for (int j = 0; j < 100/x; j++) {
                rg = new Random();
                n = rg.nextInt(100/x);
                while (b[n]) {
                    rg = new Random();
                    n = rg.nextInt(100/x);
                }
                for (int k = 0; k < x; k++) {
                    allAdds[i * 100 + x * j + k] = first100[n*x+k];
                }
            }
        }
    }

    private String plusOne(String s) {
        long l = Long.parseLong(s, 2);
        l += 1;
        String o = Long.toBinaryString(l);
        if (o.length() < 32) {
            String con = "";
            for (int i = 0; i < 32 - o.length(); i++) {
                con = con.concat("0");
            }
            o = con.concat(o);
        }
        return o;
    }

    private String binNumber() {
        Random rg = new Random();
        int n = rg.nextInt(2);
        return Integer.toBinaryString(n);
    }

    private void readFromFile() {
        int i = 0;
        try {
            Scanner fileread = new Scanner(new File("input1.txt"));
            do {
                allAdds[i] = fileread.nextLine();
                i++;
            } while (fileread.hasNext());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
