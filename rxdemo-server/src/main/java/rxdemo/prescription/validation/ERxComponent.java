package rxdemo.prescription.validation;

public enum ERxComponent {

   DRUG("Drug"),
   DOSE_AMOUNT("Dose Amount"),
   DOSE_UNIT("Dose Unit"),
   ROUTE("Route"),
   FREQUENCY("Frequency"),
   DURATION("Duration");

   private String description;

   ERxComponent(String description) {
      this.description = description;
   }

   public String getDescription() {
      return description;
   }
}
