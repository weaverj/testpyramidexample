package rxdemo.drug;

import rxdemo.vendordata.EDrugClassification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OpiatesDrugConcept {

   private static EDrugClassification[] opiateClasses = new EDrugClassification[]{
      EDrugClassification.ANTIANXIETY,
      EDrugClassification.ANALGESICS_NARCOTIC,
      EDrugClassification.NARCOTIC_ANTHISTAMINE};

   public static List<EDrugClassification> getClassificationsInConcept() {
      return Arrays.asList(opiateClasses);
   }

   public static boolean isDrugInConcept(DispensableDrug drug) {
      if (drug == null) {
         return false;
      }
      HashSet<EDrugClassification> opiateClassesForThisDrug = new HashSet<>(
         drug.getClassifications());
      opiateClassesForThisDrug.retainAll(Arrays.asList(opiateClasses));
      return !opiateClassesForThisDrug.isEmpty();
   }
}
