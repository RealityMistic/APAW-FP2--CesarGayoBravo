import es.drachodran.apaw.apicontrollers.AlbumesArtistaApiController;
import es.drachodran.apaw.dtos.AlbumDto;
import es.drachodran.apaw.entities.GeneroMusical;
import es.drachodran.apaw.http.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class POSTAlbumTest {

    @Test
    void addAlbumesTest(){
        List<AlbumDto> listaAlbumDto = new ArrayList<AlbumDto>();
        AlbumDto albumDto = new AlbumDto(5,LocalDateTime.now(), GeneroMusical.CANCION_LIGERA);

        listaAlbumDto.add(albumDto);

        String subpath = AlbumesArtistaApiController.ALBUMES;
        HttpRequest request = new HttpRequest().
                builder(subpath).
                body(listaAlbumDto).
                post();
        HttpException exception = new HttpException(HttpStatus.BAD_REQUEST, "Excepción HTTP Bad");
        HttpResponse response = new Client().submit(request);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
}
