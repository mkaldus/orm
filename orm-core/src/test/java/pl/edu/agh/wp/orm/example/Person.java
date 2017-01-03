package pl.edu.agh.wp.orm.example;

import pl.ed.agh.wp.orm.annotations.DBColumn;
import pl.ed.agh.wp.orm.annotations.DBTable;
import pl.ed.agh.wp.orm.annotations.Temporal;
import pl.ed.agh.wp.orm.annotations.Type;
import pl.ed.agh.wp.orm.annotations.enums.TemporalType;

import java.util.Date;

@DBTable
public class Person {

    public Person(){
        firstname ="Mati";
        lastname ="xd";
        age = 20;
        date = new Date();
    }

    public Person(String fName,String lName){
        firstname = fName;
        lastname =lName;
        age =20;
        date = new Date();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }

    @DBColumn(name = "name")
    private String firstname ;

    @DBColumn(name = "lastname")
    private String lastname ;

    @DBColumn(name = "age")
    private Integer age;

    @DBColumn(name = "birth_date")
    @Temporal(type = TemporalType.DATE)
    private Date date ;

    public String toString() {
        return "Person: " + firstname + " " + lastname + " " + age + " " + date.toString();
    }
}
