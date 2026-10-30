package com.example.shalatku

data class SalatKuUiState(
    val prayers: List<Prayer> = samplePrayers,
    val donePrayers: List<String> = emptyList(),
    val tasbihCount: Int = 0,
    val completedRounds: Int = 0,
    val roundSize: Int = 33,
    val prayerTimes: PrayerTimesUiState = PrayerTimesUiState.Success(samplePrayers),
) {
    // Derived state: dihitung dari donePrayers, tidak disimpan terpisah
    val doneCount: Int
        get() = donePrayers.size
}