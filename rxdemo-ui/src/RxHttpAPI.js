import {inject} from 'aurelia-framework';
import {HttpClient, json} from 'aurelia-fetch-client';


@inject(HttpClient)
export class RxHttpAPI {

  constructor(http) {
    http.configure(config => {
      config.withBaseUrl("http://localhost:4567/");
    });
    this.http = http;
  }

  sendRx(rx) {
    console.log("Submitting Rx to server...");
    console.log(rx);
    return this.http.fetch("rx", {
      method: "post",
      body: json(rx)
    }).then(response => response.json());
  }

  getDrugs() {
    console.log("Retrieving prescribable drugs from server...");
    return this.http.fetch("drugs", {
      method: "get"
    }).then(response => response.json());
  }

}
