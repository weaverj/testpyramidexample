import {RxHttpAPI} from "./RxHttpAPI";
import {Rx} from "Rx";
import {inject} from 'aurelia-framework';

@inject(RxHttpAPI)
export class App {

  currentRx;
  availableDrugs;
  selectedDrug;
  successMessage;
  errorMessages;
  fieldsInError;
  fieldReferenceToComponentMap;


  constructor(rxApi) {
    this.rxApi = rxApi;
    this.currentRx = new Rx();
    this.errorMessages = [];
    this.fieldsInError = [];
    this.availableDrugs = [];
  }

  attached() {
    console.log("view model attached to dom");
    this.loadDrugs();
    this.fieldReferenceToComponentMap = {"DRUG" : this.drugSelect, "DOSE_AMOUNT" : this.doseAmountInput,
      "DOSE_UNIT" : this.doseUnitInput, "ROUTE" : this.routeInput, "FREQUENCY" : this.frequencyInput,
      "DURATION" : this.durationInput};
  }


  validRx() {
    return true;
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
    console.log("App.js about to call api to get promise");
    this.rxApi.getDrugs().then( (response) => {
      console.log("HERE FINALLY!!!");
      console.log(response);
      console.log("heh?");
      this.availableDrugs = response;
    });
    // this.rxApi.getDrugs().then( (response) => {
    //   response.json();
    //   console.log("HERE FINALLY!@@@");
    //   console.log(response);
    //   this.availableDrugs = response;
    // }).catch( (error) => {
    //   console.log("Error occurred resolving promise: ");
    //   console.log(error);
    // });
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
