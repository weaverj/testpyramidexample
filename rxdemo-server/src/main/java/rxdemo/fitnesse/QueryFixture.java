package rxdemo.fitnesse;

import java.util.ArrayList;
import java.util.List;

public class QueryFixture {

   protected List<String> buildColumn(String columnName, String value) {
      ArrayList<String> column = new ArrayList<>();
      column.add(columnName);
      column.add(value);
      return column;
   }
}
