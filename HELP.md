# List of requests

### Message with one recipient
POST http://localhost:8080/mail/add
Accept: application/json
Cache-Control: no-cache
Content-Type: application/json

{
  "topic": "Test message - one recipient",
  "content": "This is a test of Spring Boot",
  "sender": "sender@example.com",
  "recipients": [
    {
      "email": "recipient1@example.com"
    }
  ],
  "attachments": [],
  "priority": 5
}


### Message with two recipients
POST http://localhost:8080/mail/add
Accept: application/json
Cache-Control: no-cache
Content-Type: application/json

{
  "topic": "Test message - two recipients",
  "content": "This is a test of Spring Boot",
  "sender": "sender@example.com",
  "recipients": [
    {
      "email": "recipient1@example.com"
    },
    {
      "email": "recipient2@example.com"
    }
  ],
  "attachments": [],
  "priority": 5
}


### Check e-email status
GET http://localhost:8080/mail/status/16
Accept: application/json
Cache-Control: no-cache


### Get e-email details
GET http://localhost:8080/mail/get/17
Accept: application/json
Cache-Control: no-cache


### Get all e-emails
GET http://localhost:8080/mail/list
Accept: application/json
Cache-Control: no-cache


### Add e-mail with one attachment
POST http://localhost:8080/mail/add
Accept: application/json
Cache-Control: no-cache
Content-Type: application/json

{
  "topic": "Test message - one attachment",
  "content": "This is a test of Spring Boot",
  "sender": "sender@example.com",
  "recipients": [
    {
      "email": "recipient1@example.com"
    },
    {
      "email": "recipient2@example.com"
    }
  ],
  "attachments": [
    {
      "name": "Spring logo",
      "url": "https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg"
    }
  ],
  "priority": 1
}


### Add e-mail with two attachments
POST http://localhost:8080/mail/add
Accept: application/json
Cache-Control: no-cache
Content-Type: application/json

{
  "topic": "Test message - two attachments",
  "content": "This is a test of Spring Boot",
  "sender": "sender@example.com",
  "recipients": [
    {
      "email": "recipient1@example.com"
    },
    {
      "email": "recipient2@example.com"
    }
  ],
  "attachments": [
    {
      "name": "Spring logo",
      "url": "https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg"
    },
    {
      "name": "Java logo",
      "url": "https://cdn.benchmark.pl/thumbs/uploads/backend_img/a/oracle-sun-java-logo.jpg/475x0x1.jpg"
    }
  ],
  "priority": 1
}


### Send all pending e-emails
PUT http://localhost:8080/mail/sendAll
Accept: application/json
Cache-Control: no-cache
