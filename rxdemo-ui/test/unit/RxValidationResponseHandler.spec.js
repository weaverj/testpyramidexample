import {RxValidationResponseHandler} from '../../src/RxValidationResponseHandler';

describe('the prescription validation response handler', () => {

  let buildMockFieldReference = function(fieldName) {
    let classList = {
      classes : [],
      add: function(clss) {
        this.classes.push(clss);
      },
      remove: function(clss) {
        let index = this.classes.indexOf(clss);
        if (index > -1) {
          this.classes.splice(index, 1);
        }
      },
      hasClass: function(clss) {
        return this.classes.indexOf(clss) != -1;
      }
    };
    return { classList : classList };
  };

  it('marks fields in error and stores error messages from server validation response', () => {
    let somefield = buildMockFieldReference("somefield");
    let handler = new RxValidationResponseHandler({"component-name" : somefield});

    let validationJson = { componentsInError : ["component-name"], messages: ["problem with component"] };
    handler.processResponse(validationJson);

    expect(somefield.classList.hasClass("error-input")).toBe(true);
    expect(handler.getErrors()).toContain("problem with component");
  });

  it('clears fields previously in error as part of processing new validation response', () => {
    let somefield = buildMockFieldReference("somefield");
    somefield.classList.add("error-input");
    let handler = new RxValidationResponseHandler({"component-name" : somefield});

    let validationJson = { componentsInError : [], messages: [] };
    handler.processResponse(validationJson);

    expect(somefield.classList.hasClass("error-input")).toBe(false);
  });


});
