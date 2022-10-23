package test.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisableTests {
    @Test
    @Disabled
    void test01(){
        assertTrue(true);
    }

    @Test
    @Disabled("Any text here")
    void test02(){
        assertTrue(true);
    }


}
