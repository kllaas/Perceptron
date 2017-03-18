import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alexey on 18.03.17.
 */
public class Main {

    public static void main(String[] args) {
        Perceptron testPerceptron = new Perceptron();

        String fileName = "/home/alexey/Programming/Projects/IntelijProjects/Perceptron/src/data05.xlsx";

        ArrayList<DataItem> dataSet = Parcer.parse(fileName);

        testPerceptron.train(dataSet, 0.2, 0.1, 100, 0);

        TestUtils.testData(testPerceptron, fileName);
    }

}
