import {App} from '../../src/app';

describe('the prescription building view', () => {

  it('constructs with empty rx, no success message, and no available drugs', () => {
    expect(new App().availableDrugs).toEqual([]);
    expect(new App().currentRx).not.toBeNull();
    expect(new App().successMessage).toBe("");
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
      expect(app.availableDrugs.length).toBe(1);
      expect(app.availableDrugs[0].drugId).toBe("1");
      expect(app.availableDrugs[0].name).toBe("drug1");
      done();
    });
  });

  it('displays success message on submit if server validation passes', function() {

  });



});
