package app

import org.springframework.stereotype.Service

@Service
class WordService(val wordRepository: WordRepository) {
    fun findAll(): List<Word> = wordRepository.findAll()
    fun count() = wordRepository.count()
    fun startswith(token: String) = wordRepository.findAll().filter{ it.word!!.startsWith(token)}
}
