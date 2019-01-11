package es.drachodran.apaw.http.http;


import es.drachodran.apaw.Dispatcher;
import es.drachodran.apaw.http.Dispatcher;

public class Server {
    private es.drachodran.apaw.Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        dispatcher.submit(request, response);
        return response;
    }

}
