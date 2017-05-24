import {RxHttpAPI} from "./RxHttpAPI";
import {Rx} from "Rx";
import {inject} from 'aurelia-framework';
import {RxValidationResponseHandler} from 'RxValidationResponseHandler';

@inject(RxHttpAPI)
export class App {

  constructor(rxApi) {
    this.rxApi = rxApi;
    this.currentRx = new Rx();
    this.availableDrugs = [];
    this.successMessage = "";
  }

  attached() {
    this.loadDrugs();
    let fieldReferenceToComponentMap = {"DRUG" : this.drugSelect, "DOSE_AMOUNT" : this.doseAmountInput,
      "DOSE_UNIT" : this.doseUnitInput, "ROUTE" : this.routeInput, "FREQUENCY" : this.frequencyInput,
      "DURATION" : this.durationInput};
    this.validationHandler = new RxValidationResponseHandler(fieldReferenceToComponentMap);
  }

  loadDrugs() {
    this.rxApi.getDrugs().then( (response) => {
      this.availableDrugs = response;
    });
  }

  submitRx() {
    this.successMessage = "";
    this.rxApi.sendRx(this.currentRx)
      .then(response => {
        this.validationHandler.processResponse(response);
        if (this.validationHandler.getErrors().length === 0) {
          this.successMessage = "Prescription successfully transmitted.";
        }
      });
  }

}
