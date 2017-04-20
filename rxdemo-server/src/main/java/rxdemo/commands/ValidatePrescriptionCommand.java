package rxdemo.commands;

import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.RxValidationResult;
import rxdemo.prescription.validation.RxValidator;

import java.util.List;

public class ValidatePrescriptionCommand {

   private RxValidator validator;

   public ValidatePrescriptionCommand(RxValidator validator) {
      this.validator = validator;
   }

   public ValidatePrescriptionResponse validatePrescription(Prescription rx) {
      ValidatePrescriptionResponse response = new ValidatePrescriptionResponse();
      List<RxValidationResult> validationResults = validator.validatePrescription(rx);
      for (RxValidationResult result : validationResults) {
         response.includeValidationResult(result);
      }
      return response;
   }

}
