package app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "words")
data class Word(
        @Id @GeneratedValue(strategy = IDENTITY)
        var id: Long? = null,
        @Column(name = "word")
        var word: String? = null,
        @Column(name = "word_type")
        var word_type: String? = null,
        @Column(name = "description")
        var description: String? = null
)

@RepositoryRestResource
interface WordRepository : JpaRepository<Word, String>
{
    fun findByWordLikeIgnoreCase(word: String): List<Word>
}