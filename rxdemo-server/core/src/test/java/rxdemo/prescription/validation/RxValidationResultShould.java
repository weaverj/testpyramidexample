package rxdemo.prescription.validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RxValidationResultShould {

   private RxValidationResult result;

   @Before
   public void setUp() {
      result = new RxValidationResult();
   }

   @Test
   public void beValidByDefault() {
      assertTrue(result.isValid());
   }

   @Test
   public void beInvalidWhenAnInvalidFieldIsAdded(){
      result.addInvalidComponent(ERxComponent.DOSE_UNIT);
      assertFalse(result.isValid());
   }

}