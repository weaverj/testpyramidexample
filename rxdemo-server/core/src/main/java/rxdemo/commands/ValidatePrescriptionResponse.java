package rxdemo.commands;

import rxdemo.prescription.validation.ERxComponent;
import rxdemo.prescription.validation.RxValidationResult;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidatePrescriptionResponse {

   private boolean valid;
   private ArrayList<String> messages;
   private HashSet<ERxComponent> componentsInError;

   public ValidatePrescriptionResponse() {
      this.messages = new ArrayList<>();
      this.componentsInError = new HashSet<>();
      this.valid = true;
   }

   public boolean isValid() {
      return valid;
   }

   public ArrayList<String> getMessages() {
      return messages;
   }

   public HashSet<ERxComponent> getComponentsInError() {
      return componentsInError;
   }

   public void includeValidationResult(RxValidationResult result) {
      if (!result.isValid()) {
         this.valid = false;
         this.messages.add(result.getMessage());
         this.componentsInError.addAll(result.getComponentsInvalid());
      }
   }
}
