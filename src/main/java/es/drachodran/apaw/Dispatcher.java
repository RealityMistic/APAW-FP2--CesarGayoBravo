package es.drachodran.apaw;

import es.drachodran.apaw.apicontrollers.*;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.daos.memory.DaoFactoryMemory;

import es.drachodran.apaw.exceptions.ArgumentNotValidException;
import es.drachodran.apaw.exceptions.NotFoundException;
import es.drachodran.apaw.exceptions.RequestInvalidException;
import es.drachodran.apaw.http.HttpRequest;
import es.drachodran.apaw.http.HttpResponse;
import es.drachodran.apaw.http.HttpStatus;
import org.apache.logging.log4j.LogManager;

import static es.drachodran.apaw.apicontrollers.ArtistaApiController.ARTISTAS;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    private ArtistaApiController artistaApiController = new ArtistaApiController();


    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:

                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:

                    break;
                case PATCH:

                    break;
                case DELETE:

                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());
            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    private void doPost(HttpRequest request, HttpResponse response) {
        }


    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.getPath().startsWith("/artistas") ){
            //    response.setBody(this.artistaApiController.readAll());
            // Apaño en el if de abajo, cambiar
        }else if(request.getPath().startsWith(
                ARTISTAS + ArtistaApiController.FINDID )) {
            LogManager.getLogger(Dispatcher.class).debug("   entrando por artista findID" );
            response.setBody(this.artistaApiController.
                    findById(Integer.
                            parseInt(request.getPath(2))) );
        } else if(request.isEqualsPath(ARTISTAS + ArtistaApiController.NOMBRE)) {
            response.setBody(this.artistaApiController.
                    findByName(request.getParams().get("name")));
        }  else
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());

    }

    private void doPut(HttpRequest request) {

    }

    private void doPatch(HttpRequest request) {

    }

    private void doDelete(HttpRequest request) {


    }

}
