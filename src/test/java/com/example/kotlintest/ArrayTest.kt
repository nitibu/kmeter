package test.java.com.example.kotlintest

import org.junit.Test

class ArrayTest {

    @Test
    fun testDeleteDuplicateItemInArray() {
        var nums = intArrayOf(1, 2, 2, 3, 3, 4, 5)
        val count = removeDuplicates(nums)
        println(nums.contentToString())
        println(nums.copyOfRange(0, count).contentToString())

    }

    @Test
    fun testRunBlocking() {
        println("start")
//        runBlocking {
//
//        }
    }

    fun removeDuplicates(nums: IntArray): Int {
        // 当A.isEmpty为null的时候返回true
        if (nums.isEmpty() ?: true) {
            return 0
        }
        var left = 0
        for (right in 1..nums.size-1) {
            if (nums[left] != nums[right]) nums[++left] = nums[right]
        }
        return left+1
    }

}