package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_result_sameobj() {
        assert(team.equals(team));
    }

    @Test
    public void equals_returns_correct_result_diffclass() {
        assert(!team.equals("string"));
    }

    @Test
    public void equals_returns_correct_result_diffname() {
        Team t = new Team("team-test");
        assert(!team.equals(t));
    }

    @Test
    public void equals_returns_correct_result_diffmemb() {
        Team t = new Team("test-team");
        t.addMember("John D.");
        assert(!team.equals(t));
    }

    @Test
    public void equals_returns_correct_results_samefields(){
        Team t = new Team("test-team");
        assert(team.equals(t));
    }

    @Test
    public void hashCode_of_equal_teams_returns_same_hash(){
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_mutation_resilience(){
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
        int result = t.hashCode();
        int expected = 130294;
        assertEquals(expected, result);
    }

}
