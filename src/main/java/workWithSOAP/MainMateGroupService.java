package workWithSOAP;

import javax.xml.ws.Endpoint;

public class MainMateGroupService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/mate",  new MateGroupServiceImpl());
    }
}
