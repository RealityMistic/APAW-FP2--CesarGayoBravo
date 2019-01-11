import es.drachodran.apaw.apicontrollers.ArtistaApiController;
import es.drachodran.apaw.http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DELETEArtistaTest {
    @Test
    void deleteByIdArtistaOKTest(){
        HttpRequest request = new HttpRequest().
                builder("").
                path(ArtistaApiController.ARTISTAS + ArtistaApiController.DELETEID).
                delete();
        request.addQueryParam("deleteId", "2");
        HttpResponse response = new Client().submit(request);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
    @Test
    void deleteByIdArtistaThrownTest(){
        String subpath = ArtistaApiController.ARTISTAS + ArtistaApiController.DELETEID ;
        HttpRequest request = new HttpRequest().builder(subpath).delete();
        request.addQueryParam("deleteId", "99");
      //  HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
     //   HttpResponse response = new Client().submit(request);

        assertThrows(HttpException.class, () -> {
                    new Client().submit(request);
                });
    }

}
