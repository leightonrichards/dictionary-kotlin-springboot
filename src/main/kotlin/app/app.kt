package app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
open class Application


@RestController
class WordController(val wordService: WordService) {
    @GetMapping("/word/regex/{mask}")
    fun regex(@PathVariable("mask") mask: String): List<Word> {
        val regex = Regex(mask)
        val findAll = wordService.findAll();
        return findAll.filter { regex.containsMatchIn(it.word!!) }
    }

    @GetMapping("/word/startswith/{token}")
    fun startswith(@PathVariable("token") token: String): List<Word> {
        return wordService.startswith(token);
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
