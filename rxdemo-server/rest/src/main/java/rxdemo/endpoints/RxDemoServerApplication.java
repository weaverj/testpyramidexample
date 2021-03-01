package rxdemo.endpoints;

import spark.servlet.SparkApplication;
//demo commit
public class RxDemoServerApplication implements SparkApplication {
    @Override
    public void init() {
        RxEndpoints.initalizeEndpoints();
    }
}
