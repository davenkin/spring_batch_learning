spring_batch_learning
=====================

(1) after clone the project, run "mvn package" to get all the things running, including fetch dependencies

(2)under the project root folder, run startHsqlServer.sh to start the Hsql server, the server will create db
   under db-hsql foler which lies under the project root folder

(3)under the project root folder, run viewHsqlServer.sh to open a GUI for the db server. In the GUI, config the
   the url for our Hsql db as "jdbc:hsqldb:hsql://localhost/spring-batch-db", then open createHsqlDB.sql and execute this script. Now all tables for spring batch framework its own are created.

(4)run the tests.