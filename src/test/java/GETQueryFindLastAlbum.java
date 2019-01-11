import es.drachodran.apaw.apicontrollers.AlbumesArtistaApiController;
import es.drachodran.apaw.http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    // Caso de petición correcta


public class GETQueryFindLastAlbum {
    @Test
    void findLastAlbumOKTest(){
        String subpath = AlbumesArtistaApiController.LASTALBUM;
        HttpRequest request = new HttpRequest().builder(subpath).get();
        HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
        HttpResponse response = new Client().submit(request);

        assertEquals(HttpStatus.OK, response.getStatus());

    }

    @Test
    void findLastAlbum400Test(){
        String subpath = AlbumesArtistaApiController.LASTALBUM + "/asd";
        HttpRequest request = new HttpRequest().builder(subpath).get();
      //  HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
        assertThrows(HttpException.class, ()->{
            new Client().submit(request);
        }
        );
    }

}
