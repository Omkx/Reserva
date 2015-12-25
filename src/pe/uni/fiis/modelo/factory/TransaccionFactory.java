package pe.uni.fiis.modelo.factory;

import pe.uni.fiis.modelo.dao.Jdbc.TransaccionDAOJdbc;
import pe.uni.fiis.modelo.dao.TransaccionDAO;

/**
 * Created by javier on 28/11/2014.
 */
public abstract class TransaccionFactory {
    private  static TransaccionDAO dao = null;

    public  static TransaccionDAO getInstance(){
        if(dao == null){
            dao = new TransaccionDAOJdbc();
        }
        return dao;
    }
}
