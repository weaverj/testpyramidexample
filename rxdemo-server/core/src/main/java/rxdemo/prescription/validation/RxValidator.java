package rxdemo.prescription.validation;

import rxdemo.prescription.Prescription;

import java.util.ArrayList;
import java.util.List;

public class RxValidator {

   private static RxValidator defaultValidator;
   private List<IRxValidationRule> rules;

   static {
      ArrayList<IRxValidationRule> defaultRules = new ArrayList<>();
      defaultRules.add(new RequiredRxFieldsValidationRule());
      defaultRules.add(new OpiateDurationValidationRule());
      defaultValidator = new RxValidator(defaultRules);
   }

   public static RxValidator getDefaultValidator() {
      return defaultValidator;
   }

   public RxValidator(List<IRxValidationRule> rules) {
      this.rules = (rules != null)? rules : new ArrayList<>();
   }

   public List<RxValidationResult> validatePrescription(Prescription rx) {
      ArrayList<RxValidationResult> results = new ArrayList<>();
      for (IRxValidationRule rule : rules) {
         results.add(rule.validateAgainstRule(rx));
      }
      return results;
   }

}
