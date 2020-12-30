# apde-back-spring

Back-end application for the Spring course project, 2020-2021.

## Team

Emilien Lambert  
Dylan Li-Cho  
Maxime Nicolas  
Nicolas Kleinhentz

## Installation

First, clone this repo using a terminal :

```shell
$ git clone https://github.com/Dylanlicho/apde-back-spring.git
```

Then launch the APDEApplication class using IntelliJ IDEA under *apde-back-spring/src/main/java/fr/univlorraine/apde/*.

The back-end application will be served under the 8080 port.

To delete the repository, first make sure that the application is stopped, then move to the parent folder and you will be able to delete the project :

```shell
$ cd ..
$ rm -rf apde-back-spring
```

## Paths

### User

* /users : returns all the users
* /user/id : returns the specific user where id is the id of the user
* /user/login/login : returns the specific user where login is the login of the user
* /existUser/id : returns whether the specific user exists or not
* /countUsers : returns the count of all the users
* /addUser : adds a new user
* /deleteUserByUser : deletes a user given this specific user
* /deleteUserById : deletes a user given his specific id

### Article

* /articles : returns all the articles
* /article/id : returns the specific article where id is the id of the article
* /article/seller/seller : returns the specific article where seller is the id of the seller of the article
* /existArticle/id : returns whether the specific article exists or not
* /countArticles : returns the count of all the articles
* /addArticle : adds a new article and returns the created article
* /deleteArticleByArticle : deletes a article given this specific article
* /deleteArticleById : deletes a article given his specific id

### Category

* /categories : returns all the categories
* /category/id : returns the specific category where id is the id of the category
* /existCategory/id : returns whether the specific category exists or not
* /countCategories : returns the count of all the categories
* /addCategory : adds a new category
* /deleteCategoryByCategory : deletes a category given this specific category
* /deleteCategoryById : deletes a category given his specific id

### OfCategory

OfCategory is the relation between an article and it's category.

* /ofCategories : returns all the ofCategories
* /ofCategory/id : returns the specific ofCategory where id is the id of the ofCategory
* /existOfCategory/id : returns whether the specific ofCategory exists or not
* /countOfCategories : returns the count of all the ofCategories
* /addOfCategory : adds a new ofCategory
* /deleteOfCategoryByOfCategory : deletes a ofCategory given this specific ofCategory
* /deleteOfCategoryById : deletes a ofCategory given his specific id

### Participation

Participation is the relation between a user and a bid.

* /participations : returns all the participations
* /participation/id : returns the specific participation where id is the id of the participation
* /participation/best/idArticle : returns the best participation along an article, meaning the highest price
* /existParticipation/id : returns whether the specific participation exists or not
* /countParticipations : returns the count of all the participation
* /addParticipation : adds a new participation
* /deleteParticipationByParticipation : deletes a participation given this specific participation
* /deleteParticipationById : deletes a participation given his specific id

## Related repositories

The front-end application is located at https://github.com/Dylanlicho/apde-front-spring .
