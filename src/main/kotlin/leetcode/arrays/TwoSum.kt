package leetcode.arrays

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}

fun main() {
    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(result.joinToString()) // prints 0,1
}