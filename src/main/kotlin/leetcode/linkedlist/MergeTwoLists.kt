package leetcode.linkedlist

import leetcode.linkedlist.model.ListNode

class MergeTwoLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        println("Starting mergeTwoLists")
        var l1 = list1
        var l2 = list2

        val dummy = ListNode(-1)
        var current = dummy

        while (l1 != null && l2 != null) {
            println("Comparing l1: ${l1.`val`} and l2: ${l2.`val`}")
            if (l1.`val` < l2.`val`) {
                println("→ Choosing l1: ${l1.`val`}")
                current.next = l1
                l1 = l1.next
            } else {
                println("→ Choosing l2: ${l2.`val`}")
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }

        if (l1 != null) {
            println("Appending remaining l1 starting from: ${l1.`val`}")
        } else if (l2 != null) {
            println("Appending remaining l2 starting from: ${l2.`val`}")
        }

        current.next = l1 ?: l2

        println("Merge complete")
        return dummy.next
    }
}