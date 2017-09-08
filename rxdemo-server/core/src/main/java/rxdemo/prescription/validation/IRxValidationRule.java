package rxdemo.prescription.validation;

import rxdemo.prescription.Prescription;

public interface IRxValidationRule {

   RxValidationResult validateAgainstRule(Prescription rx);

}
