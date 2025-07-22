package leetcode.arrays

import org.junit.Test
import org.junit.Assert.assertArrayEquals

class TwoSumTest {

    @Test
    fun testExampleCase() {
        val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
        assertArrayEquals(intArrayOf(0, 1), result)
    }

    @Test
    fun testNoSolution() {
        val result = twoSum(intArrayOf(1, 2, 3), 6)
        assertArrayEquals(intArrayOf(), result)
    }

    @Test
    fun testMultipleSolutionsButFirstMatch() {
        val result = twoSum(intArrayOf(3, 3, 4, 4), 6)
        assertArrayEquals(intArrayOf(0, 1), result)
    }
}