package rxdemo.fitnesse;

import org.apache.commons.lang3.StringUtils;
import rxdemo.drug.DispensableDrug;
import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.RequiredRxFieldsValidationRule;
import rxdemo.prescription.validation.RxValidationResult;
import rxdemo.vendordata.EDrugClassification;

public class RequiredRxFieldPresent {

   private String drug;
   private String doseAmount;
   private String doseUnit;
   private String frequency;
   private String route;
   private String duration;

   private RxValidationResult result;

   public void setDrug(String drug) {
      this.drug = drug;
   }

   public void setDoseAmount(String doseAmount) {
      this.doseAmount = doseAmount;
   }

   public void setDoseUnit(String doseUnit) {
      this.doseUnit = doseUnit;
   }

   public void setFrequency(String frequency) {
      this.frequency = frequency;
   }

   public void setRoute(String route) {
      this.route = route;
   }

   public void setDuration(String duration) {
      this.duration = duration;
   }

   public void execute() {
      RequiredRxFieldsValidationRule rule = new RequiredRxFieldsValidationRule();
      result = rule.validateAgainstRule(rxForScenario());
   }

   private Prescription rxForScenario() {
      Prescription rx = new Prescription();
      if (!StringUtils.isEmpty(drug)) {
         rx.setDrug(new DispensableDrug(1, drug, new EDrugClassification[]{}));
      }
      rx.setRoute(route);
      rx.setDoseUnit(doseUnit);
      rx.setDoseAmount(doseAmount);
      rx.setFrequency(frequency);
      rx.setDuration(duration);
      return rx;
   }

   public boolean valid() {
      return result.isValid();
   }

   public String message() {
      return result.getMessage();
   }

   public String componentsInvalid() {
      return StringUtils.join(result.getComponentsInvalid(), ", ");
   }


}
