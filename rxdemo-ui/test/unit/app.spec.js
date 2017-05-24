import {App} from '../../src/app';

describe('the prescription building view', () => {

  let drugPromise;
  let submitPromise;

  it('constructs with empty rx, no success message, and no available drugs', () => {
    expect(new App().availableDrugs).toEqual([]);
    expect(new App().currentRx).not.toBeNull();
    expect(new App().successMessage).toBe("");
  });

  it('loads drugs when attached to dom', function(done) {
    let mockApi = buildMockApi([{drugId : "1", name: "drug1", classifications : []}], null);
    let app = new App(mockApi);

    app.attached();

    drugPromise.then( function() {
      expect(app.availableDrugs.length).toBe(1);
      expect(app.availableDrugs[0].drugId).toBe("1");
      expect(app.availableDrugs[0].name).toBe("drug1");
      done();
    });
  });

  it('displays success message on submit if server validation passes', function(done) {
    let mockApi = buildMockApi([{drugId : "1", name: "drug1", classifications : []}],
                               {valid : true, componentsInError: [], messages : []} );
    let app = new App(mockApi);

    app.attached();
    app.submitRx();

    submitPromise.then( function() {
      expect(app.successMessage).toBe("Prescription successfully transmitted.");
      done();
    });

  });

  it('clears success message on submit if server validation fails', function(done) {
    let mockApi = buildMockApi([{drugId : "1", name: "drug1", classifications : []}],
      {valid : false, componentsInError: ["FREQUENCY"], messages : ["Incorrect Frequency"]} );
    let app = new App(mockApi);

    app.attached();
    app.submitRx();

    submitPromise.then( function() {
      expect(app.successMessage).toBe("");
      done();
    });
  });

  function buildMockApi(loadDrugsServerJson, validateRxServerJson) {
    let submitRxResponse = new Response(JSON.stringify(validateRxServerJson));
    let drugResponse = new Response(JSON.stringify(loadDrugsServerJson));

    drugPromise = new Promise(function(resolve) {
      resolve(drugResponse.json());
    });

    submitPromise = new Promise(function(resolve) {
      resolve(submitRxResponse.json());
    });

    return {
      getDrugs : function() {
        return drugPromise;
      },
      sendRx : function(rx) {
        return submitPromise;
      }
    };
  }


});
