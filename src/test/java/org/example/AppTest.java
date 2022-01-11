package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void test() {
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("Sum should return three for input one and two")
    void sumOfOneAndTwoReturnsThree() {
        //given when then / arrange act assert

        //arrange
        App app = new App();

        //act
        int result = app.sum(1, 2);

        //assert
        assertEquals(3, result, "Sum should return 1 + 2 = 3");
    }

}