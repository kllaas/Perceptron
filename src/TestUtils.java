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

            if (output == data.get(i).getDataType())
                summ++;

            System.out.printf("%d/%d - expected: %d, found: %d\n", i, data.size(), output, data.get(i).getDataType());
        }

        System.out.printf("\nCorrectly: %1.02f%%", (double) summ / data.size() * 100);
    }

}
