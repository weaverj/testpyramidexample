import environment from './environment';

//Configure Bluebird Promises.
Promise.config({
  warnings: {
    wForgottenReturn: false
  }
});

export function configure(aurelia) {

  function calculateEnvironment(href) {
    if (href.indexOf("localhost:8090/rxdemo-test") !== -1) {
      return "tomcatlocaltest";
    }
    if (href.indexOf("localhost:8090/rxdemo") !== -1) {
      return "tomcatlocal";
    }
    if (href.indexOf("localhost") !== -1) {
      return "development";
    }
    if (href.indexOf("elasticbeanstalk") !== -1) {
      return "production";
    }


  }

  aurelia.use
    .standardConfiguration()
    .feature('resources')
    .plugin('aurelia-configuration', config => {
      console.log("In main.js bootstrap.");
      console.log(window.location.href);
      let environmentName = calculateEnvironment(window.location.href);
      console.log("Setting environment to: " + environmentName);
      config.setEnvironment(environmentName);
    });

  if (environment.debug) {
    aurelia.use.developmentLogging();
  }

  if (environment.testing) {
    aurelia.use.plugin('aurelia-testing');
  }

  aurelia.start().then(() => aurelia.setRoot());
}
