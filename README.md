## Asignatura: *Ingenieria Web: APAW*
#### [Master en Ingenieria Web por la U.P.M.](http://miw.etsisi.upm.es)

#### Tecnologias necesarias
* Java
* Maven
* IntelliJ
* GitHub

### Descripcion
Implementacion de APIs con HTTP simulado sobre clases Java

1. API 
Metodo: GET  
Rutas:  /artista  
        /artisita/{id]  
Controlador: ArtistaApiController  
En el primer api se obtiene un objeto ArrayList de ArtistaDto y en el segundo
se obtiene un objeto correspondiente a la entidad artista segun el ID que se 
pasa como parametro URL en la ruta /artista/{id}

1. API  
Metodo: POST  
Ruta: /agente   
Controlador: AgenteApiController  
Se adjunta un objento de tipo  Agente (0..1) para insertarse como
entidad relacionada con la entidad Artista.

1. API  
Metodo: POST  
Ruta: /albumes   
Controlador: AlbumesArtistaApiController  
Se pasa en el cuerpo una lista de objetos Albumes (AlbumDto, de tipo ArrayList)
para aniadirlo a un artista cuyo Id se deberia pasar, pero por simplicidad se ha añadido
1 en el dispatcher para referenciar el objeto Artista que existe por defecto (se crea en el 
constructor).

1. API  
Metodo: PUT  
Ruta: /conciertos  
Controlador: CrearConciertoApiController   
Crea o modifica un objeto de la entidad Concierto pasado en el cuerpo por PUT

1. API
Metodo: DELETE
Ruta: /artista/deleteid
Controlador: ArtistaApiController
Borra de la memoria el artista cuyo id se pasa en el parametro "deleteId".
1. API
Metodo: GET Query
Ruta: /lastalbum
Controlador: AlbumesArtistaApiController  
Devuelve el ultimo por fecha de los existentes en el mapa de memoria, por defecto en el contructor
se crean dos y el API cuando es llamado devuelve el segundo que es el que se crea en ultimo lugar.

1. API  
Metodo: PATCH   
Ruta: /concierto/precio  
Se modifica una entidad concierto asignandole un precio superior o conservando
el actual si es superior al que se pasa en el parametro del API.
 


"# APAW-PF2--CesarGayoBravo"