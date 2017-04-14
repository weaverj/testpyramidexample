package rxdemo.fitnesse;

import rxdemo.drug.DispensableDrug;
import rxdemo.drug.OpiatesDrugConcept;
import rxdemo.vendordata.DrugDatabase;
import rxdemo.vendordata.EDrugClassification;

import java.util.ArrayList;
import java.util.List;

public class TherapeuticClassesConsideredOpiates extends QueryFixture {

   public List<List<List<String>>> query() {
      return asList(OpiatesDrugConcept.getClassificationsInConcept());
   }

   private List<List<List<String>>> asList(List<EDrugClassification> opiateClasses) {
      ArrayList<List<List<String>>> tableList = new ArrayList<>();
      for (EDrugClassification classification : opiateClasses) {
         tableList.add(buildRow(classification));
      }
      return tableList;
   }

   private ArrayList<List<String>> buildRow(EDrugClassification classification) {
      ArrayList<List<String>> rowList = new ArrayList<>();
      rowList.add(buildColumn("Therapeutic Class Code",
         String.valueOf(classification.getEtcClassificationCode())));
      rowList.add(buildColumn("Description", classification.getDescription()));
      rowList.add(buildColumn("Drugs Included", buildDrugsList(classification.getEtcClassificationCode())));
      return rowList;
   }

   private String buildDrugsList(int etcClassificationCode) {
      List<DispensableDrug> drugsInClass = DrugDatabase.getDrugsInClassification(etcClassificationCode);
      StringBuffer buffer = new StringBuffer();
      if (drugsInClass.isEmpty()) {
         return "";
      }
      buffer.append("<ul>");
      for (DispensableDrug drug : drugsInClass) {
         buffer.append("<li>").append(drug.getName()).append("</li>");
      }
      buffer.append("</ul>");
      return buffer.toString();
   }
}
