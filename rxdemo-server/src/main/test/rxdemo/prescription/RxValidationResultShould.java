package rxdemo.prescription;

import org.junit.Test;

import static org.junit.Assert.*;

public class RxValidationResultShould {

   @Test
   public void constructValidResultWithoutComponentsCorrectly() {
      RxValidationResult result = new RxValidationResult(true, null);
      assertTrue(result.isValid());
      assertNull(result.getMessage());
      assertEquals(0, result.getComponentsInvalid().size());
   }

   @Test
   public void constructInvalidResultWithSingleComponentCorrectly() {
      RxValidationResult result = new RxValidationResult(false, "frequency invalid", ERxComponent.FREQUENCY);
      assertFalse(result.isValid());
      assertEquals("frequency invalid", result.getMessage());
      assertEquals(1, result.getComponentsInvalid().size());
      assertEquals(ERxComponent.FREQUENCY, result.getComponentsInvalid().get(0));
   }

   @Test
   public void constructInvalidResultWithMultipleComponentsCorrectly() {
      RxValidationResult result = new RxValidationResult(false, "dose amount and unit are required",
         ERxComponent.DOSE_AMOUNT, ERxComponent.DOSE_UNIT);
      assertFalse(result.isValid());
      assertEquals("dose amount and unit are required", result.getMessage());
      assertEquals(2, result.getComponentsInvalid().size());

      // order does not matter for marked invalid fields.
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DOSE_AMOUNT));
      assertTrue(result.getComponentsInvalid().contains(ERxComponent.DOSE_UNIT));
   }

}