package rxdemo.prescription;


public enum EDurationUnit {

   DAY("day", "days", 1),
   WEEK("week", "weeks", 7),
   MONTH("month", "months", 30);

   private String singularForm;
   private String pluralForm;


   private int multiplier;


   EDurationUnit(String singularForm, String pluralForm, int multiplier) {
      this.singularForm = singularForm;
      this.pluralForm = pluralForm;
      this.multiplier = multiplier;
   }

   public int getMultiplier() {
      return multiplier;
   }

   public static EDurationUnit getByTextValue(String textValue) {
      for (EDurationUnit unit : EDurationUnit.values()) {
         if ((unit.singularForm.equals(textValue.toLowerCase())) ||
            (unit.pluralForm.equals(textValue.toLowerCase()))) {
            return unit;
         }
      }
      return null;
   }
}
