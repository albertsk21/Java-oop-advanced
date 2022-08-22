import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabasePersonTests {

    private Database database;


    @Before
    public void initialize() throws OperationNotSupportedException {
        Person firstPerson = new Person(1,"Andreas");
        Person secondPerson = new Person(3,"Cosmin");
        this.database = new Database(firstPerson,secondPerson);
    }

    // TEST-ADD-METHOD
    @Test(expected = OperationNotSupportedException.class )
    public void addANullPerson() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPeopleWithTheSameId() throws OperationNotSupportedException {
        Person firstPerson = new Person(2,"Alex");
        Person secondPerson = new Person(2,"C");

        this.database.add(firstPerson);
        this.database.add(secondPerson);
    }

    // TEST-REMOVE-METHOD
    @Test(expected = OperationNotSupportedException.class)
    public void removeANullPerson() throws OperationNotSupportedException {
        this.database.remove(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void removeAUnknownPerson() throws OperationNotSupportedException {
        this.database.remove("jcxbvjcbvh");
    }

    @Test
    public void removeARealPerson() throws OperationNotSupportedException {
        this.database.remove("Andreas");
    }

    // TEST-FIND-BY-USERNAME-METHOD
    @Test
    public void findARealUsername() throws OperationNotSupportedException {
    Person person = this.database.findByUsername("Andreas");
    Assert.assertEquals(person, this.database.findByUsername("Andreas"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findANullUsername() throws OperationNotSupportedException {
    Person person = this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findAUnknownUsername() throws OperationNotSupportedException {
    this.database.findByUsername("hjbdvx");
    }

    // TEST-FIND-BY-ID-METHOD
    @Test(expected = OperationNotSupportedException.class)
    public void findAUnknownId() throws OperationNotSupportedException {
        this.database.findById(5);
    }





}
