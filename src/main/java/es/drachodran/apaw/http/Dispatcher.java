package es.drachodran.apaw.http;

import es.drachodran.apaw.apicontrollers.*;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.daos.memory.DaoFactoryMemory;
import es.drachodran.apaw.dtos.AgenteDto;
import es.drachodran.apaw.dtos.AlbumDto;
import es.drachodran.apaw.dtos.ConciertoDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;
import es.drachodran.apaw.exceptions.NotFoundException;
import es.drachodran.apaw.exceptions.RequestInvalidException;
import es.drachodran.apaw.http.http.HttpRequest;
import es.drachodran.apaw.http.http.HttpResponse;
import es.drachodran.apaw.http.http.HttpStatus;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import static es.drachodran.apaw.apicontrollers.AlbumesArtistaApiController.LASTALBUM;
import static es.drachodran.apaw.apicontrollers.ArtistaApiController.ARTISTAS;
import static es.drachodran.apaw.apicontrollers.ArtistaApiController.DELETEID;

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

    }

    private void doPut(HttpRequest request) {

    }

    private void doPatch(HttpRequest request) {

    }

    private void doDelete(HttpRequest request) {


    }

}
