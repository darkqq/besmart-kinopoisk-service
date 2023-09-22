create table movie_director{
    movie_id UUID not null references movie,
    author_id UUID not null references author,
    primary key (movie_id, director_id)
    }