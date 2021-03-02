import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TachographTest {

    private Tachograph tachograph;

    @Before
    public void setUp() throws Exception {

        tachograph = new Tachograph();
    }

    @Test
    public void addData() {
        tachograph.addData(LocalDateTime.now(),20,40);
        tachograph.addData(LocalDateTime.now(),30,50);
        Assert.assertEquals(2,tachograph.getSize());
    }
}