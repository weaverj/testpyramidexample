import {App} from '../../src/app';

describe('the prescription building view', () => {

  it('has no errors and an empty rx on construction', () => {
    expect(new App().errorMessages).toEqual([]);
    expect(new App().fieldsInError).toEqual([]);
    expect(new App().availableDrugs).toEqual([]);
    expect(new App().currentRx).not.toBeNull();
  });

  it('loads drugs when attached to dom', function(done) {

    let response = new Response(JSON.stringify(
      [{drugId : "1", name: "drug1", classifications : []}]
    ));

    let fetchPromise = new Promise(function(resolve) {
      resolve(response.json());
    });

    let mockApi = { getDrugs : function() {
      return fetchPromise;
    }};

    let app = new App(mockApi);

    app.attached();

    fetchPromise.then( function() {
      console.log(app.availableDrugs[0]);
      expect(app.availableDrugs.length).toBe(1);
      expect(app.availableDrugs[0].drugId).toBe("1");
      expect(app.availableDrugs[0].name).toBe("drug1");
      done();
    });
  });
});
