package JUnitActivities;

import java.util.ArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class Activity1Test {
        static ArrayList<String> list;
        @BeforeEach
        public void SetUp() throws Exception
        {
            list = new ArrayList<String>();
            list.add("alpha");
            list.add("beta");
        }
        @Test
        public void insertTest()
        {
            assertEquals(2,list.size(),"Wrong size");
            list.add("gama");
            assertEquals(3,list.size(),"Wrong size");
            assertEquals("alpha",list.get(0));
            assertEquals("beta",list.get(1));
            assertEquals("gama",list.get(2));
        }
        @Test
        public void replaceTest()
        {
            list.set(1,"beta2");
            assertEquals(2,list.size(),"Wrong size");
            assertEquals("alpha",list.get(0));
            assertEquals("beta2", list.get(1));
        }
}
