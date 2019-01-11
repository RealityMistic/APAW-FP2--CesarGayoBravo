package es.drachodran.apaw.daos.memory;

import es.drachodran.apaw.daos.AgenteDao;
import es.drachodran.apaw.entities.Agente;

public class AgenteDaoMemory extends GenericDaoMemory<Agente> implements AgenteDao
{

        @Override
        public int getId(Agente agente) {
            return agente.getId();
        }

        @Override
        public void setId(Agente agente, int id) {
            agente.setId(id);
        }
        @Override
        public void addAgente(Agente agente){

                map.put(agente.getId(), agente);
        }


}