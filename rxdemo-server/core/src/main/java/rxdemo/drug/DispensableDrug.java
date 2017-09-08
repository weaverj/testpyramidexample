package rxdemo.drug;

import rxdemo.vendordata.EDrugClassification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DispensableDrug {
   private int drugId;
   private String name;
   private Set<EDrugClassification> classifications;

   public DispensableDrug(int drugId, String name, EDrugClassification...classifications) {
      this.drugId = drugId;
      this.name = name;
      this.classifications = new HashSet<>();
      this.classifications.addAll(Arrays.asList(classifications));
   }

   public int getDrugId() {
      return drugId;
   }

   public String getName() {
      return name;
   }

   public Set<EDrugClassification> getClassifications() {
      return classifications;
   }

   public boolean isFreeText() {
      return false;
   }
}
