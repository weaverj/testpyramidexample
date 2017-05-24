
export class RxValidationResponseHandler {

  fieldReferenceToComponentMap;
  errorMessages;

  constructor(fieldReferenceToComponentMap) {
    this.fieldReferenceToComponentMap = fieldReferenceToComponentMap;
  }

  processResponse(rxValidationResponse) {
    this.clearFieldErrors();
    this.markFieldsInError(rxValidationResponse.componentsInError);
    this.errorMessages = rxValidationResponse.messages;
  }

  getErrors() {
    return this.errorMessages;
  }

  markFieldsInError(rxComponents) {
    for (let i=0 ; i < rxComponents.length; i++) {
      let field = this.fieldReferenceToComponentMap[rxComponents[i]];
      if (field) {
        field.classList.add("error-input");
      }
    }
  }

  clearFieldErrors() {
    this.errorMessages = [];
    for (let fieldReference in this.fieldReferenceToComponentMap) {
      let field = this.fieldReferenceToComponentMap[fieldReference];
      if (field != null) {
        field.classList.remove("error-input");
      }
    }
  }


}
