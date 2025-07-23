package leetcode.strings

import leetcode.arrays.twoSum
import org.junit.Assert
import org.junit.Test

class MaximumGainTest {

    @Test
    fun testExampleCase() {
        val s = "cdbcbbaaabab"
        val x = 4
        val y = 5

        val result = maximumGain(s, x, y)
        Assert.assertEquals(19, result)
    }
}