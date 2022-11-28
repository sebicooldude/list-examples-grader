import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
class Longerthan5 implements StringChecker{
  public boolean checkString(String s){
    if(s.length() > 5){
      return true;
    }
    return false;
  }
}
public class TestListExamples {
  int score = 0;
  // Write your grading tests here!
  @Test
  public void testFilter(){
    List<String> a = new ArrayList<>();
    List<String> expected = new ArrayList<>();
    a.add("Hello");
    a.add("Monkey");
    a.add("hi");
    a.add("bye");
    a.add("Super duper");
    expected.add("Monkey");
    expected.add("Super duper");
    Longerthan5 sc = new Longerthan5();
    if(expected.equals(ListExamples.filter(a,sc))){
      score++;
    }
    assertEquals(expected, ListExamples.filter(a, sc));

  }
  @Test
  public void testMerge(){
    List<String> a = new ArrayList<>();
    List<String> b = new ArrayList<>();
    a.add("a");
    b.add("b");
    a.add("b");
    a.add("c");
    a.add("d");
    b.add("c");
    List<String> expected = new ArrayList<>(); 
    expected.add("a");
    expected.add("b");
    expected.add("b");
    expected.add("c");
    expected.add("c");
    expected.add("d");
    if(expected.equals(ListExamples.merge(a,b))){
      score++;
    }
    assertEquals(expected, ListExamples.merge(a,b));
  }
}
