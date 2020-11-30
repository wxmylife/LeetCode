package com.abby.code

object LeetCode01 {

  @JvmStatic
  fun main(args: Array<String>) {
    twoSum(intArrayOf(3, 2, 4), 6)
  }

  private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    val indexes = IntArray(2)
    for (index in nums.indices) {
      val temp = target - nums[index]
      map[temp]?.let {
        indexes[0] = it
        indexes[1] = index
      }
      map[nums[index]] = index
    }
    return indexes
  }
}
