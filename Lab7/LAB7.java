import java.io.*;
import java.util.*;

public class LAB7 {
    static float mean(float[] arr) {
        float sum = 0.0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        float a = sum / arr.length;
        return a;
    }

    static float[] sort(float[] arr) {
        int n = arr.length;
        float temp = 0.0f;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    static float median(float[] arr) {
        float[] newarr = sort(arr);
        int n = newarr.length;
        if (n / 2 == 0) {
            return newarr[n / 2];
        } else {
            float val = (newarr[(n - 1) / 2] + newarr[n / 2]) / 2.0f;
            return val;
        }

    }

    static float Mode(float[] arr) {
        float maxvalue = 0.0f;
        int maxcount = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > maxcount) {
                maxcount = count;
                maxvalue = arr[i];

            }
        }
        return maxvalue;
    }

    static float min(float[] arr) {
        float[] newarr = sort(arr);
        return newarr[0];
    }

    static float max(float[] arr) {
        float[] newarr = sort(arr);
        int b = newarr.length - 1;
        return newarr[b];
    }

    static void display(String[][] iris, int count, String pathname) {
        if (count > 100) {
            float[] SL = new float[count];
            float[] SW = new float[count];
            float[] PL = new float[count];
            float[] PW = new float[count];
            String[] species = new String[count];
            for (int i = 1; i <= count; i++) {
                SL[i - 1] = Float.parseFloat(iris[i][1]);
                SW[i - 1] = Float.parseFloat(iris[i][2]);
                PL[i - 1] = Float.parseFloat(iris[i][3]);
                PW[i - 1] = Float.parseFloat(iris[i][4]);
                species[i - 1] = iris[i][5];
            }
            String[] arr1 = { "features ", "min ", "max ", "mean ", "median ", "mode " };
            String[] arr2 = { "Sepal Lenght ", min(SL) + "", max(SL) + "", mean(SL) + "", median(SL) + "",
                    Mode(SL) + "" };
            String[] arr3 = { "Sepal width ", min(SW) + "", max(SW) + "", mean(SW) + "", median(SW) + "",
                    Mode(SW) + "" };
            String[] arr4 = { "Petal Lenght", min(PL) + "", max(PL) + "", mean(PL) + "", median(PL) + "",
                    Mode(PL) + "" };
            String[] arr5 = { "Sepal Width", min(PW) + "", max(PW) + "", mean(PW) + "", median(PW) + "",
                    Mode(PW) + "" };
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));
            System.out.println(Arrays.toString(arr4));
            System.out.println(Arrays.toString(arr5));

        }
        if (count < 100) {
            float[] SL = new float[count];
            float[] SW = new float[count];
            float[] PL = new float[count];
            float[] PW = new float[count];
            String[] species = new String[count];
            for (int i = 0; i < count; i++) {
                SL[i] = Float.parseFloat(iris[i][1]);
                SW[i] = Float.parseFloat(iris[i][2]);
                PL[i] = Float.parseFloat(iris[i][3]);
                PW[i] = Float.parseFloat(iris[i][4]);
                species[i] = iris[i][5];
            }
            String[] arr1 = { "features ", "min ", "max ", "mean ", "median ", "mode " };
            String[] arr2 = { "Sepal Lenght ", min(SL) + "", max(SL) + "", mean(SL) + "", median(SL) + "",
                    Mode(SL) + "" };
            String[] arr3 = { "Sepal width ", min(SW) + "", max(SW) + "", mean(SW) + "", median(SW) + "",
                    Mode(SW) + "" };
            String[] arr4 = { "Petal Lenght", min(PL) + "", max(PL) + "", mean(PL) + "", median(PL) + "",
                    Mode(PL) + "" };
            String[] arr5 = { "Sepal Width", min(PW) + "", max(PW) + "", mean(PW) + "", median(PW) + "",
                    Mode(PW) + "" };
            try {
                File newfile = new File(pathname);
                FileWriter wr = new FileWriter(newfile, true);
                wr.write("5-point Summary" + "\n" + species[0] + "\n");
                wr.write(Arrays.toString(arr1) + "\n" + Arrays.toString(arr2) + "\n" + Arrays.toString(arr3) + "\n"
                        + Arrays.toString(arr4)
                        + "\n" + Arrays.toString(arr5) + "\n");
                wr.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());

            }
        }

    }

    public static void main(String[] args) {
        String[][] iris = new String[1000][6];
        int count = 0;
        String[][] irisSet = new String[1000][6];
        int countSet = 0;
        String[][] irisVers = new String[1000][6];
        int countvers = 0;
        String[][] irisVirg = new String[1000][6];
        int countvirg = 0;

        try {
            File file = new File("D:/a Telegram/Iris.csv");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String csv = scan.nextLine();
                String[] arr = csv.split(",");
                iris[count] = arr;
                count++;
                if ("Iris-setosa".equals(arr[5])) {
                    irisSet[countSet] = arr;
                    countSet++;
                }
                if ("Iris-versicolor".equals(arr[5])) {
                    irisVers[countvers] = arr;
                    countvers++;
                }
                if ("Iris-virginica".equals(arr[5])) {
                    irisVirg[countvirg] = arr;
                    countvirg++;
                }

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            File newfile = new File("summary.txt");
            FileWriter wr = new FileWriter(newfile, true);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String pathname = "summary.txt";
        display(iris, count - 1, pathname);
        display(irisSet, countSet, pathname);
        display(irisVers, countvers, pathname);
        display(irisVirg, countvirg, pathname);

    }
}