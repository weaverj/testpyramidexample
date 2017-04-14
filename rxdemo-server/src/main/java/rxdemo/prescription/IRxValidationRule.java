package rxdemo.prescription;

public interface IRxValidationRule {

    RxValidationResult validateAgainstRule(Prescription rx);

}
