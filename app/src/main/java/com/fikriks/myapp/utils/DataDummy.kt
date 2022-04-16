package com.fikriks.myapp.utils

import com.fikriks.myapp.data.source.local.entity.MovieEntity
import com.fikriks.myapp.data.source.local.entity.TvEntity
import com.fikriks.myapp.data.source.remote.response.MovieResponse
import com.fikriks.myapp.data.source.remote.response.TvResponse
import java.util.ArrayList

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            "A Star Is Born",
            "A Star Is Born merupakan salah satu film Amerika Serikat karya sutradara Frank Pierson, film ini film remake dari film yang berjudul sama pada tahun 1954. Film ini dirilis pada 17 Desember1976. Film ini dibintangi antara lain ialah Barbra Streisand, Kris Kristofferson, Gary Busey, dan masih banyak lagi.",
            "139 Menit",
            "1976",
            "7/10",
            "romance, drama, music",
            "Frank Pierson")
        )
        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Alita",
            "Alita: Battle Angel adalah sebuah film aksi cyberpunk Amerika Serikat tahun 2019 berdasarkan pada seri manga karya Yukito Kishiro, Gunnm atau Battle Angel Alita. Diproduksi oleh James Cameron dan Jon Landau, film tersebut disutradarai oleh Robert Rodriguez dari sebuah skenario karya Cameron, Rodriguez dan Laeta Kalogridis. Rosa Salazar sebagai Alita, seorang cyborg (robot manusia), dengan pemeran pendukung seperti Christoph Waltz, Jennifer Connelly, Mahershala Ali, Ed Skrein, Jackie Earle Haley dan Keean Johnson.r.",
            "122 Menit",
            "2019",
            "9/10",
        "animation, action, adventure",
        "Robert Rodriguez")
        )
        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "Aquaman",
            "Aquaman adalah film pahlawan super Amerika tahun 2018 yang didasarkan pada karakter DC Comics, Aquaman, dan didistribusikan oleh Warner Bros. Pictures. Ini adalah angsuran keenam di DC Extended Universe (DCEU). Film ini disutradarai oleh James Wan, dengan skenario oleh David Leslie Johnson-McGoldrick dan Will Beall, dan didasarkan pada sebuah cerita dari Geoff Johns, Wan dan Beall. Ini dibintangi Jason Momoa sebagai karakter judul, dengan Amber Heard, Willem Dafoe, Patrick Wilson, Dolph Lundgren, Yahya Abdul-Mateen II, dan Nicole Kidman dalam peran pendukung.",
            "143 Menit",
            "2018",
            "9/10",
        "action, fantasy, adventure",
        "James Wan")
        )
        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "Cold Pursuit",
            "Cold Pursuit adalah sebuah film Amerika Serikat yang dirilis tahun 2019. Disutradarai oleh Hans Petter Moland (dalam debut Hollywood-nya) dari skenario oleh Frank Baldwin. Pemain utamanya di film ini adalah Liam Neeson, Tom Bateman, Tom Jackson, Emmy Rossum, Domenick Lombardozzi, Julia Jones dan masih banyak lagi.",
            "118 Menit",
            "2019",
            "6/10",
            "action, crime, drama",
            "Hans Petter Moland"
        )
        )
        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
            "Creed",
            "Creed adalah sebuah film drama olahraga Amerika tahun 2015 yang disutradarai oleh Ryan Coogler dan ditulis oleh Coogler dan Aaron Covington. Sebagai sebuah spin-off dan sekuel dari serial film Rocky,[3][4][5] film tersebut dibintangi oleh Michael B. Jordan sebagai Adonis Johnson Creed, putra Apollo Creed, dengan Sylvester Stallone mempersembahkan kembali peran Rocky Balboa.",
            "133 Menit",
            "2015",
            "3/10",
        "drama, sport",
        "Ryan Coogler")
        )

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "Fantastic Beasts: The Crimes of Grindelwald adalah sebuah film Amerika Serikat yang dirilis pada tahun 2018. Film yang disutradarai oleh David Yates ini pemainnya antara lain adalah Eddie Redmayne, Katherine Waterston, Dan Fogler dan masih banyak lagi. Film ini dirilis pada tanggal 16 November 2018 di Britania Raya dan Amerika Serikat.",
            "134 Menit",
            "2018",
            "6/10",
            "adventure, fantasy",
            "David Yates")
        )

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            "Glass",
            "Glass adalah film thriller superhero psikologis Amerika Serikat tahun 2019[6] yang ditulis dan disutradarai oleh M. Night Shyamalan, yang juga diproduksi bersama Jason Blum, Marc Bienstock dan Ashwin Rajan.",
            "98 Menit",
            "2019",
            "6/10",
            "mystery and thriller, drama",
            "M. Night Shyamalan")
        )

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
            "How To Train Dragon",
            "How to Train Your Dragon adalah film fantasi aksi animasi komputer Amerika 2010 yang berdasarkan pada buku tahun 2003 dengan nama yang sama oleh penulis Inggris Cressida Cowell, diproduksi oleh DreamWorks Animation dan didistribusikan oleh Paramount Pictures.",
            "149 Menit",
            "2010",
            "8/10",
            "animation, action, adventure",
            "Chris Sanders & Dean DeBlois")
        )

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "Infinity War",
            "Avengers: Infinity War adalah film pahlawan super Amerika 2018 yang didasarkan pada tim superhero Marvel Comics the Avengers, diproduksi oleh Marvel Studios dan didistribusikan oleh Walt Disney Studios Motion Pictures.",
            "149 Menit",
            "2018",
            "8/10",
            "adventure, action, fantasy",
            "Anthony Russo & Joe Russo")
        )

        movies.add(
            MovieEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
            "Marry Queen",
            "Mary Queen of Scots adalah film drama sejarah 2018 yang disutradarai oleh Josie Rourke (dalam debutnya sebagai sutradara) dan dengan skenario oleh Beau Willimon berdasarkan biografi John Guy tahun 2004, Queen of Scots: The True Life of Mary Stuart.",
            "125 Menit",
            "2018",
            "6/10",
            "biography, drama, history",
            "Josie Rourke")
        )

        return movies
    }

    fun generateDummyTvs(): List<TvEntity> {

        val tvs = ArrayList<TvEntity>()

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "Arrow",
                "Arrow adalah serial televisi Amerika yang dikembangkan oleh Greg Berlanti, Andrew Kreisberg, dan Geoff Johns, yang mengudara di The CW. Serial ini didasari tokoh DC Comics Green Arrow (Oliver Queen), seorang pahlawan super berkostum, penumpas-kejahatan yang bersenjatakan busur dan panah. Serial ini menceritakan Oliver Queen, playboy miliuner yang pascaterdampar lima tahun di pulau terpencil, kembali pulang bersenjatakan busur dan panah untuk menumpas kejahatan di Kota Star sebagai vigilante rahasia bernama Green Arrow.",
                "2012",
                "7/10",
                "action, drama, mystery")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg",
                "Doom Patrol",
                "Kehadiran Elasti-Woman, Robotman, dan Negative Man di dalam serial Titans  rupanya cukup untuk membuat para penggemar komik, terutama DC Comics, kegirangan. Pasalnya, ketiganya adalah anggota dari tim superhero terkenal yang telah muncul semenjak tahun 1963: Doom Patrol. Rupa-rupanya kehadiran tiga anggota Doom Patrol di dalam Titans ini bukan hanya sekedar fan-service, namun juga menjadi salah satu rencana DC untuk membawa petualangan para anggota superhero “misfit” ini ke dalam layanan streaming mereka, DC Universe. Hal ini dapat dilihat melalui teaser trailer Doom Patrol yang muncul di internet.",
                "1963",
                "8/10",
                "superhero, comedy, drama")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eg2CakFFQh3dvujVj2qYCe7ybvK.jpg",
                "Dragon Ball",
                "Dragon Ball Super adalah sebuah seri manga dan anime Jepang. Garis besar alur cerita keseluruhannya ditulis oleh Akira Toriyama sebagai pencipta waralaba Dragon Ball, dan merupakan sekuel dari manga Dragon Ball manga aslinya dan seri televisi Dragon Ball Z. Manga ini ditulis oleh Toriyama dan diilustrasikan oleh Toyotarou serta mulai dimuat berseri dalam majalah manga shōnen V Jump terbitan Shueisha sejak bulan Juni 2015. Adaptasi berupa seri anime yang diproduksi oleh Toei Animation ditayangkan pada saluran Fuji TV sejak tanggal 5 Juli 2015 hingga 25 Maret 2018. Anime-nya mengikuti garis besar cerita keseluruhan yang ditulis oleh Toriyama, sedangkan episode-episode tunggal ditulis oleh penulis skenario yang berbeda.",
                "2015",
                "7/10",
                "adventure, fantasy, martial arts")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yALr5dH77suFz4klaWsPzCbPOai.jpg",
                "Fairy Tail",
                "Fairy Tail adalah sebuah seri manga shōnen Jepang yang ditulis dan diilustrasikan oleh Hiro Mashima. Manga ini dimuat berseri dalam majalah Weekly Shōnen Magazine sejak bulan Agustus 2006 hingga Juli 2017, dan telah diterbitkan menjadi 63 volume tankōbon oleh Kodansha. Ceritanya mengisahkan tentang Natsu Dragneel, anggota dari guild penyihir[4] populer bernama Fairy Tail, yang bertualang di Earth-land dalam tujuannya untuk mencari seekor naga bernama Igneel.",
                "2006",
                "8/10",
                "adventure, fantasy")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                "Family Guy",
                "Family Guy adalah serial televisi sitkom animasi Amerika yang dibuat oleh Seth MacFarlane untuk Fox Broadcasting Company. Seri ini berpusat pada Griffin, sebuah keluarga yang terdiri dari orang tua Peter dan Lois; anak-anak mereka, Meg, Chris, dan Stewie; dan anjing peliharaan antropomorfik mereka, Brian. Pertunjukan ini terletak di kota fiksi Quahog, Rhode Island, dan memamerkan banyak humor surealis dan gelapnya[2] dalam bentuk lelucon lucu metafik yang sering melecehkan budaya Amerika.",
                "1999",
                "8/10",
                "animation, comedy")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "The Flash adalah sebuah serial televisi yang akan datang Amerika yang dikembangkan oleh penulis/produser Greg Berlanti, Andrew Kreisberg dan Geoff Johns, udara di The CW. Serial ini akan didasarkan pada karakter DC Comics Flash (Barry Allen), seorang superhero kejahatan-pejuang berkostum yang diciptakan oleh Robert Kanigher, John Broome dan Carmine Infantino. Serial ini adalah spin-off dari Arrow, yang ada di alam semesta yang sama.",
                "2014",
                "7/10",
                "drama, action, adventure")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "Game Of Thrones",
                "Game of Thrones adalah serial televisi drama fantasi Amerika Serikat yang diciptakan oleh David Benioff dan D. B. Weiss untuk saluran HBO. Serial ini merupakan adaptasi dari A Song of Ice and Fire, seri novel fantasi karangan George R. R. Martin, novel pertama adalah A Game of Thrones.",
                "2011",
                "9/10",
                "action, fantasy, adventure")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg",
                "Gotham",
                "Gotham adalah serial televisi drama kriminal Amerika Serikat yang dikembangkan oleh Bruno Heller, berdasarkan karakter yang diterbitkan oleh DC Comics dan muncul dalam waralaba Batman, terutama yang milik James Gordon dan Bruce Wayne. Heller dan Danny Cannon, yang mengarahkan pilot, adalah produser eksekutif.",
                "2014",
                "8/10",
                "action, crime, drama")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Grey's Antomy",
                "Grey’s Anatomy merupakan salah satu film seri Amerika Serikat produksi The Touchstone Pictures, film serial ini pertama kali diputar di stasiun televisi ABC dan terdiri atas 147 episode (2005-2011). Serial ini menceritakan tentang karakter utamanya, Dr. Meredith Grey (diperankan oleh Ellen Pompeo), dalam kesehariannya sebagai ahli bedah bersama teman-temannya.",
                "2005",
                "7/10",
                "drama, medic")
        )

        tvs.add(
            TvEntity("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                "Hanna",
                "Hanna adalah serial televisi streaming drama aksi Amerika, berdasarkan film 2011 dengan nama yang sama, untuk Prime Video. Serial ini dibuat dan ditulis oleh David Farr, disutradarai oleh Sarah Adina Smith, dan dibintangi oleh Esme Creed-Miles dan Mireille Enos.",
                "2011",
                "7/10",
                "action, drama")
        )

        return tvs
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                        "A Star Is Born",
                        "A Star Is Born merupakan salah satu film Amerika Serikat karya sutradara Frank Pierson, film ini film remake dari film yang berjudul sama pada tahun 1954. Film ini dirilis pada 17 Desember1976. Film ini dibintangi antara lain ialah Barbra Streisand, Kris Kristofferson, Gary Busey, dan masih banyak lagi.",
                        "139 Menit",
                        "1976",
                        "7/10",
                        "romance, drama, music",
                        "Frank Pierson")
        )
        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                        "Alita",
                        "Alita: Battle Angel adalah sebuah film aksi cyberpunk Amerika Serikat tahun 2019 berdasarkan pada seri manga karya Yukito Kishiro, Gunnm atau Battle Angel Alita. Diproduksi oleh James Cameron dan Jon Landau, film tersebut disutradarai oleh Robert Rodriguez dari sebuah skenario karya Cameron, Rodriguez dan Laeta Kalogridis. Rosa Salazar sebagai Alita, seorang cyborg (robot manusia), dengan pemeran pendukung seperti Christoph Waltz, Jennifer Connelly, Mahershala Ali, Ed Skrein, Jackie Earle Haley dan Keean Johnson.r.",
                        "122 Menit",
                        "2019",
                        "9/10",
                        "animation, action, adventure",
                        "Robert Rodriguez")
        )
        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                        "Aquaman",
                        "Aquaman adalah film pahlawan super Amerika tahun 2018 yang didasarkan pada karakter DC Comics, Aquaman, dan didistribusikan oleh Warner Bros. Pictures. Ini adalah angsuran keenam di DC Extended Universe (DCEU). Film ini disutradarai oleh James Wan, dengan skenario oleh David Leslie Johnson-McGoldrick dan Will Beall, dan didasarkan pada sebuah cerita dari Geoff Johns, Wan dan Beall. Ini dibintangi Jason Momoa sebagai karakter judul, dengan Amber Heard, Willem Dafoe, Patrick Wilson, Dolph Lundgren, Yahya Abdul-Mateen II, dan Nicole Kidman dalam peran pendukung.",
                        "143 Menit",
                        "2018",
                        "9/10",
                        "action, fantasy, adventure",
                        "James Wan")
        )
        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                        "Cold Pursuit",
                        "Cold Pursuit adalah sebuah film Amerika Serikat yang dirilis tahun 2019. Disutradarai oleh Hans Petter Moland (dalam debut Hollywood-nya) dari skenario oleh Frank Baldwin. Pemain utamanya di film ini adalah Liam Neeson, Tom Bateman, Tom Jackson, Emmy Rossum, Domenick Lombardozzi, Julia Jones dan masih banyak lagi.",
                        "118 Menit",
                        "2019",
                        "6/10",
                        "action, crime, drama",
                        "Hans Petter Moland"
                )
        )
        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
                        "Creed",
                        "Creed adalah sebuah film drama olahraga Amerika tahun 2015 yang disutradarai oleh Ryan Coogler dan ditulis oleh Coogler dan Aaron Covington. Sebagai sebuah spin-off dan sekuel dari serial film Rocky,[3][4][5] film tersebut dibintangi oleh Michael B. Jordan sebagai Adonis Johnson Creed, putra Apollo Creed, dengan Sylvester Stallone mempersembahkan kembali peran Rocky Balboa.",
                        "133 Menit",
                        "2015",
                        "3/10",
                        "drama, sport",
                        "Ryan Coogler")
        )

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                        "Fantastic Beasts: The Crimes of Grindelwald",
                        "Fantastic Beasts: The Crimes of Grindelwald adalah sebuah film Amerika Serikat yang dirilis pada tahun 2018. Film yang disutradarai oleh David Yates ini pemainnya antara lain adalah Eddie Redmayne, Katherine Waterston, Dan Fogler dan masih banyak lagi. Film ini dirilis pada tanggal 16 November 2018 di Britania Raya dan Amerika Serikat.",
                        "134 Menit",
                        "2018",
                        "6/10",
                        "adventure, fantasy",
                        "David Yates")
        )

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                        "Glass",
                        "Glass adalah film thriller superhero psikologis Amerika Serikat tahun 2019[6] yang ditulis dan disutradarai oleh M. Night Shyamalan, yang juga diproduksi bersama Jason Blum, Marc Bienstock dan Ashwin Rajan.",
                        "98 Menit",
                        "2019",
                        "6/10",
                        "mystery and thriller, drama",
                        "M. Night Shyamalan")
        )

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                        "How To Train Dragon",
                        "How to Train Your Dragon adalah film fantasi aksi animasi komputer Amerika 2010 yang berdasarkan pada buku tahun 2003 dengan nama yang sama oleh penulis Inggris Cressida Cowell, diproduksi oleh DreamWorks Animation dan didistribusikan oleh Paramount Pictures.",
                        "149 Menit",
                        "2010",
                        "8/10",
                        "animation, action, adventure",
                        "Chris Sanders & Dean DeBlois")
        )

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                        "Infinity War",
                        "Avengers: Infinity War adalah film pahlawan super Amerika 2018 yang didasarkan pada tim superhero Marvel Comics the Avengers, diproduksi oleh Marvel Studios dan didistribusikan oleh Walt Disney Studios Motion Pictures.",
                        "149 Menit",
                        "2018",
                        "8/10",
                        "adventure, action, fantasy",
                        "Anthony Russo & Joe Russo")
        )

        movies.add(
                MovieResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                        "Marry Queen",
                        "Mary Queen of Scots adalah film drama sejarah 2018 yang disutradarai oleh Josie Rourke (dalam debutnya sebagai sutradara) dan dengan skenario oleh Beau Willimon berdasarkan biografi John Guy tahun 2004, Queen of Scots: The True Life of Mary Stuart.",
                        "125 Menit",
                        "2018",
                        "6/10",
                        "biography, drama, history",
                        "Josie Rourke")
        )

        return movies
    }

    fun generateRemoteDummyTvs(): List<TvResponse> {

        val tvs = ArrayList<TvResponse>()

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                        "Arrow",
                        "Arrow adalah serial televisi Amerika yang dikembangkan oleh Greg Berlanti, Andrew Kreisberg, dan Geoff Johns, yang mengudara di The CW. Serial ini didasari tokoh DC Comics Green Arrow (Oliver Queen), seorang pahlawan super berkostum, penumpas-kejahatan yang bersenjatakan busur dan panah. Serial ini menceritakan Oliver Queen, playboy miliuner yang pascaterdampar lima tahun di pulau terpencil, kembali pulang bersenjatakan busur dan panah untuk menumpas kejahatan di Kota Star sebagai vigilante rahasia bernama Green Arrow.",
                        "2012",
                        "7/10",
                        "action, drama, mystery")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nclcURTdlqVbDr6HPmrHC5X4qUu.jpg",
                        "Doom Patrol",
                        "Kehadiran Elasti-Woman, Robotman, dan Negative Man di dalam serial Titans  rupanya cukup untuk membuat para penggemar komik, terutama DC Comics, kegirangan. Pasalnya, ketiganya adalah anggota dari tim superhero terkenal yang telah muncul semenjak tahun 1963: Doom Patrol. Rupa-rupanya kehadiran tiga anggota Doom Patrol di dalam Titans ini bukan hanya sekedar fan-service, namun juga menjadi salah satu rencana DC untuk membawa petualangan para anggota superhero “misfit” ini ke dalam layanan streaming mereka, DC Universe. Hal ini dapat dilihat melalui teaser trailer Doom Patrol yang muncul di internet.",
                        "1963",
                        "8/10",
                        "superhero, comedy, drama")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eg2CakFFQh3dvujVj2qYCe7ybvK.jpg",
                        "Dragon Ball",
                        "Dragon Ball Super adalah sebuah seri manga dan anime Jepang. Garis besar alur cerita keseluruhannya ditulis oleh Akira Toriyama sebagai pencipta waralaba Dragon Ball, dan merupakan sekuel dari manga Dragon Ball manga aslinya dan seri televisi Dragon Ball Z. Manga ini ditulis oleh Toriyama dan diilustrasikan oleh Toyotarou serta mulai dimuat berseri dalam majalah manga shōnen V Jump terbitan Shueisha sejak bulan Juni 2015. Adaptasi berupa seri anime yang diproduksi oleh Toei Animation ditayangkan pada saluran Fuji TV sejak tanggal 5 Juli 2015 hingga 25 Maret 2018. Anime-nya mengikuti garis besar cerita keseluruhan yang ditulis oleh Toriyama, sedangkan episode-episode tunggal ditulis oleh penulis skenario yang berbeda.",
                        "2015",
                        "7/10",
                        "adventure, fantasy, martial arts")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yALr5dH77suFz4klaWsPzCbPOai.jpg",
                        "Fairy Tail",
                        "Fairy Tail adalah sebuah seri manga shōnen Jepang yang ditulis dan diilustrasikan oleh Hiro Mashima. Manga ini dimuat berseri dalam majalah Weekly Shōnen Magazine sejak bulan Agustus 2006 hingga Juli 2017, dan telah diterbitkan menjadi 63 volume tankōbon oleh Kodansha. Ceritanya mengisahkan tentang Natsu Dragneel, anggota dari guild penyihir[4] populer bernama Fairy Tail, yang bertualang di Earth-land dalam tujuannya untuk mencari seekor naga bernama Igneel.",
                        "2006",
                        "8/10",
                        "adventure, fantasy")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                        "Family Guy",
                        "Family Guy adalah serial televisi sitkom animasi Amerika yang dibuat oleh Seth MacFarlane untuk Fox Broadcasting Company. Seri ini berpusat pada Griffin, sebuah keluarga yang terdiri dari orang tua Peter dan Lois; anak-anak mereka, Meg, Chris, dan Stewie; dan anjing peliharaan antropomorfik mereka, Brian. Pertunjukan ini terletak di kota fiksi Quahog, Rhode Island, dan memamerkan banyak humor surealis dan gelapnya[2] dalam bentuk lelucon lucu metafik yang sering melecehkan budaya Amerika.",
                        "1999",
                        "8/10",
                        "animation, comedy")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                        "The Flash",
                        "The Flash adalah sebuah serial televisi yang akan datang Amerika yang dikembangkan oleh penulis/produser Greg Berlanti, Andrew Kreisberg dan Geoff Johns, udara di The CW. Serial ini akan didasarkan pada karakter DC Comics Flash (Barry Allen), seorang superhero kejahatan-pejuang berkostum yang diciptakan oleh Robert Kanigher, John Broome dan Carmine Infantino. Serial ini adalah spin-off dari Arrow, yang ada di alam semesta yang sama.",
                        "2014",
                        "7/10",
                        "drama, action, adventure")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "Game Of Thrones",
                        "Game of Thrones adalah serial televisi drama fantasi Amerika Serikat yang diciptakan oleh David Benioff dan D. B. Weiss untuk saluran HBO. Serial ini merupakan adaptasi dari A Song of Ice and Fire, seri novel fantasi karangan George R. R. Martin, novel pertama adalah A Game of Thrones.",
                        "2011",
                        "9/10",
                        "action, fantasy, adventure")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5tSHzkJ1HBnyGdcpr6wSyw7jYnJ.jpg",
                        "Gotham",
                        "Gotham adalah serial televisi drama kriminal Amerika Serikat yang dikembangkan oleh Bruno Heller, berdasarkan karakter yang diterbitkan oleh DC Comics dan muncul dalam waralaba Batman, terutama yang milik James Gordon dan Bruce Wayne. Heller dan Danny Cannon, yang mengarahkan pilot, adalah produser eksekutif.",
                        "2014",
                        "8/10",
                        "action, crime, drama")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                        "Grey's Antomy",
                        "Grey’s Anatomy merupakan salah satu film seri Amerika Serikat produksi The Touchstone Pictures, film serial ini pertama kali diputar di stasiun televisi ABC dan terdiri atas 147 episode (2005-2011). Serial ini menceritakan tentang karakter utamanya, Dr. Meredith Grey (diperankan oleh Ellen Pompeo), dalam kesehariannya sebagai ahli bedah bersama teman-temannya.",
                        "2005",
                        "7/10",
                        "drama, medic")
        )

        tvs.add(
                TvResponse("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
                        "Hanna",
                        "Hanna adalah serial televisi streaming drama aksi Amerika, berdasarkan film 2011 dengan nama yang sama, untuk Prime Video. Serial ini dibuat dan ditulis oleh David Farr, disutradarai oleh Sarah Adina Smith, dan dibintangi oleh Esme Creed-Miles dan Mireille Enos.",
                        "2011",
                        "7/10",
                        "action, drama")
        )

        return tvs
    }
}