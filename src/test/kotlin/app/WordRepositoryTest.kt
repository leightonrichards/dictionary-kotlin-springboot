package app

import org.junit.Assert.assertTrue
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import org.junit.runner.RunWith


@RunWith(SpringRunner::class)
@DataJpaTest
class WordRepositoryTest {

    @Autowired
    var wordRepository:WordRepository? = null;


    @Test
    fun testWordCount() {
        val count = wordRepository!!.count()
        System.out.println("number of words " + count)
        assertTrue(count == 187312L)
    }
}