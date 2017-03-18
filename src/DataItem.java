import java.util.ArrayList;

/**
 * Created by alexey on 18.03.17.
 */
public class DataItem {

    private ArrayList<Double> params = new ArrayList<>();

    private int dataType;

    public DataItem(ArrayList<Double> params, int dataType) {
        this.params = params;
        this.dataType = dataType;
    }

    public DataItem(ArrayList<Double> params) {
        this.params = params;
    }

    public DataItem() {

    }

    public ArrayList<Double> getParams() {
        return params;
    }

    public void setParams(ArrayList<Double> params) {
        this.params = params;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
