package app

import org.springframework.stereotype.Service

@Service
class WordService(val wordRepository: WordRepository) {
    fun count() = wordRepository.count()
    fun findByWordLikeIgnoreCase(word: String) = wordRepository.findByWordLikeIgnoreCase(word)
}
