package app

/**
 * Created by leighton on 18/08/17.
 */
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(Application::class))
class WordcountApplicationTests {

    @Test
    fun contextLoads() {
    }

}
