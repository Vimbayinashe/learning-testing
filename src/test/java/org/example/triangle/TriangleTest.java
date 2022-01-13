package org.example.triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {

    @Test
    void aTriangleWithThreeEqualSidesIsAnEquilateral() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        boolean isEquilateral = triangle.isEquilateral();

        assertTrue(isEquilateral, "A triangle with equal sides is an equilateral triangle.");
    }

    @Test
    void aTriangleWithThreeEqualSidesIsNotAnIsosceles() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        boolean isIsosceles = triangle.isIsosceles();

        assertFalse(isIsosceles, "A triangle with equal sides is NOT an isosceles triangle.");
    }

    @Test
    void aTriangleWithThreeEqualSidesIsNotAScalene() {
        Triangle triangle = new Triangle(2.0, 2.0, 2.0);

        boolean isScalene = triangle.isScalene();

        assertFalse(isScalene, "A triangle with equal sides is not a scalene triangle.");
    }

    @Test
    void anArrayWithOnlyTwoEqualSidesShouldReturnAnIsoscelesTriangle() {
        Triangle triangle = new Triangle(new double[]{2.5, 2.5, 3.0});

        boolean isIsosceles = triangle.isIsosceles();

        assertTrue(isIsosceles, "A triangle with 2 equal sides is an isosceles triangle.");
    }

    @Test
    void aTriangleFromThreePointsWithUnequalLengthsIsAScalene() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 7), new Point(3, 9));

        boolean isScalene = triangle.isScalene();

        assertTrue(isScalene, "A triangle with 3 unequal sides is a scalene triangle.");
    }

    @Test
    void anArrayOfThreePointsWithUnequalLengthsIsAScalene() {
        Point[] points = {new Point(0, 0), new Point(2, 7), new Point(3, 9)};
        Triangle triangle = new Triangle(points);

        boolean isEquilateral = triangle.isEquilateral();

        assertFalse(isEquilateral, "A triangle with 3 unequal sides is NOT an equilateral triangle.");
    }

    //Naming suggestions
    //withThreeEqualSidesShouldNotBeAnIsosceles BEST (because dropped "triangle" in method name)
    //givenTriangleWithUnequalSidesThenShouldBeEquilateral
    //scaleneShouldReturnTrue
    //triangleWit2SidesOfEqualLengthShouldBeIsosceles

}
