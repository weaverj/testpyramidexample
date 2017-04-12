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

    this.drug = {};
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

    RxHttpAPI.prototype.getDrugs = function getDrugs() {
      console.log("Retrieving prescribable drugs from server...");
      return this.http.fetch("drugs", {
        method: "get"
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
      this.warningMessage = "Test";
      this.currentRx = new _Rx.Rx();
    }

    App.prototype.validRx = function validRx() {
      return true;
    };

    App.prototype.submitRx = function submitRx() {
      console.log("Submitting Rx");
      console.log("Selected drug is: ");
      console.log(this.selectedDrug);
      this.rxApi.sendRx(this.currentRx).then(function (response) {
        return response.json();
      }).then(function (response) {
        console.log(response);
      });
    };

    App.prototype.loadDrugs = function loadDrugs() {
      var _this = this;

      this.rxApi.getDrugs().then(function (response) {
        return response.json();
      }).then(function (response) {
        console.log(response);
        _this.availableDrugs = response;
      });
    };

    App.prototype.attached = function attached() {
      console.log("view model attached to dom");
      this.loadDrugs();
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
define('text!app.html', ['module'], function(module) { module.exports = "<template><div class=\"header\"><h1>Rx Demo</h1></div><form><fieldset><legend>Medication</legend><div class=\"field-column\"><label for=\"medication\">Medication</label><select value.bind=\"currentRx.drug\" id=\"medication\"><option model.bind=\"null\">Choose...</option><option repeat.for=\"drug of availableDrugs\" model.bind=\"drug\">${drug.name}</option></select></div></fieldset><fieldset><legend>Prescription</legend><div class=\"field-column\"><label for=\"dose-amount\">Dose Amount</label><input id=\"dose-amount\" value.bind=\"currentRx.doseAmount\" placeholder=\"Dose Amount\"></div><div class=\"field-column\"><label for=\"dose-unit\">Dose Unit</label><input id=\"dose-unit\" value.bind=\"currentRx.doseUnit\" placeholder=\"Dose Unit\"></div><div class=\"field-column\"><label for=\"route\">Route</label><input id=\"route\" value.bind=\"currentRx.route\" placeholder=\"Route\"></div><div class=\"field-column\"><label for=\"frequency\">Frequency</label><input id=\"frequency\" value.bind=\"currentRx.frequency\" placeholder=\"Frequency\"></div><div class=\"field-column ending-field-column\"><label for=\"duration\">Duration</label><input id=\"duration\" value.bind=\"currentRx.duration\" placeholder=\"Duration\"></div><br class=\"clear\"></fieldset><br><div if.bind=\"warningMessage\" class=\"alert\">${warningMessage}</div><button class=\"formButton\" click.delegate=\"submitRx()\" disabled.bind=\"!validRx\">Add Rx to Cart</button> <button class=\"formButton\">Cancel</button></form></template>"; });
//# sourceMappingURL=app-bundle.js.map