import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alexey on 18.03.17.
 */

public class Perceptron {

    private double[] weights;

    // activation threshold
    private double threshold;

    public void train(ArrayList<DataItem> dataSet, double threshold, double learningRate, int epoch, double epsilon) {
        this.threshold = threshold;

        if (dataSet.size() == 0)
            return;

        int paramsCount = dataSet.get(0).getParams().size();
        int size = dataSet.size();

        initWeight(paramsCount);

        for (int i = 0; i < epoch; i++) {
            int totalError = 0;

            for (int j = 0; j < size; j++) {
                int output = output(dataSet.get(j));
                int error = dataSet.get(j).getDataType() - output;

                for (int k = 0; k < paramsCount; k++) {
                    double delta = learningRate * dataSet.get(j).getParams().get(k) * error;
                    weights[k] += delta;
                }

                totalError += error;
            }

            if (totalError <= epsilon)
                break;
        }

    }

    private void initWeight(int paramsCount) {
        weights = new double[paramsCount];

        Random r = new Random();

        for (int i = 0; i < paramsCount; i++) {
            weights[i] = r.nextDouble();
        }
    }

    public int output(DataItem input) {
        double sum = 0.0;

        for (int i = 0; i < input.getParams().size(); i++) {
            sum += weights[i] * input.getParams().get(i);
        }

        if (sum > threshold)
            return 1;
        else
            return 0;
    }

}
