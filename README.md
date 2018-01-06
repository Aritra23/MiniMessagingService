# Mini messaging service

This project is the backend of a mini-messaging service inspired by Twitter. It is a RESTful Web Application developed from a Spring Boot project and consists of the following endpoints:

GET: View the tweets of the current user and his/her followers
Usage: http://localhost:8080/message

GET: Support of a search parameter that allows to filter tweets in 1
Usage: http://localhost:8080/message/search=xyz (xyz is to be replaced by the desired string)

POST: Write a new tweet
Usage: http://localhost:8080/message/content=xyz (xyz is to be replaced by the desired string)

GET: List of all users being followed by the current user
Usage: http://localhost:8080/following

GET: List of all users following the current user
Usage: http://localhost:8080/followers

GET: List of all users
Usage: http://localhost:8080/people

POST: Follow a user
Usage: http://localhost:8080/people/follow/id (id is the integer value ranging from 1 – 11)

POST: Unfollow a user
Usage: http://localhost:8080/people/unfollow/id (id is the integer value ranging from 1 – 11)

GET: List of all users and most popular follower
Usage: http://localhost:8080/option2
