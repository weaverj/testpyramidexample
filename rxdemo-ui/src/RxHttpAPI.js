import {inject} from 'aurelia-framework';
import {HttpClient, json} from 'aurelia-fetch-client';
import {AureliaConfiguration} from 'aurelia-configuration';


@inject(HttpClient, AureliaConfiguration)
export class RxHttpAPI {

  apiRootUrl;

  constructor(http, config) {
    this.apiRootUrl = config.get('api.endpoint');
    console.log("RxHttpAPI configured with URL: " + this.apiRootUrl);
    http.configure(config => {
      config.withBaseUrl(this.apiRootUrl);
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
