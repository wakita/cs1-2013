package kwakita.cs1.s16prefer_composition;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CountingSetTests {
    private static List<String> campusList = Arrays.asList("大岡山", "すずかけ台", "田町");
    
    private void testA(CountingSet<String> campuses) {
        for (String campus : campusList) campuses.add(campus);
        Assert.assertEquals(campuses.size(), campuses.getCount());
    }
    
    private void testB(CountingSet<String> campuses) {
        campuses.addAll(campusList);
        Assert.assertEquals(campuses.size(), campuses.getCount());
    }
    
    @Test
    public void hashSet1a() {
        testA(new CountingHashSet1<String>());
    }
    
    @Test
    public void hashSet1b() {
        testB(new CountingHashSet1<String>());
    }

    @Test
    public void hashSet2a() {
        testA(new CountingHashSet2<String>());
    }

    @Test
    public void hashSet2b() {
        testB(new CountingHashSet2<String>());
    }

    @Test
    public void set1a() {
        testA(new CountingSet1<String>());
    }

    @Test
    public void set1b() {
        testB(new CountingSet1<String>());
    }

    @Test
    public void set2a() {
        testA(new CountingSet2<String>());
    }

    @Test
    public void set2b() {
        testB(new CountingSet2<String>());
    }
}
