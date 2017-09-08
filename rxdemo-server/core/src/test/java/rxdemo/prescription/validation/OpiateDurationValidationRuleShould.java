package rxdemo.prescription.validation;

import org.junit.Before;
import org.junit.Test;
import rxdemo.prescription.Prescription;
import rxdemo.vendordata.DrugDatabase;

import static org.junit.Assert.*;

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

      assertFalse(result.isValid());
   }

   @Test
   public void returnAppropriateMessageAndComponentIfDurationInvalid() {
      rx.setDuration("31 days");
      rx.setDrug(DrugDatabase.getDrugByName("oxycodone"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertEquals(OpiateDurationValidationRule.MESSAGE, result.getMessage());
      assertEquals(1, result.getComponentsInvalid().size());
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DURATION));
   }

   @Test
   public void returnInvalidResultForOpioidWithZeroDuration() {
      rx.setDuration("unknown");
      rx.setDrug(DrugDatabase.getDrugByName("oxycodone"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertFalse(result.isValid());
      assertEquals(OpiateDurationValidationRule.MESSAGE, result.getMessage());
   }

   @Test
   public void returnValidResultForNonOpioid() {
      rx.setDuration("31 days");
      rx.setDrug(DrugDatabase.getDrugByName("aspirin"));

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertTrue(result.isValid());
      assertNull(result.getMessage());
   }

   @Test
   public void returnValidIfDrugNotIndicatedYet() {
      rx.setDuration("31 days");
      rx.setDrug(null);

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertTrue(result.isValid());
      assertNull(result.getMessage());
   }

}