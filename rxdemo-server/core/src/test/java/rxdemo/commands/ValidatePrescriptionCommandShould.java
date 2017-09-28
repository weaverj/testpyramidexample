package rxdemo.commands;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.ERxComponent;
import rxdemo.prescription.validation.IRxValidationRule;
import rxdemo.prescription.validation.RxValidationResult;
import rxdemo.prescription.validation.RxValidator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ValidatePrescriptionCommandShould {

   private IRxValidationRule alwaysValidRule;
   private IRxValidationRule invalidRule1;
   private IRxValidationRule invalidRule2;
   private Prescription rx;

   @Before
   public void setUp() {
      rx = new Prescription();

      alwaysValidRule = Mockito.mock(IRxValidationRule.class);
      Mockito.when(alwaysValidRule.validateAgainstRule(rx)).thenReturn(validResult());

      invalidRule1 = Mockito.mock(IRxValidationRule.class);
      Mockito.when(invalidRule1.validateAgainstRule(rx)).thenReturn(
         invalidResult("Error Message 1", ERxComponent.DOSE_AMOUNT,
            ERxComponent.DURATION));

      invalidRule2 = Mockito.mock(IRxValidationRule.class);
      Mockito.when(invalidRule2.validateAgainstRule(rx)).thenReturn(
         invalidResult("Error Message 2", ERxComponent.FREQUENCY));
   }

   private RxValidationResult validResult() {
      return new RxValidationResult();
   }

   private RxValidationResult invalidResult(String message, ERxComponent... components) {
      RxValidationResult result = new RxValidationResult();
      result.setMessage(message);
      for (ERxComponent component : components) {
         result.addInvalidComponent(component);
      }
      return result;
   }

   @Test
   public void returnValidResponseIfNoRulesAreInError() {
      RxValidator validator = buildValidatorWithRules(alwaysValidRule);
      ValidatePrescriptionCommand command = new ValidatePrescriptionCommand(validator);

      ValidatePrescriptionResponse response = command.validatePrescription(rx);

      assertTrue(response.isValid());
      assertEquals(0, response.getMessages().size());
   }

   @Test
   public void returnInvalidRepsonseIfOneRuleInError() {
      RxValidator validator = buildValidatorWithRules(alwaysValidRule, invalidRule1);
      ValidatePrescriptionCommand command = new ValidatePrescriptionCommand(validator);

      ValidatePrescriptionResponse response = command.validatePrescription(rx);

      assertFalse(response.isValid());
      assertEquals(1, response.getMessages().size());
      assertEquals("Error Message 1", response.getMessages().get(0));
   }

   @Test
   public void includeAllComponentsAndMessagesIfMultipleRulesInError() {
      RxValidator validator = buildValidatorWithRules(alwaysValidRule, invalidRule1,
         invalidRule2);
      ValidatePrescriptionCommand command = new ValidatePrescriptionCommand(validator);

      ValidatePrescriptionResponse response = command.validatePrescription(rx);

      assertFalse(response.isValid());
      assertEquals(2, response.getMessages().size());
      assertEquals("Error Message 1", response.getMessages().get(0));
      assertEquals("Error Message 2", response.getMessages().get(1));
   }

   private RxValidator buildValidatorWithRules(IRxValidationRule... rules) {
      ArrayList<IRxValidationRule> ruleList = new ArrayList<>();
      ruleList.addAll(Arrays.asList(rules));
      return new RxValidator(ruleList);
   }

}