package rxdemo.prescription.validation;

import org.junit.Before;
import org.junit.Test;
import rxdemo.drug.DispensableDrug;
import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.ERxComponent;
import rxdemo.prescription.validation.RequiredRxFieldsValidationRule;
import rxdemo.prescription.validation.RxValidationResult;
import rxdemo.vendordata.EDrugClassification;

import static org.junit.Assert.*;

public class RequiredRxFieldsValidationRuleShould {

   private RequiredRxFieldsValidationRule rule;
   private Prescription rx;

   @Before
   public void setUp() {
      rule = new RequiredRxFieldsValidationRule();
      rx = new Prescription();
      DispensableDrug drug = new DispensableDrug(10, "drug", new EDrugClassification[] {EDrugClassification.ACE_INHIBITORS});
      rx.setDrug(drug);
   }

   @Test
   public void returnValidResultForRxWithAllFields() {
      rx.setDoseAmount("1");
      rx.setDoseUnit("tablet");
      rx.setFrequency("twice daily");
      rx.setRoute("oral");
      rx.setDuration("10 days");

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertTrue(result.isValid());
   }

   @Test
   public void returnInvalidResultForRxWithOneRequiredFieldMissing() {
      rx.setDoseAmount("1");
      rx.setFrequency("twice daily");
      rx.setRoute("oral");
      rx.setDuration("10 days");

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertFalse(result.isValid());
      assertEquals(1, result.getComponentsInvalid().size());
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DOSE_UNIT));
      assertEquals("The following fields are required: Dose Unit.", result.getMessage());
   }

   @Test
   public void returnInvalidResultForRxWithMultipleRequiredFieldsMissing() {
      rx.setDoseAmount("1");
      rx.setRoute("oral");
      rx.setDuration("10 days");

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertFalse(result.isValid());
      assertEquals(2, result.getComponentsInvalid().size());
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DOSE_UNIT));
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.FREQUENCY));
      assertEquals("The following fields are required: Dose Unit, Frequency.", result.getMessage());
   }

   @Test
   public void returnsInvalidIfDrugMissing() {
      rx.setDrug(null);
      rx.setDoseAmount("1");
      rx.setDoseUnit("tablet");
      rx.setFrequency("twice daily");
      rx.setRoute("oral");
      rx.setDuration("10 days");

      RxValidationResult result = rule.validateAgainstRule(rx);

      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DRUG));
      assertEquals("The following fields are required: Drug.", result.getMessage());
   }

}