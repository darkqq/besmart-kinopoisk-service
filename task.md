# Кинопоиск

### Общие требования

1. Система должна хранить фильмы и их описания, отзывы, рейтинги, режиссеров и актеров, кассовые сборы etc.
2. Пользователи должны иметь возможность регистрироваться, авторизовываьтся, искать фильмы, оставлять к ним комментарии, добавлять/удалять/просматривать фильмы в избранном, выставлять рейтинги, читать чужие комментарии, просматривать профили пользователей, искать актеров и просматривать по ним информацию.
3. Модератор должен иметь возможность удалять комментарии, редактировать комментарии, редактировать информацию о фильмах и людях + возможности пользователя.
4. Администратор должен иметь возможность просмотра списка пользователей, блокировки выбранного пользователя, редактирование информации пользователя + возможности модератора.

## Требования к реализации

1. Необходимо макисмально точно описать сущности системы
2. Необходимо реализовать поддержку пагинации и фильтрации на страницах поиска актеров, режиссеров и фильмов.
3. Необходимо настроить роли и авторизацию.
4. !!! Необходимо использовать Swagger для документации эндпойнтов 
```
	<dependency>  
			<groupId>org.springdoc</groupId>  
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>  
			<version>2.0.2</version>  
	</dependency>
```	
5. Необходимо настроить и использовать базу данных PostgreSQL.
6. API системы должно соблюдать приниципы REST
7. Необходимо настроить миграцию данных для возможности переноса базы данных


