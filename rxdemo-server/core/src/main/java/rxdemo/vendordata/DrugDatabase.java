package rxdemo.vendordata;

import rxdemo.drug.DispensableDrug;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vendor drug database rather than application code.
 */
public class DrugDatabase {
   private static List<DispensableDrug> drugsInDatabase;

   static {
      drugsInDatabase = new ArrayList<>();
      loadDrugData();
   }

   public static List<DispensableDrug> getDrugsAvailableForPrescribing() {
      return drugsInDatabase;
   }

   public static List<DispensableDrug> getDrugsInClassification(int classCode) {
      ArrayList<DispensableDrug> matchingDrugs = new ArrayList<>();
      for (DispensableDrug drug : drugsInDatabase) {
         for (EDrugClassification classification : drug.getClassifications()) {
            if (classCode == classification.getEtcClassificationCode()) {
               matchingDrugs.add(drug);
               break;
            }
         }
      }
      return matchingDrugs;
   }

   public static DispensableDrug getDrugByName(String name) {
      for (DispensableDrug dispensableDrug : drugsInDatabase) {
         if (name.equals(dispensableDrug.getName())) {
            return dispensableDrug;
         }
      }
      return null;
   }

   private static void loadDrugData() {
      drugsInDatabase = new ArrayList<>();
      drugsInDatabase.add(new DispensableDrug(100, "aspirin",
         new EDrugClassification[]{EDrugClassification.ANALGESIC, EDrugClassification.PLATELET_AGGREGATION_INHIBITORS}));
      drugsInDatabase.add(new DispensableDrug(200, "bactrim",
         new EDrugClassification[]{EDrugClassification.ANTIBACTERIAL}));
      drugsInDatabase.add(new DispensableDrug(300, "diazepam",
         new EDrugClassification[]{EDrugClassification.ANTIANXIETY}));
      drugsInDatabase.add(new DispensableDrug(400, "fluticasone",
         new EDrugClassification[]{EDrugClassification.NASAL_CORTICOSTEROIDS}));
      drugsInDatabase.add(new DispensableDrug(500, "folic acid",
         new EDrugClassification[]{EDrugClassification.VITAMINS_WATER_SOLUBLE}));
      drugsInDatabase.add(new DispensableDrug(600, "hydrocodone-chlorpheniramine",
         new EDrugClassification[]{EDrugClassification.NARCOTIC_ANTHISTAMINE}));
      drugsInDatabase.add(new DispensableDrug(700, "lisinopril",
         new EDrugClassification[]{EDrugClassification.ACE_INHIBITORS}));
      drugsInDatabase.add(new DispensableDrug(750, "lorazepam",
         new EDrugClassification[]{EDrugClassification.ANTIANXIETY}));
      drugsInDatabase.add(new DispensableDrug(800, "methadone",
         new EDrugClassification[]{EDrugClassification.ANALGESICS_NARCOTIC}));
      drugsInDatabase.add(new DispensableDrug(900, "oxycodone",
         new EDrugClassification[]{EDrugClassification.ANALGESICS_NARCOTIC}));
      drugsInDatabase.add(new DispensableDrug(1000, "simvastatin",
         new EDrugClassification[]{EDrugClassification.ANTIHYPERLIPIDEMICS}));

      drugsInDatabase.add(new DispensableDrug(1100, "cowbell", new EDrugClassification[] {EDrugClassification.ANALGESIC}));
      drugsInDatabase.add(new DispensableDrug(1200, "more cowbell", new EDrugClassification[] {EDrugClassification.ANALGESIC}));
   }


}
