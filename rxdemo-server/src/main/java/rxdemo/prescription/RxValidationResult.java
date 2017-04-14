package rxdemo.prescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RxValidationResult {
   private boolean valid;
   private String message;
   private List<ERxComponent> componentsInvalid;

   public RxValidationResult(boolean isValid, String message, ERxComponent... components) {
      this.valid = isValid;
      this.message = message;
      this.componentsInvalid = (components.length == 0) ? new ArrayList<>() : Arrays.asList(components);
   }

   public boolean isValid() {
      return valid;
   }

   public String getMessage() {
      return message;
   }

   public List<ERxComponent> getComponentsInvalid() {
      return componentsInvalid;
   }

}
