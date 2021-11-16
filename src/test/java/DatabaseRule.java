import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    public void before(){
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker"; //!
        Sql2o sql2o = new Sql2o(connectionString, "simon", "simonalex"); //!
//        Sql2o sql2o = new Sql2o( "jdbc:postgresql://ec2-35-174-122-153.compute-1.amazonaws.com:5432/d7ufipe1qmaj7r", "whtuwmcqjwinns", "341c56107f86582ae179d86bfcd20f78a7f130911806045e6c482354c97345c8");

    }

    @Override
    public void after(){
        try (Connection con = DB.sql2o.open()){

            String deleteAnimalQuery="DELETE FROM animals ";
            String deleteRangerQuery="DELETE FROM rangers";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
            String deleteLocationQuery="DELETE FROM locations *";
            con.createQuery(deleteLocationQuery).executeUpdate();
        }
    }

}
