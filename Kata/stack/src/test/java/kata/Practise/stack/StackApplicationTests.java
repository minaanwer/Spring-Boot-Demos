package kata.Practise.stack;
import kata.Practise.Stack.Stack;
import org.junit.Assert;
import  org.junit.Test;

public class StackApplicationTests {

    @Test
    public void nothing() throws  Exception {

    }

    @Test
    public void createStack () throws  Exception{
        Stack stack = new Stack();
        Assert.assertTrue(stack.isEmpty());
    }






}
