package rxdemo.endpoints;

import spark.servlet.SparkApplication;
//Triggering the build
public class RxDemoServerApplication implements SparkApplication {
    @Override
    public void init() {
        RxEndpoints.initalizeEndpoints();
    }
}
