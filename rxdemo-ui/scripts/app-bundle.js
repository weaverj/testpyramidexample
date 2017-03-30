define('Rx',["exports"], function (exports) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  var Rx = exports.Rx = function Rx() {
    _classCallCheck(this, Rx);

    this.medication = "";
    this.doseAmount = "";
    this.doseUnit = "";
    this.route = "";
    this.frequency = "";
    this.duration = "";
  };
});
define('RxHttpAPI',['exports', 'aurelia-framework', 'aurelia-fetch-client'], function (exports, _aureliaFramework, _aureliaFetchClient) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.RxHttpAPI = undefined;

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  var _dec, _class;

  var RxHttpAPI = exports.RxHttpAPI = (_dec = (0, _aureliaFramework.inject)(_aureliaFetchClient.HttpClient), _dec(_class = function () {
    function RxHttpAPI(http) {
      _classCallCheck(this, RxHttpAPI);

      http.configure(function (config) {
        config.withBaseUrl("http://localhost:4567/");
      });
      this.http = http;
    }

    RxHttpAPI.prototype.sendRx = function sendRx(rx) {
      console.log("Submitting Rx to server...");
      return this.http.fetch("rx", {
        method: "post",
        body: (0, _aureliaFetchClient.json)(rx)
      });
    };

    return RxHttpAPI;
  }()) || _class);
});
define('app',["exports", "./RxHttpAPI", "Rx", "aurelia-framework"], function (exports, _RxHttpAPI, _Rx, _aureliaFramework) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.App = undefined;

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  var _dec, _class;

  var App = exports.App = (_dec = (0, _aureliaFramework.inject)(_RxHttpAPI.RxHttpAPI), _dec(_class = function () {
    function App(rxApi) {
      _classCallCheck(this, App);

      this.rxApi = rxApi;
      this.message = 'Rx Demo';
      this.warningMessage = "Test";
      this.currentRx = new _Rx.Rx();
      this.currentRx.doseUnit = "dose unit";
      this.currentRx.doseAmount = "dose amount";
      this.currentRx.route = "route";
      this.currentRx.frequency = "frequency";
      this.currentRx.duration = "duration";
    }

    App.prototype.validRx = function validRx() {
      return true;
    };

    App.prototype.submitRx = function submitRx() {
      console.log("Submitting Rx");
      this.rxApi.sendRx(this.currentRx).then(function (response) {
        return response.json();
      }).then(function (response) {
        console.log(response);
      });
    };

    return App;
  }()) || _class);
});
define('environment',["exports"], function (exports) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.default = {
    debug: true,
    testing: true
  };
});
define('main',['exports', './environment'], function (exports, _environment) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.configure = configure;

  var _environment2 = _interopRequireDefault(_environment);

  function _interopRequireDefault(obj) {
    return obj && obj.__esModule ? obj : {
      default: obj
    };
  }

  Promise.config({
    warnings: {
      wForgottenReturn: false
    }
  });

  function configure(aurelia) {
    aurelia.use.standardConfiguration().feature('resources');

    if (_environment2.default.debug) {
      aurelia.use.developmentLogging();
    }

    if (_environment2.default.testing) {
      aurelia.use.plugin('aurelia-testing');
    }

    aurelia.start().then(function () {
      return aurelia.setRoot();
    });
  }
});
define('resources/index',["exports"], function (exports) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });
  exports.configure = configure;
  function configure(config) {}
});
define('text!app.html', ['module'], function(module) { module.exports = "<template><div class=\"header\"><h1>${message}</h1></div><form><fieldset><legend>Medication</legend><div class=\"field-column\"><label for=\"medication-name\">Drug Name</label><input list=\"medication-name\" name=\"medication-name\"><datalist id=\"medication-name\"><option value=\"Aspirin\"><option value=\"Bactrim\"></option></option></datalist></div></fieldset><fieldset><legend>Prescription</legend><div class=\"field-column\"><label for=\"dose-amount\">Dose Amount</label><input id=\"dose-amount\" value.bind=\"currentRx.doseAmount\"></div><div class=\"field-column\"><label for=\"dose-unit\">Dose Unit</label><input id=\"dose-unit\" value.bind=\"currentRx.doseUnit\"></div><div class=\"field-column\"><label for=\"route\">Route</label><input id=\"route\" value.bind=\"currentRx.route\"></div><div class=\"field-column\"><label for=\"frequency\">Frequency</label><input id=\"frequency\" value.bind=\"currentRx.frequency\"></div><div class=\"field-column ending-field-column\"><label for=\"duration\">Duration</label><input id=\"duration\" value.bind=\"currentRx.duration\"></div><br class=\"clear\"></fieldset><br><div if.bind=\"warningMessage\" class=\"alert\">${warningMessage}</div><button class=\"formButton\" click.delegate=\"submitRx()\" disabled.bind=\"!validRx\">Add Rx to Cart</button> <button class=\"formButton\">Cancel</button></form></template>"; });
//# sourceMappingURL=app-bundle.js.map