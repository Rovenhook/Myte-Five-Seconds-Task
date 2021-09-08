package com.rovenhook.mytefivesecondstask

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NumberViewModel : ViewModel() {
    private var currentNumber: Int = 15
    private val numbers: ArrayList<String> =
        arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
    private val deletedNumbers: ArrayList<String> = arrayListOf()

    private val livedata: MutableLiveData<ArrayList<String>> =
        MutableLiveData<ArrayList<String>>(numbers)

    init {
        viewModelScope.launch {
            while (true) {
                delay(5000)
                addNumber()
            }
        }
    }

    fun getNumbersList(): MutableLiveData<ArrayList<String>> {
        return livedata
    }

    fun deleteNumber(valueToDelete: String) {
        deletedNumbers.add(valueToDelete)
        numbers.remove(valueToDelete)
        livedata.value = numbers
    }

    fun addNumber() {
        val randomPosition = if (numbers.size > 1) {
            (0 until numbers.size).random()
        } else {
            0
        }
        var numberToAdd: String = ""
        if (deletedNumbers.isNotEmpty()) {
            numberToAdd = deletedNumbers[0]
            deletedNumbers.removeAt(0)
            //     numbers.add(strN)
        } else {
            currentNumber++
            numberToAdd = currentNumber.toString()
        }
        numbers.add(randomPosition, numberToAdd)
        livedata.value = numbers
    }
}