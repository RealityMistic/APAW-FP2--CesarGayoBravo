package es.drachodran.apaw.daos;


public interface GenericDao<T> {

    void save(T entity);

 //   Optional<T> read(ID id);

    void deleteById(int id);

}
