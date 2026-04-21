# Bookstore API

A RESTful API built with Spring Boot for managing books and authors.

## Tech Stack
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Maven

## How to Setup and run locally
using the git CLI
```bash
git clone <repo-url>
cd BookStoreService
mvn clean install
mvn spring-boot:run
```


## API

## Add Book
```http
POST /books
Content-Type: application/json
```

Request Body
```json
{
    "isbn": "978-0-306-40615-7",
    "title": "Harry Potter Reboot",
    "year": 2025,
    "price": 10.99,
    "genre": "Comedy",
    "authors": [
        {
            "name": "Alex Rowling",
            "birthday": "1990-05-21"
        }
    ]
}
```

Response Body
```
{
    "authors": [
        {
            "birthday": "1990-05-21",
            "name": "Alex Rowling"
        }
    ],
    "genre": "Comedy",
    "isbn": "978-0-306-40615-7",
    "price": 10.99,
    "title": "Harry Potter Reboot",
    "year": 2025
}
```

## Get Books (Search by title and/or author)

```http
GET /books?title={title}&author={author}
GET /books?title={title}
GET /books?author={author}
```
Response Body
```
[
    {
        "authors": [
            {
                "birthday": "1990-05-21",
                "name": "Alex Rowling"
            }
        ],
        "genre": "Comedy",
        "isbn": "978-0-306-40615-7",
        "price": 10.99,
        "title": "Harry Potter Reboot",
        "year": 2025
    }
]
```

## Update Book
requirements were not clear, an update may mean partial or full
but I decide to do a PATCH for full update instead
```http
PATCH /books/{isbn}
Content-Type: application/json
```
Request Body
```
{
  "title": "Harry Botter Reboot",
  "year": 2026,
  "price": 15.99,
  "genre": "Comedy",
  "authors": [
    {
      "name": "alex",
      "birthday": "1990-05-21"
    }
  ]
}
```

Response Body
```
{
    "authors": [
        {
            "birthday": "1990-05-21",
            "name": "alex"
        }
    ],
    "genre": "Comedy",
    "isbn": "978-0-306-40615-7",
    "price": 15.99,
    "title": "Harry Botter Reboot",
    "year": 2026
}
```

## Delete Book
Only the admin user is able to run this API
In PostMan Under Authorization, Under Auth Type set it to Basic Auth and fill in as follow 
Username: admin
Password: admin123

```http
DELETE /books/{isbn}
```

Response Body will be empty with a 204 which means successful
```
{
 
}