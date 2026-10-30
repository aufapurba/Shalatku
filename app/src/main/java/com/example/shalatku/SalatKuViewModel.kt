package com.example.shalatku

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SalatKuViewModel : ViewModel() {

    // --- Tasbih ---
    var tasbihCount by mutableIntStateOf(0)
        private set

    var completedRounds by mutableIntStateOf(0)
        private set

    // Round size: initial 33, UI can read but only the ViewModel can change it
    private var _roundSize by mutableIntStateOf(33)
    val roundSize: Int get() = _roundSize

    // --- Tracker ---
    private val _donePrayers = mutableStateListOf<String>()
    val donePrayers: List<String> get() = _donePrayers

    // --- Tasbih functions ---
    fun incrementTasbih() {
        tasbihCount++
        if (tasbihCount == _roundSize) {
            completedRounds++
            tasbihCount = 0
        }
    }

    fun resetTasbih() {
        tasbihCount = 0
        completedRounds = 0
    }

    // Change target: reset current count, keep completed rounds
    fun setRoundSize(size: Int) {
        _roundSize = size
        tasbihCount = 0
    }

    // --- Tracker functions ---
    fun togglePrayer(name: String) {
        if (name in _donePrayers) _donePrayers.remove(name) else _donePrayers.add(name)
    }

    // Clear all
    fun clearPrayers() {
        _donePrayers.clear()
    }
}