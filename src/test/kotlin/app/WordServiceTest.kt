package app

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.junit.Assert.assertEquals
import org.mockito.Matchers
import org.mockito.Mockito.any
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WordServiceTest {

    @Mock
    private var wordRepository: WordRepository? = null;

    @InjectMocks
    private var wordService:WordService? = null;

    @Test
    fun testFindByWordLikeIgnoreCase() {
        givenWordRepository()
        val resultList: List<Word>? = wordService?.findByWordLikeIgnoreCase("abb")
        assertEquals(38, resultList?.size)
    }


    private fun givenWordRepository() {
        `when`(wordRepository?.findByWordLikeIgnoreCase(Matchers.anyString())).thenReturn(getListOfWords())
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