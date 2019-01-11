
import es.drachodran.apaw.dtos.ConciertoDto;
import es.drachodran.apaw.http.Client;
import es.drachodran.apaw.http.HttpException;
import es.drachodran.apaw.http.HttpRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class PUTConciertoTest {

        // Caso de petición correcta
    LocalDateTime fechaConcierto;
        @Test
        void testCreateConcierto() {
            LocalDateTime fechaConcierto;
            fechaConcierto = LocalDateTime.now();
            ConciertoDto nuevoConciertoDto =  new ConciertoDto(
                    1,
                    fechaConcierto,
                    "TechnoKom",
                    80,
                    90

            );
            HttpRequest request = HttpRequest.
                    builder("").path(CrearConciertoApiController.CONCIERTOS)
                    .body(nuevoConciertoDto).put();

            new Client().submit(request);
        }
    @Test
        // Caso de que se haya hecho Bad Request
    void testFailureConcierto() {
        LocalDateTime fechaConcierto;
        fechaConcierto = LocalDateTime.now();
        ConciertoDto nuevoConciertoDto =  new ConciertoDto(
                1,
                fechaConcierto,
                null,
                80,
                90

        );
        HttpRequest request = HttpRequest.
                builder("").path(CrearConciertoApiController.CONCIERTOS)
                .body(nuevoConciertoDto).put();
        assertThrows(HttpException.class, () -> {
            new Client().submit(request); });
    }
}
