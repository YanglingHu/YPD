package YPD.DatabaseOperation;
import java.util.Map;
import javax.sql.rowset.CachedRowSet;
/**
 * A databaseinterface.
 * 
 * @date lastUpdate: 2018/10/16
 * @author Yi Qiu
 */
public interface DatabaseInterface {

    /**
     *
     * @param _destination
     * @return
     */
    public abstract Boolean insertNew(String _destination);

    /**
     *
     * @param _destination
     * @return
     */
    public abstract CachedRowSet getUserDataSet(String _destination);

    /**
     *
     * @param _uuid
     * @param _destination
     * @return
     */
    public abstract Boolean updateObject(String _uuid, String _destination);
    
    /**
     *
     * @param _destination
     * @return
     */
    public abstract Boolean updateObject(String _destination);

    /**
     *
     * @param _uuid
     * @param _destination
     * @return
     */
    public abstract Boolean deleteUserFromDB(String _uuid, String _destination);
    
    /**
     *
     * @param _destination
     * @return
     */
    public abstract Boolean deleteUserFromDB(String _destination);
    
    /**
     *
     * @param _uuid
     * @param _destination
     * @return
     */
    public abstract CachedRowSet getTargetData(String _uuid, String _destination);
    

}