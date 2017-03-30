import {RxHttpAPI} from "./RxHttpAPI";
import {Rx} from "Rx";
import {inject} from 'aurelia-framework';


@inject(RxHttpAPI)
export class App {

  currentRx;

  constructor(rxApi) {
    this.rxApi = rxApi;
    this.message = 'Rx Demo';
    this.warningMessage = "Test";
    this.currentRx = new Rx();
    this.currentRx.doseUnit = "dose unit";
    this.currentRx.doseAmount = "dose amount";
    this.currentRx.route = "route";
    this.currentRx.frequency = "frequency";
    this.currentRx.duration = "duration";
  }

  validRx() {
    return true;
  }

  submitRx() {
    console.log("Submitting Rx");
    this.rxApi.sendRx(this.currentRx)
      .then(response => response.json())
      .then(response => {
        console.log(response);
      });
  }
}
