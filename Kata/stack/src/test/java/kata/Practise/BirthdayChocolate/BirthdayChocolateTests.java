package kata.Practise.BirthdayChocolate;
import kata.Practise.Stack.Stack;
import org.junit.Assert;
import  org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BirthdayChocolateTests {

    @Test
    public void nothing(){

    }

    @Test
    public void when_CallBirthday_returnValue(){
        List<Integer> choclateBarArray = new ArrayList<Integer>();
        int dayOfBirth =0;
        int monthOfBirth=0;
        int result =    ChoclateBirthday.birthday(choclateBarArray,dayOfBirth,monthOfBirth);
    }


    @Test
    public void when_CallBirthday_return_Correct_Value(){
        List<Integer> choclateBarArray = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(1);
                add(3);
                add(2);

            }};
        int dayOfBirth = 3 ;
        int monthOfBirth= 2;
        int result =    ChoclateBirthday.birthday(choclateBarArray,dayOfBirth,monthOfBirth);

        Assert.assertEquals(result,2);
    }

    @Test
    public void when_CallBirthday_Have_NoMatchingElements_ShouldReturn_Zero(){
        List<Integer> choclateBarArray = new ArrayList<Integer>(){
            {
                add(1);
                add(1);
                add(1);
                add(1);
                add(1);

            }};
        int dayOfBirth = 3 ;
        int monthOfBirth= 2;
        int result =    ChoclateBirthday.birthday(choclateBarArray,dayOfBirth,monthOfBirth);

        Assert.assertEquals(0,result);
    }

}
