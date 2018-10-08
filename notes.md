# RESTful Web Services

Social Media Application

Users -> Posts
1   ->  (n)

- Retrieve all Users    - GET /users
- Create a User         - POST /users
- Retrieve one User     - GET /users/{id}   -> /users/1
- Delete a User         - DELETE /users/{id}    -> /users/1 

- Retrieve all posts for a User     - GET /users/{id}/posts
- Create a post for a User          - POST /users/{id}/posts
- Retrieve details of a post        - GET /users/{id}/posts/{post_id}




1. Add a Services
2. Add the resource

 1. To validate a form we need to add 2 things
    - Add the @Valid anotation in the resource method
    - Add the validation types Size, Past in the User entity


#### INTERNATIONALIZATION 

##### Configuration
- LocalResolver
    - Default Locale - Locale.US
- ResourceBundleMessageSource

##### USAGE
- Autowire MessageSource
- @RequestHeader(value = "Accept-Language", required = false) Locale locale
- messageSource.getMessage("helloWorld.message", null, locale)

Completed until #29

### Versioning

 - Media type versioning (a.k.a. "content negotiation" or "accept header")
    - GitHub
 - (Custom) Header Versioning
    - Microsoft
 - URI Versioning
    - Twitter
 - Parameter Versioning
    - Amazon
 - Factors
    - URI Pollution
    - Misuse of HTTP headers
    - Caching
    - Can we execute the request on browser?
    - API Documentation
 - No Perfect Solution
 
 
 MYSQL
 =====
 create table user (
    id integer not null,
    birth_date timestamp,
    name varchar(255),
    primary key (id)
 )