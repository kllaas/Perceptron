import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by alexey on 18.03.17.
 */
public class Parcer {

    public static ArrayList<DataItem> parse(String name) {

        ArrayList<DataItem> result = new ArrayList<>();

        Workbook workbook = null;

        try {
            workbook = WorkbookFactory.create(new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            result.add(getItemFromRow(row));
        }

        return result;
    }

    private static DataItem getItemFromRow(Row row) {
        DataItem item = new DataItem();

        for (Cell cell : row) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    item.getParams().add(Double.parseDouble(cell.getStringCellValue()));
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    item.setDataType((int) cell.getNumericCellValue());
                    break;
            }
        }

        return item;
    }


}
