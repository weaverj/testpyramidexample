package rxdemo.drug;

import org.junit.Assert;
import org.junit.Test;
import rxdemo.vendordata.EDrugClassification;

public class OpiatesDrugConceptShould {

   @Test
   public void identifyDrugInConcept() {
      DispensableDrug drug = new DispensableDrug(1, "diazepam",
         EDrugClassification.ANTIANXIETY);
      Assert.assertTrue(OpiatesDrugConcept.isDrugInConcept(drug));
   }

   @Test
   public void identifiesDrugInConceptWhenDrugHasMultipleClasses() {
      DispensableDrug drug = new DispensableDrug(1, "fake drug",
         EDrugClassification.ANTIBACTERIAL,
         EDrugClassification.ANTIANXIETY);
      Assert.assertTrue(OpiatesDrugConcept.isDrugInConcept(drug));
   }

   @Test
   public void rejectDrugNotInConcept() {
      DispensableDrug drug = new DispensableDrug(1, "fluticasone",
         EDrugClassification.NASAL_CORTICOSTEROIDS);
      Assert.assertFalse(OpiatesDrugConcept.isDrugInConcept(drug));
   }

   @Test
   public void rejectDrugIfNull() {
      Assert.assertFalse(OpiatesDrugConcept.isDrugInConcept(null));
   }

}