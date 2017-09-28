package rxdemo.prescription.validation;

import org.junit.Test;
import rxdemo.prescription.Prescription;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RxValidatorShould {

   @Test
   public void returnNoResultsIfRulesProvidedIsNull() {
      RxValidator validator = new RxValidator(null);

      List<RxValidationResult> results = validator.validatePrescription(
         new Prescription());

      assertTrue(results.isEmpty());
   }

   @Test
   public void returnNoResultsIfRulesProvidedIsEmpty() {
      RxValidator validator = new RxValidator(new ArrayList<>());

      List<RxValidationResult> results = validator.validatePrescription(
         new Prescription());

      assertTrue(results.isEmpty());
   }


   @Test
   public void returnResultForEachRule() {
      ArrayList<IRxValidationRule> rules = new ArrayList<>();
      rules.add(buildValidationRule());
      rules.add(buildValidationRule());
      RxValidator validator = new RxValidator(rules);

      List<RxValidationResult> results = validator.validatePrescription(
         new Prescription());

      assertEquals(2, results.size());

   }

   private IRxValidationRule buildValidationRule() {
      IRxValidationRule rule = mock(IRxValidationRule.class);
      when(rule.validateAgainstRule(any(Prescription.class))).thenReturn(
         new RxValidationResult());
      return rule;
   }

}