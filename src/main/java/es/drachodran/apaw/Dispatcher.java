package es.drachodran.apaw;

import es.drachodran.apaw.apicontrollers.*;
import es.drachodran.apaw.daos.DaoFactory;
import es.drachodran.apaw.daos.memory.DaoFactoryMemory;

import es.drachodran.apaw.dtos.AgenteDto;
import es.drachodran.apaw.dtos.AlbumDto;
import es.drachodran.apaw.dtos.ConciertoDto;
import es.drachodran.apaw.exceptions.ArgumentNotValidException;
import es.drachodran.apaw.exceptions.NotFoundException;
import es.drachodran.apaw.exceptions.RequestInvalidException;
import es.drachodran.apaw.http.HttpRequest;
import es.drachodran.apaw.http.HttpResponse;
import es.drachodran.apaw.http.HttpStatus;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import static es.drachodran.apaw.apicontrollers.ArtistaApiController.ARTISTAS;
import static es.drachodran.apaw.apicontrollers.ArtistaApiController.DELETEID;

public class Dispatcher {

    static {
        DaoFactory.setFactory(new DaoFactoryMemory());
    }

    private ArtistaApiController artistaApiController = new ArtistaApiController();

    private AgenteApiController agenteApiController = new AgenteApiController();

    private AlbumesArtistaApiController albumesArtistaApiController = new AlbumesArtistaApiController();

    private CrearConciertoApiController crearConciertoApiController = new CrearConciertoApiController();

    private PrecioConciertoApiController precioConciertoApiController = new PrecioConciertoApiController();


    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
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
        if (request.isEqualsPath(AlbumesArtistaApiController.ALBUMES)) {
            response.setBody(albumesArtistaApiController.addAlbumes( 1, (List<AlbumDto>) request.getBody() ) );
        } else if (request.isEqualsPath(AgenteApiController.AGENTE)) {
            this.agenteApiController.addAgente(1, (AgenteDto) request.getBody());
        } else
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
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
        } else if(request.isEqualsPath(AlbumesArtistaApiController.LASTALBUM))
        {
            response.setBody(this.albumesArtistaApiController.findLastAlbum());
        }else
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());

    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(CrearConciertoApiController.CONCIERTOS )) {
            this.crearConciertoApiController.create(
                    (ConciertoDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.getPath().startsWith(PrecioConciertoApiController.PRECIOCONCIERTO)) {
            if (request.getParams().get("idconcierto") != null
                    && request.getParams().get("nuevoprecio") != null ){
                this.precioConciertoApiController.patchPrecio(
                        Integer.parseInt(
                                request.getParams().get("idconcierto")
                        ),
                        Integer.parseInt(
                                request.getParams().get("nuevoprecio")
                        )
                );
            } else throw new ArgumentNotValidException("Parameters not correct");
        } else throw new RequestInvalidException("Route not correct for PATCH API");

    }

    private void doDelete(HttpRequest request) {
        if (request.getPath().startsWith(ARTISTAS + DELETEID )) {
            LogManager.getLogger(Dispatcher.class).debug("   entrando por artista deleteById" );
            if ( artistaApiController
                    .findById(Integer.parseInt(request.getParams()
                            .get("deleteId"))) != null )
            {
                this.artistaApiController.deleteById(Integer.parseInt(request.getParams().get("deleteId")) );
            }else {
                throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath() +
                        " no contiene un id correcto.");
            }
        }

    }

}
