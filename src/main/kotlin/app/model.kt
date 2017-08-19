package app

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity @Table(name = "restaurants")
data class Restaurant(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    var name: String? = null,

    var location: String? = null,

    var lat: Double? = null,

    var lng: Double? = null,

    @OneToMany(mappedBy = "restaurant")
    var menus: List<Menu>? = null
)

@Entity @Table(name = "menus")
data class Menu(

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurant: Restaurant? = null,

    @Column(name = "menu_date", columnDefinition = "DATE")
    var date: LocalDate? = null,

    var title: String? = null,

    @Column(name = "menu_text")
    var text: String? = null
)

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