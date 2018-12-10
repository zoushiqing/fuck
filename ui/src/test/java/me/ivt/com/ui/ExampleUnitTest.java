package me.ivt.com.ui;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    
    @Test
    public void addition_isCorrect() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.7f, true);
        map.put(0, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        map.get(3);
        map.get(5);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println(integerIntegerEntry.getKey() + "  :   " + integerIntegerEntry.getValue());
        }
    }
}