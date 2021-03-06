package pl.edu.agh.wp.orm.session.executor.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.wp.orm.configuration.Configuration;
import pl.edu.agh.wp.orm.session.Session;
import pl.edu.agh.wp.orm.session.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

public class InsertStatementExecutorTest {

    SessionFactory factory;
    @Before
    public void setUp() throws Exception {
        Configuration configuration = new Configuration()
                .addDriverClass("org.postgresql.Driver")
                .addDatabaseUrl("jdbc:postgresql://localhost:5432/postgres")
                .addUser("postgres")
                .addPassword("dare")
                .setAnnotationParsing(true)
                .addScannedPackage("pl.edu.agh");

        factory = configuration.buildSessionFactory();

    }

    @Test
    public void execute() throws Exception {
        String sqlString = "INSERT INTO person (name,lastname,age,birth_date) VALUES ('abba','a',21,'2017-02-10');";
        Connection connection = factory.openSession().getConnection();
        Statement st = connection.createStatement();


        InsertStatementExecutor executor = new InsertStatementExecutor(st);
        Object o = executor.execute(sqlString);
        Assert.assertNotNull(o);
    }

}