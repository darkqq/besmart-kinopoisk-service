create table movie_actor{
    movie_id UUID not null references movie,
    director_id UUID not null references director,
    primary key (movie_id, director_id)
    }