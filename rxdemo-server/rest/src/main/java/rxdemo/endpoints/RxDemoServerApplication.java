package rxdemo.endpoints;

import spark.servlet.SparkApplication;

public class RxDemoServerApplication implements SparkApplication {
    @Override
    public void init() {
        RxEndpoints.initalizeEndpoints();
    }
}
