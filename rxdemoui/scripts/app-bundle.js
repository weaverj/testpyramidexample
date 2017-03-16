define('app',["exports"], function (exports) {
  "use strict";

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  var App = exports.App = function App() {
    _classCallCheck(this, App);

    this.message = 'Rx Demo';
    this.warningMessage = "Test";
  };
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
define('text!app.html', ['module'], function(module) { module.exports = "<template><div class=\"header\"><h1>${message}</h1></div><form><fieldset><legend>Medication</legend><div class=\"field-column\"><label for=\"medication-name\">Drug Name</label><input list=\"medication-name\" name=\"medication-name\"><datalist id=\"medication-name\"><option value=\"Aspirin\"><option value=\"Bactrim\"></option></option></datalist></div></fieldset><fieldset><legend>Prescription</legend><div class=\"field-column\"><label for=\"dose-amount\">Dose Amount</label><input id=\"dose-amount\"></div><div class=\"field-column\"><label for=\"dose-unit\">Dose Unit</label><input id=\"dose-unit\"></div><div class=\"field-column\"><label for=\"route\">Route</label><input id=\"route\"></div><div class=\"field-column\"><label for=\"frequency\">Frequency</label><input id=\"frequency\"></div><div class=\"field-column ending-field-column\"><label for=\"duration\">Duration</label><input id=\"duration\"></div><br class=\"clear\"></fieldset><br><div if.bind=\"warningMessage\" class=\"alert\">${warningMessage}</div><button class=\"formButton\">Add Rx to Cart</button> <button class=\"formButton\">Cancel</button></form></template>"; });
//# sourceMappingURL=app-bundle.js.map