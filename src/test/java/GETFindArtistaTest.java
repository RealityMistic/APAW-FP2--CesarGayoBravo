import es.drachodran.apaw.apicontrollers.ArtistaApiController;
import es.drachodran.apaw.http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GETFindArtistaTest {

    @Test
    void findByIdArtistaTest(){
        String subpath = ArtistaApiController.ARTISTAS + ArtistaApiController.FINDID + "/1";
        HttpRequest request = new HttpRequest().builder(subpath).get();
        HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
        HttpResponse response = new Client().submit(request);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
    @Test
    void findByNombreArtistaTest(){
        String subpath = ArtistaApiController.ARTISTAS + ArtistaApiController.NOMBRE + "/1";
        HttpRequest request = new HttpRequest().builder(subpath).get();
        HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
        HttpResponse response = new Client().submit(request);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
}
