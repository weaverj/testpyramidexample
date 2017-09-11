import environment from './environment';

//Configure Bluebird Promises.
Promise.config({
  warnings: {
    wForgottenReturn: false
  }
});

export function configure(aurelia) {
  aurelia.use
    .standardConfiguration()
    .feature('resources')
    .plugin('aurelia-configuration', config => {
      config.setEnvironments({
        development: ['localhost'],
        tomcatlocal: ['localhost:8090/rxdemo-ui'],
        production: ['rxdemoui-env.hweggypgnu.us-east-2.elasticbeanstalk.com']
      });
    });

  if (environment.debug) {
    aurelia.use.developmentLogging();
  }

  if (environment.testing) {
    aurelia.use.plugin('aurelia-testing');
  }

  aurelia.start().then(() => aurelia.setRoot());
}
