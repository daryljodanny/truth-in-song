package dev.rtrilia.truthinsong.ui.song

import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rtrilia.truthinsong.repository.Repository
import kotlinx.coroutines.launch

class SongViewModel @ViewModelInject constructor(val repository: Repository) : ViewModel() {

    val songId = MutableLiveData<String>()
    val songMalTitle = MutableLiveData<String>()
    val songEngTitle = MutableLiveData<String>()
    val songAuthor = MutableLiveData<String>()
    val songContent = MutableLiveData<Spanned>()

    private val _name = MutableLiveData<String>()

    fun getSong(id: String) {
        viewModelScope.launch {
            val song = repository.getSong(id)
            songId.value = song.song_id
            songMalTitle.value = song.mal_title
            songEngTitle.value = song.eng_title
            songAuthor.value = song.author
            convertHtmlToSpanned(song.content)
        }
    }

    private fun convertHtmlToSpanned(content: String?) {
        content?.let {
            val str = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
            songContent.value = str
        }
    }

    fun setFontSizePref(value: Float) = repository.setFontSizePref(value)
    fun getFontSizePref(): Float = repository.getFontSizePref()

    fun setFontSizeSmallPref(value: Float) = repository.setFontSizeSmallPref(value)
    fun getFontSizeSmallPref(): Float = repository.getFontSizeSmallPref()

}

