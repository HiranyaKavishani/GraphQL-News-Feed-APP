# Spring Boot GraphQL Project

In this repository has a Spring Boot application which has been integrated with GraphiQL IDE to interact with the GraphQL API.
Every 5 minutes the application polls the data from news feed: http://feeds.nos.nl/nosjournaal?format=xml and stores the changes in a h2 database.
Once the application start, it will be available at http://localhost:8080/graphiql/

**HTTP Method: GET**
### /newsFeed/
Also project has been included rest endpoint to receive the news items information that available at database


## Installing and Running

### Prerequisites

- JDK 1.8
- Apache Maven 3.6.0+
- Direct Internet Connection

### Installing

Clone the repository:

````bash
git clone https://github.com/HiranyaKavishani/GraphQL-News-Feed-APP.git
````

Get into the created directory

````bash
cd graphql-news-app-kickstart
````

## Running

Run without packaging

````bash
mvn spring-boot:run
````

Or package and run
````bash
mvn package
java -jar target\graphql-news-app-1.0.jar
````