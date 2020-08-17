package com.kata.stringcal.stringcal;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringCalTests {
    @Test
    public void SumEmptyString_shouldReturn_0() {
        int result = StringCalculator.sum("");
        assertThat(result, is(0));
    }

    @Test
    public void SumString_WithOne_digit_Return_itself() {
        assertThat(StringCalculator.sum("5"), is(5));
        assertThat(StringCalculator.sum("42"), is(42));
    }

    @Test
    public void SumString_withTwoNumbers_Return_thierSum() {
        assertThat(StringCalculator.sum("1,2"), is(3));
    }

    @Test
    public void SumString_withAnyNumbers_Return_thierSum() {
        assertThat(StringCalculator.sum("1,2,3"), is(6));
        assertThat(StringCalculator.sum("100,200,300"), is(600));
        assertThat(StringCalculator.sum("0,20,200,300"), is(520));
    }
}