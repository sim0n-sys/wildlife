import org.sql2o.Sql2o;

public class DB {
    static String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "simon", "simonalex"); //!

//    static String connectionString = "jdbc:postgresql://ec2-44-199-40-188.compute-1.amazonaws.com:5432/d7ahf3qn69ju0m"; //!
//    static Sql2o sql2o = new Sql2o(connectionString, "\n" +
//            "gqolqzxnoggkco", "209f33900d6a5af13b88f0e56b19a5ecd400427e582eb541ba229fc1f58b24ba"); //!

}


