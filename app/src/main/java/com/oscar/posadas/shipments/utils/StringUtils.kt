package com.oscar.posadas.shipments.utils

object StringUtils {

    fun String.getVowelsCount(): Int {
        var vowels = 0
        val lowerCaseString = this.lowercase()
        for (char in lowerCaseString) {
            if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u') {
                vowels++
            }
        }
        return vowels
    }

    fun String.getConstantsCount(): Int {
        var constants = 0
        val lowerCaseString = this.lowercase()
        for (char in lowerCaseString) {
            if (char in 'a'..'z' && char != 'a' || char != 'e' || char != 'i' || char != 'o' || char != 'u') {
                constants++
            }
        }
        return constants
    }

    /** Excludes one **/
    fun String.getLengthCommonFactors(): List<Int> {
        val commonFactors = mutableListOf<Int>()
        val stringLength = this.length
        for (i in 2..stringLength) {
            if (stringLength % i == 0) {
                commonFactors.add(i)
            }
        }
        return commonFactors
    }
}