import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Iris {
    public static void main(String[] args) {
        String csvFile = "Iris.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        // arrays to store the values of the four attributes for each sample
        ArrayList<Double> sepalLength = new ArrayList<>();
        ArrayList<Double> sepalWidth = new ArrayList<>();
        ArrayList<Double> petalLength = new ArrayList<>();
        ArrayList<Double> petalWidth = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // split the line by comma
                String[] data = line.split(cvsSplitBy);

                // add the attribute values to the appropriate array
                sepalLength.add(Double.parseDouble(data[1]));
                sepalWidth.add(Double.parseDouble(data[2]));
                petalLength.add(Double.parseDouble(data[3]));
                petalWidth.add(Double.parseDouble(data[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}   
        

  