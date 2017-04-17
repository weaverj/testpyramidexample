package rxdemo.prescription;

import java.util.ArrayList;
import java.util.List;

public class RxValidationResult {

   private String message;
   private List<ERxComponent> componentsInvalid;

   RxValidationResult() {
      this.componentsInvalid = new ArrayList<>();
   }

   public boolean isValid() {
      return componentsInvalid.isEmpty();
   }

   public String getMessage() {
      return message;
   }

   public List<ERxComponent> getComponentsInvalid() {
      return componentsInvalid;
   }

   void addInvalidComponent(ERxComponent component) {
      componentsInvalid.add(component);
   }

   void setMessage(String message) {
      this.message = message;
   }
}
