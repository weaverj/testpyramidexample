package rxdemo.prescription;

import rxdemo.drug.DispensableDrug;

public class Prescription {

   private DispensableDrug drug;
   private String doseAmount;
   private String doseUnit;
   private String route;
   private String frequency;
   private String duration;

   public DispensableDrug getDrug() {
      return drug;
   }

   public void setDrug(DispensableDrug drug) {
      this.drug = drug;
   }

   public String getDoseAmount() {
      return doseAmount;
   }

   public void setDoseAmount(String doseAmount) {
      this.doseAmount = doseAmount;
   }

   public String getDoseUnit() {
      return doseUnit;
   }

   public void setDoseUnit(String doseUnit) {
      this.doseUnit = doseUnit;
   }

   public String getRoute() {
      return route;
   }

   public void setRoute(String route) {
      this.route = route;
   }

   public String getFrequency() {
      return frequency;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public String getDuration() {
      return duration;
   }

   public void setDuration(String duration) {
      this.duration = duration;
   }

   public int getDurationAsDays() {
      return DurationParser.parseDays(this.duration);
   }
}
