import java.util.ArrayList;

/**
 * Created by alexey on 18.03.17.
 */
public class Main {

    public static void main(String[] args) {
        Perceptron testPerceptron = new Perceptron();

        String learningData = "/home/alexey/Programming/Projects/IntelijProjects/Perceptron/src/data05.xlsx";
        String testData = "/home/alexey/Programming/Projects/IntelijProjects/Perceptron/src/test_data.xlsx";

        ArrayList<DataItem> dataSet = Parcer.parse(learningData);

        testPerceptron.train(dataSet, 0.2, 0.1, 1000, 0);

        TestUtils.testData(testPerceptron, testData);
    }

}
