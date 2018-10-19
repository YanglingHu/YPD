package YPD.DatabaseOperation;

import java.util.Map;
import javax.sql.rowset.CachedRowSet;

/**
 * This is a databaseinterface that allow progarm to modify and get data from
 * mySQL database.
 *
 * @date lastUpdate: 2018/10/16
 * @author Yi Qiu
 */
public interface DatabaseInterface {

    public abstract Boolean insertNew(String _destination);

    public abstract CachedRowSet getUserDataSet(String _destination);

    public abstract Boolean updateObject(String _uuid, String _destination);
    
    public abstract Boolean updateObject(String _destination);

    public abstract Boolean deleteUserFromDB(String _uuid);
    
    public abstract Boolean deleteUserFromDB();
    
    public abstract CachedRowSet getTargetData(String _uuid, String _destination);
    

}