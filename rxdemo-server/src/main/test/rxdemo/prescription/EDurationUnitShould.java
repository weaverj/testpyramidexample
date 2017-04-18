package rxdemo.prescription;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EDurationUnitShould {

   @Test
   public void returnUnitsBySingularOrPlural() {
      assertEquals(EDurationUnit.DAY, EDurationUnit.getByTextValue("day"));
      assertEquals(EDurationUnit.DAY, EDurationUnit.getByTextValue("days"));
   }

   @Test
   public void returnNullForUnrecognizedUnit() {
      assertNull(EDurationUnit.getByTextValue("stardate"));
   }

   @Test
   public void ignoreCaseOfUnitString() {
      assertEquals(EDurationUnit.MONTH, EDurationUnit.getByTextValue("Month"));
   }
}