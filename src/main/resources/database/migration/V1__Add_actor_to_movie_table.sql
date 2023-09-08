create table movie_actor{
    movie_id UUID not null references movie,
    author_id UUID not null references author,
    primary key (movie_id, title_id)
    }