package rxdemo.prescription.validation;

import org.apache.commons.lang3.StringUtils;
import rxdemo.prescription.Prescription;

import java.util.List;

public class RequiredRxFieldsValidationRule implements IRxValidationRule {

   @Override
   public RxValidationResult validateAgainstRule(Prescription rx) {
      RxValidationResult result = new RxValidationResult();

      markInvalidIfEmpty(ERxComponent.DOSE_AMOUNT, rx.getDoseAmount(), result);
      markInvalidIfEmpty(ERxComponent.DOSE_UNIT, rx.getDoseUnit(), result);
      markInvalidIfEmpty(ERxComponent.FREQUENCY, rx.getFrequency(), result);
      markInvalidIfEmpty(ERxComponent.ROUTE, rx.getRoute(), result);
      markInvalidIfEmpty(ERxComponent.DURATION, rx.getDuration(), result);

      if (rx.getDrug() == null) {
         result.addInvalidComponent(ERxComponent.DRUG);
      }

      if (result.getComponentsInvalid().size() > 0) {
         result.setMessage("The following fields are required: " + buildFieldList(result.getComponentsInvalid()) + ".");
      }

      return result;
   }

   private void markInvalidIfEmpty(ERxComponent component, String componentValue, RxValidationResult result) {
      if (StringUtils.isEmpty(componentValue)) {
         result.addInvalidComponent(component);
      }
   }

   private String buildFieldList(List<ERxComponent> componentsInvalid) {
      Object[] fields = componentsInvalid.stream().map(ERxComponent::getDescription).toArray();
      return StringUtils.join(fields, ", ");
   }

}
