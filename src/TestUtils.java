import java.util.ArrayList;

/**
 * Created by alexey on 18.03.17.
 */
public class TestUtils {

    public static void testData(Perceptron perceptron, String fileName) {

        ArrayList<DataItem> data = Parcer.parse(fileName);

        int summ = 0;
        int output;

        for (int i = 0; i < data.size(); i++) {
            output = perceptron.output(data.get(i));

            System.out.printf("%d/%d :", i + 1, data.size());

            if (output == data.get(i).getDataType()) {
                summ++;
                System.out.println(")");
            } else {
                System.out.printf("( expected: %d, found: %d\n", data.get(i).getDataType(), output);
            }

        }

        System.out.printf("\nCorrectly: %1.02f%%\n", (double) summ / data.size() * 100);
        System.out.printf("Weight: w1 = %f, w2 = %f\n", perceptron.getWeights()[0], perceptron.getWeights()[1]);
    }
}
