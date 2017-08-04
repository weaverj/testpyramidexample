package rxdemo.fitnesse;

import org.apache.commons.lang3.StringUtils;
import rxdemo.prescription.validation.OpiateDurationValidationRule;
import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.RxValidationResult;
import rxdemo.vendordata.DrugDatabase;

public class OpioidRuleAllowsPrescribing {

   private String drug;
   private String duration;

   private Prescription rxForScenario;
   private RxValidationResult result;

   public boolean valid() {
      return result.isValid();
   }

   public String message() {
      return result.getMessage();
   }

   public String componentsInvalid() {
      return StringUtils.join(result.getComponentsInvalid(), ",");
   }

   public void setDrug(String drug) {
      this.drug = drug;
   }

   public void setDuration(String duration) {
      this.duration = duration;
   }

   public void execute() {
      rxForScenario = new Prescription();
      rxForScenario.setDrug(DrugDatabase.getDrugByName(drug));
      rxForScenario.setDuration(duration);
      result = new OpiateDurationValidationRule().validateAgainstRule(rxForScenario);
   }
}
