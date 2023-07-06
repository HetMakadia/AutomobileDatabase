You can open this ENTIRE FOLDER in Visual Studio Code or IntelliJ IDEA. It is pre-configured to work with either, as long as you open the FOLDER CONTAINING THIS FILE. Do not open any other folder, including the folder that contains the folder that contains this file.

Before running the code, you must open the file src/META-INF/persistence.xml. Find the line with the property "jakarta.persistence.jdbc.password". Change the value to your PostgreSQL password. You should not have to change anything else, unless you did something wacky when installing Postgres.

Next, create a new Schema in Datagrip.

You should now be able to run this application.
