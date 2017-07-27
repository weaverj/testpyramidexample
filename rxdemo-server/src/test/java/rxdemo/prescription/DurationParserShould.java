package rxdemo.prescription;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DurationParserShould {

   @Test
   public void parseUnitByMultipler() {
      assertEquals(7, DurationParser.parseDays("1 week"));
   }

   @Test
   public void returnZeroIfUnitNotRecognized() {
      assertEquals(0, DurationParser.parseDays("2 blarghs"));
   }

   @Test
   public void returnZeroIfValueNotNumber() {
      assertEquals(0, DurationParser.parseDays("x days"));
   }

   @Test
   public void returnsOneDayForOnceDuration() {
      assertEquals(1, DurationParser.parseDays("Once"));
   }

   @Test
   public void returnZeroIfNoParts() {
      assertEquals(0, DurationParser.parseDays(""));
   }

   @Test
   public void returnZeroIfMoreThanTwoParts() {
      assertEquals(0, DurationParser.parseDays("1 2 days"));
   }


}