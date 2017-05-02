import {RxHttpAPI} from "./RxHttpAPI";
import {Rx} from "Rx";
import {inject} from 'aurelia-framework';

@inject(RxHttpAPI)
export class App {

  constructor(rxApi) {
    this.rxApi = rxApi;
    this.currentRx = new Rx();
    this.fieldReferenceToComponentMap = [];
    this.errorMessages = [];
    this.successMessage = "";
    this.fieldsInError = [];
    this.availableDrugs = [];
  }

  attached() {
    this.loadDrugs();
    this.fieldReferenceToComponentMap = {"DRUG" : this.drugSelect, "DOSE_AMOUNT" : this.doseAmountInput,
      "DOSE_UNIT" : this.doseUnitInput, "ROUTE" : this.routeInput, "FREQUENCY" : this.frequencyInput,
      "DURATION" : this.durationInput};
  }

  submitRx() {
    this.rxApi.sendRx(this.currentRx)
      .then(response => response.json())
      .then(response => {
        console.log(response);
        this.mapValidationResponse(response);
      });
  }

  loadDrugs() {
    this.rxApi.getDrugs().then( (response) => {
      this.availableDrugs = response;
    });
  }

  mapValidationResponse(response) {
    this.clearFieldErrors();
    if (response.valid === true) {
      this.successMessage = "Prescription succesfully transmitted.";
      return;
    }
    this.successMessage = null;
    this.errorMessages = response.messages;
    this.markFieldsInError(response.componentsInError);
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
    for (var fieldReference in this.fieldReferenceToComponentMap) {
      let field = this.fieldReferenceToComponentMap[fieldReference];
      field.classList.remove("error-input");
    }
  }

}
