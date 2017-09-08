package rxdemo.fitnesse;

import rxdemo.drug.DispensableDrug;

import java.util.List;

public class OpiatesClassRow {

   private int classCode;
   private String description;
   private List<DispensableDrug> includedDrugs;

   public int getClassCode() {
      return classCode;
   }

   public String getDescription() {
      return description;
   }

   public List<DispensableDrug> getIncludedDrugs() {
      return includedDrugs;
   }
}
