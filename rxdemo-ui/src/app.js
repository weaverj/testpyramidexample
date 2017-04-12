import {RxHttpAPI} from "./RxHttpAPI";
import {Rx} from "Rx";
import {inject} from 'aurelia-framework';


@inject(RxHttpAPI)
export class App {

  currentRx;
  warningMessage;
  availableDrugs;
  selectedDrug;

  constructor(rxApi) {
    this.rxApi = rxApi;
    this.warningMessage = "Test";
    this.currentRx = new Rx();
  }

  validRx() {
    return true;
  }

  submitRx() {
    console.log("Submitting Rx");
    console.log("Selected drug is: ");
    console.log(this.selectedDrug);
    this.rxApi.sendRx(this.currentRx)
      .then(response => response.json())
      .then(response => {
        console.log(response);
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
}
