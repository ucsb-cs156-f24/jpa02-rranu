package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Rajvir", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_id(){
        assertEquals("rranu", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_correct_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f24-10", t.getName());
    }
    
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ajay"),"Team should contain Ajay");
        assertTrue(t.getMembers().contains("Aneesh"),"Team should contain Aneesh");
        assertTrue(t.getMembers().contains("Derrick"),"Team should contain Derrick");
        assertTrue(t.getMembers().contains("Justin"),"Team should contain Justin");
        assertTrue(t.getMembers().contains("Peter"),"Team should contain Peter");
        assertTrue(t.getMembers().contains("Rajvir"),"Team should contain Rajvir");
    }
}
