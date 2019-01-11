import es.drachodran.apaw.apicontrollers.PrecioConciertoApiController;
import es.drachodran.apaw.http.Client;
import es.drachodran.apaw.http.HttpException;
import es.drachodran.apaw.http.HttpRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class PATCHConciertoPrecioTest {

    LocalDateTime fechaConcierto;
    @Test
    void testPatchPrecioOK() {
        HttpRequest request = new HttpRequest().
                builder("")
                .path(PrecioConciertoApiController.PRECIOCONCIERTO)
                .patch();
        request.addQueryParam("idconcierto", "1");
        request.addQueryParam("nuevoprecio", "200");
    }

    @Test
    void testPatchPrecio400() {
        HttpRequest request = new HttpRequest().
                builder("")
                .path(PrecioConciertoApiController.PRECIOCONCIERTO)
                .patch();
        request.addQueryParam("idconcierto", "99");
        request.addQueryParam("nuevoprecio", "200");
        assertThrows(HttpException.class, () -> {
            new Client().submit(request);
        });
    }
}
