package org.example.triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {

    @Nested
    class Isosceles {
        @Test
        void anArrayWithOnlyTwoEqualSidesShouldReturnAnIsoscelesTriangle() {
            Triangle triangle = new Triangle(new double[]{2.5, 2.5, 3.0});

            boolean isIsosceles = triangle.isIsosceles();

            assertTrue(isIsosceles, "A triangle with 2 equal sides is an isosceles triangle.");
        }
    }

    @Nested
    class Equilateral {
        @Test
        @DisplayName("is an equilateral")
        void aTriangleWithThreeEqualSidesIsAnEquilateral() {
            Triangle triangle = new Triangle(2.0, 2.0, 2.0);

            boolean isEquilateral = triangle.isEquilateral();

            assertTrue(isEquilateral, "A triangle with equal sides is an equilateral triangle.");
        }

        @Test
        @DisplayName("is not an isosceles")
        void aTriangleWithThreeEqualSidesIsNotAnIsosceles() {
            Triangle triangle = new Triangle(2.0, 2.0, 2.0);

            boolean isIsosceles = triangle.isIsosceles();

            assertFalse(isIsosceles, "A triangle with equal sides is NOT an isosceles triangle.");
        }

        @Test
        @DisplayName("is not a scalene")
        void aTriangleWithThreeEqualSidesIsNotAScalene() {
            Triangle triangle = new Triangle(2.0, 2.0, 2.0);

            boolean isScalene = triangle.isScalene();

            assertFalse(isScalene, "A triangle with equal sides is not a scalene triangle.");
        }
    }

    @Nested
    class Scalene {
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
    }


    //Naming suggestions
    //withThreeEqualSidesShouldNotBeAnIsosceles BEST (because dropped "triangle" in method name)
    //givenTriangleWithUnequalSidesThenShouldBeEquilateral
    //scaleneShouldReturnTrue
    //triangleWit2SidesOfEqualLengthShouldBeIsosceles

}
