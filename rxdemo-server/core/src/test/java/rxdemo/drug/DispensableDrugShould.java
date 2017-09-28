package rxdemo.drug;

import org.junit.Assert;
import org.junit.Test;
import rxdemo.vendordata.EDrugClassification;

public class DispensableDrugShould {

   @Test
   public void beConstructableWithListOfClassifications() {
      DispensableDrug drug = new DispensableDrug(1, "testdrug",
         EDrugClassification.ANALGESIC, EDrugClassification.ANTIANXIETY);
      Assert.assertEquals(1, drug.getDrugId());
      Assert.assertEquals("testdrug", drug.getName());
      Assert.assertEquals(2, drug.getClassifications().size());
      Assert.assertTrue(drug.getClassifications().contains(EDrugClassification.ANALGESIC));
      Assert.assertTrue(drug.getClassifications().contains(EDrugClassification.ANTIANXIETY));
   }

}