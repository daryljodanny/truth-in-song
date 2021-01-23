package dev.rtrilia.truthinsong.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.rtrilia.truthinsong.repository.Repository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    fun getUiMode() = repository.getUiModePref()
    fun setUiMode(value: Int) = repository.setUiModePref(value)

    fun getShuffleMode() = repository.getShuffleMode()
    fun setShuffleMode(value: Int) = repository.setShuffleMode(value)

}

