package rxdemo.fitnesse;

import rxdemo.prescription.DurationParser;

public class DurationParsesToDays {

   private String duration;

   public void setDuration(String duration) {
      this.duration = duration;
   }

   public int days() {
      return DurationParser.parseDays(duration);
   }
}
