package rxdemo.prescription.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rxdemo.prescription.Prescription;
import rxdemo.vendordata.DrugDatabase;

public class OpiateDurationValidationRuleShould {

   private Prescription rx;
   private OpiateDurationValidationRule rule;

   @Before
   public void setUp() {
      rx = new Prescription();
      rule = new OpiateDurationValidationRule();
   }

   @Test
   public void returnInvalidResultForOpioidOverDurationLimit() {
      rx.setDuration("31 days");
      rx.setDrug(DrugDatabase.getDrugByName("oxycodone"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      Assert.assertFalse(result.isValid());
      Assert.assertEquals(OpiateDurationValidationRule.MESSAGE, result.getMessage());
   }

   @Test
   public void returnInvalidResultForOpioidWithZeroDuration() {
      rx.setDuration("unknown");
      rx.setDrug(DrugDatabase.getDrugByName("oxycodone"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      Assert.assertFalse(result.isValid());
      Assert.assertEquals(OpiateDurationValidationRule.MESSAGE, result.getMessage());
   }

   @Test
   public void returnValidResultForNonOpioid() {
      rx.setDuration("31 days");
      rx.setDrug(DrugDatabase.getDrugByName("aspirin"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      Assert.assertTrue(result.isValid());
      Assert.assertNull(result.getMessage());
   }

}