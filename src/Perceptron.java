import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alexey on 18.03.17.
 */

public class Perceptron {

    private double[] weights;

    // activation threshold
    private double threshold;

    public double[] getWeights() {
        return weights;
    }

    public void train(ArrayList<DataItem> dataSet, double threshold, double learningRate, int epoch, double epsilon) {
        this.threshold = threshold;

        if (dataSet.size() == 0)
            return;

        int paramsCount = dataSet.get(0).getParams().size();

        initWeight(paramsCount);

        System.out.println("Learning process...");

        System.out.printf("Starting weight: w1 = %f, w2 = %f\n", weights[0], weights[1]);

        for (int i = 0; i < epoch; i++) {
            double totalError = 0;

            for (DataItem item : dataSet) {
                double output = output(item);
                double error = item.getDataType() - output;

                for (int k = 0; k < paramsCount; k++) {
                    double delta = learningRate * item.getParams().get(k) * error;
                    weights[k] += delta;
                }

                totalError += Math.abs(error);
            }

            System.out.printf("Epoch: %d\n", i + 1);
            System.out.printf("Weight: w1 = %f, w2 = %f\n", weights[0], weights[1]);
            System.out.printf("Total error: %f\n", totalError);

            if (Math.abs(totalError) <= epsilon)
                break;
        }

        System.out.println("Learning process end.");
    }

    private void initWeight(int paramsCount) {
        weights = new double[paramsCount];

        Random random = new Random();

        for (int i = 0; i < paramsCount; i++) {
            weights[i] = random.nextDouble();
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
