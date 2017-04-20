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

  constructor(rxApi) {
    this.rxApi = rxApi;
    this.currentRx = new Rx();
    this.errorMessages = [];
    this.fieldsInError = [];
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
    this.rxApi.getDrugs().then(response => response.json()).then(response => {
      console.log(response);
      this.availableDrugs = response;
    });
  }

  attached() {
    console.log("view model attached to dom");
    this.loadDrugs();
  }

  mapValidationResponse(response) {
    if (response.valid === true) {
      this.successMessage = "Prescription succesfully transmitted.";
      this.errorMessages = [];
      return;
    }
    this.errorMessages = response.messages;
  }
}
