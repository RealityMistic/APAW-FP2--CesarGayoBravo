package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.ArtistaDao;
import es.drachodran.apaw.entities.Agente;
import es.drachodran.apaw.entities.Artista;
import es.drachodran.apaw.entities.ArtistaBuilder;
import es.drachodran.apaw.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ArtistaDaoMemory extends GenericDaoMemory<Artista> implements ArtistaDao {
    private List<Artista> listaArtistas;

    public ArtistaDaoMemory() {
        listaArtistas = new ArrayList<Artista>(map.values());
        Artista artistaPrimero = new ArtistaBuilder(
                1,"Ped", "Probador", false,
                new Agente(1, "Pepe", "1212")).buildArtista();

        Artista artistaSegundo = new ArtistaBuilder(
                2,"Carlx", "Probador2", true,
                new Agente(1, "Pepe", "1212")).buildArtista();
        map.put(1, artistaPrimero);
        map.put(2, artistaSegundo);

    }

    @Override
    public List<Artista> getArtistaLista(){
        return listaArtistas;

    }


    @Override
    public Artista findArtista(int idArtista){
        if (map.get(idArtista) != null) {
        //    System.out.println("Artista Memory devuelve " + map.get(idArtista).getNombre());
            return map.get(idArtista);
        }else throw new NotFoundException(" no se ha encontrado ese Id de artista.");
    }


    public int getId(Artista artista) {
        Artista miArtista = map.get(artista.getId());
        return miArtista.getId();
    }
    public void setId(Artista artista, int id){
        artista.setId(id);
        map.put(id,artista);
    }
    @Override
    public void setArtista(int idArtista, Artista artista) {
        map.put(idArtista, artista);
    }

    @Override
    public void deleteById(int idArtista){ map.remove(idArtista);}
}
