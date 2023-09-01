create table movie_user_favorite{
    movie_id UUID not null references movie,
    user_id UUID not null references aplication_user,
    primary key (movie_id, user_id)
    }