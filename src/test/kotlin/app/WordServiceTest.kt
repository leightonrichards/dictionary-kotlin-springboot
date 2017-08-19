package app

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.junit.Assert.assertEquals
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WordServiceTest {

    @Mock
    private var wordRepository: WordRepository? = null;

    @InjectMocks
    private var wordService:WordService? = null;

    @Test
    fun testStartsWith() {
        givenWordRepository()
        val resultList: List<Word>? = wordService?.startswith("abb")
        assertEquals(17, resultList?.size)
    }


    private fun givenWordRepository() {
        `when`(wordRepository?.findAll()).thenReturn(getListOfWords())
    }

    private fun getListOfWords(): List<Word> {
        return getWords("abacus", "abacuses", "abaft", "abalone", "abalones", "abandon", "abandoned", "abbot", "abbotcies",
                "abbotcy", "abbots", "abbotship", "abbotships", "abbott", "abbr", "abbrev", "abbreviate", "abbreviated", "abbreviates", "abbreviating", "abbreviation", "abbreviations",
                "abbreviator", "abbreviators", "abc", "abdicable", "abdicate", "abdicated", "abdicates", "abdicating", "abdication", "abdications", "abdicator",
                "abdomen", "abdomens", "abdominal", "abdominally", "abduct")
    }

    private fun getWords(vararg words: String): List<Word> {
        var i: Long = 0
        return words.map { Word(i++, it, "v", it + " desc") }
    }
}