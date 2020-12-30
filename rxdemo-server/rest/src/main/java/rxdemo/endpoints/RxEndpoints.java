package rxdemo.endpoints;

import com.google.gson.Gson;
import rxdemo.commands.ValidatePrescriptionCommand;
import rxdemo.prescription.Prescription;
import rxdemo.prescription.validation.RxValidator;
import rxdemo.vendordata.DrugDatabase;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

// change to be deployed

public class RxEndpoints {
   public static void initalizeEndpoints() {

      Gson gson = new Gson();

      // an api call
      post("/rx", (request, response) -> {
         ValidatePrescriptionCommand command = new ValidatePrescriptionCommand(RxValidator.getDefaultValidator());
         Prescription rx = gson.fromJson(request.body(), Prescription.class);
         return command.validatePrescription(rx);
      }, gson::toJson);

      get("/drugs", (request, response) -> DrugDatabase.getDrugsAvailableForPrescribing(), gson::toJson);

      exception(Exception.class, (exception, request, response) -> {
         exception.printStackTrace();
         internalServerError("<html><body>" + exception.getMessage() + "</body></html>");
      });

      before((request, response) -> {
         response.header("Access-Control-Allow-Origin", "*");
         response.header("Access-Control-Allow-Headers", "Content-Type");
      });

      options("/rx", (Request request, Response response) -> {
         response.header("Access-Control-Allow-Headers", "Content-Type");
         String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
         if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Request-Method", accessControlRequestHeaders);
         }

         String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
         if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
         }
         return "OK";
      });

   }
}
