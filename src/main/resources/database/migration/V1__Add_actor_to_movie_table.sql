create table movie_actor{
    movie_id UUID not null references movie,
    title_id UUID not null references actor,
    primary key (movie_id, title_id)
    }