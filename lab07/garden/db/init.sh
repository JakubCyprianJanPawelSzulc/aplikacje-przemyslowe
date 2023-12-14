java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost/workdb
java -cp hsqldb.jar org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
