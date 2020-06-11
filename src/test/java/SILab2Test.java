import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {
    private final SILab2 si=new SILab2();

    private List<String> createList(String... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    public void every_branch_test(){
        RuntimeException ex=null;
        try{
            si.function(null,createList("user"));
        } catch (RuntimeException e){
            ex=e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        User user=new User("Ana",null,"ana.gashtarova@yahoo.com");
        RuntimeException ex2=null;
        try{
            si.function(user,createList("user"));
        } catch (RuntimeException e){
            ex=e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        User user2=new User("Ana","AnA123","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user2, createList("user")));

        User user3=new User("Ana","Si123","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user3, createList("user")));

        User user4=new User("Ana","Si123@finKI","ana.gashtarova@yahoo.com");
        assertTrue(si.function(user4, createList("user")));

        User user5=new User("Ana","Si@finKIlab","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user5, createList("user")));

    }



    @Test
    public void every_path_test(){
        RuntimeException ex=null;
        try{
            si.function(null,createList("user"));
        } catch (RuntimeException e){
            ex=e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        User user=new User("Ana",null,"ana.gashtarova@yahoo.com");
        RuntimeException ex2=null;
        try{
            si.function(user,createList("user"));
        } catch (RuntimeException e){
            ex=e;
        }
        assertNotNull(ex);
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        User user2=new User("Ana","AnA123","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user2, createList("user")));

        User user3=new User("Ana","Si123","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user3, createList("user")));

        User user4=new User("Ana","Si123@finKI","ana.gashtarova@yahoo.com");
        assertTrue(si.function(user4, createList("user")));

        User user5=new User("Ana","sifinkilab","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user5, createList("user")));

        User user6=new User("Ana","SI@FINKI123","ana.gashtarova@yahoo.com");
        assertTrue(si.function(user6, createList("user")));

        User user7=new User("Ana","123456789","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user7, createList("user")));

        User user8=new User("Ana","SIFINKILAB","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user8, createList("user")));

        User user9=new User("Ana","!@!@!@!@!@","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user9, createList("user")));

        User user10=new User("Ana","S123FINKILAB","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user10, createList("user")));

        User user11=new User("Ana","1!2!3!4!5","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user11, createList("user")));

        User user12=new User("Ana","S#I!F!N@","ana.gashtarova@yahoo.com");
        assertFalse(si.function(user12, createList("user")));


    }
}
