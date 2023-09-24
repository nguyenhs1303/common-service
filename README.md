# Project template for common use  


## About project
This primary purpose of this project is to be template for project use in sales portal system
Including : 
1. The structure of project
2. How to run local for development
3. How to setup cicd 

## Project Structure

### About the solution we use in this project
1. Data Models
   - A data model describes the various attributes (properties) and relationships within the data, providing a clear and organized structure.
   - In this project every class hold details information of an object is a data model,which must to somehow expressed by java class
   - So we separate model into 3 types : 
     + DTOS: DTOs are used to transfer data between different layers of your application or between the application and external systems. They are used to define the data contract for the API, allowing you to control what data is exposed to the clients.
     + Entity: Entities represent your persistent data structures and are usually mapped to database tables. They reflect the database schema and contain the data access logic.
     + Domain: Domain models are temporary objects used within the service layer to hold and process data. They are different from entities as they are not directly tied to the database schema. Instead, domain models are designed to be more focused on the business logic and requirements of the application.
2. Converter
   - The purpose of a converter is to facilitate the seamless transformation of data between different representations within an application, which mean transform between data models 
   - To convert between data models in this project, we have to define a class called converter, eg : StudentToUserConverter.java
        + With easy convert logic, we can use Mapstruct
        + With more complex logic, we can define custom converter
3. Handle Exception and Error Message
   - We define format message to communicate between client and server (this application can be used as a rest server)
     + Success case
     ```json
       {
         "statusCode": 200,
         "message": "Login success",
         "data":  
          {
            "id": "30082",
            "ic_user": "2210000308",
            "cc_number": "2210000308",
            "bp_number": "0100000214"
          }
       }
     ```
     + Error case
     ```json
     {
       "statusCode": 400,
       "messages": [
       "userName: must not be blank",
       "avatarUrl: must not be null"
       ],
       "errorCode": null,
       "additionalData": null
     }
     ```     
   - Every error within the application must be expressed as an exception, not any other form such as error message or error code
     ```java
        public abstract class BaseCustomException extends RuntimeException {
            private List<String> messages;
            private String errorCode;
            private Map<IError, String> error;

            public abstract HttpStatus getHttpStatus();

            public BaseCustomException() {
            }

            public BaseCustomException(String... messages) {
                this.messages = Arrays.asList(messages);
            }
        }
     ```
     
     ```
     public class NotFoundException extends BaseCustomException {
     
     }
     ```
   - We use a centralized exception handlers to convert from exception to error message format above to return to client 
   - Note: 
     + Every errorCode send back to client must be declared in enum type, best practice is with message
     ```java
        public enum ErrorCodeUl230213 implements IError {
            PASSWORD_IS_INVALID("PASSWORD_IS_INVALID", "Password must at least 8 characters at least one digit, lower, upper case and one special character."),
        }
     ```
     + Status code to return (http status code) set in exception handlers, so in any situation must know what exception want to throw and with what error
4. Validate input 
    - With normal validate, we use annotation on dtos request class, e.g
   ```java
    public class ExampleRequest {
        @NotNull(message = ID_NOT_NULL)
        public UUID id;
    
        @NotNull(message = RATE_NOT_NULL)
        @Min(value = 1, message = RATE_OVER_VALUE_MAX)
        @Max(value = 100, message = RATE_LESS_VALUE_MIN)
        private Integer rate;
    
        @NotNull(message = RELATIONSHIP_WITH_MAIN_BENEFICIARY_NOT_NULL)
        @ValueOfEnum(enumClass = RelationshipWithMainBeneficiary.class, message = RELATIONSHIP_WITH_MAIN_BENEFICIARY_WRONG_VALUE)
        private String relationshipWithMainBeneficiary;
    }
   ```
   Then we define exception handler for handle this type of request
    ```java
        public class ControllerAdvisor {
    
            @ExceptionHandler
            public ResponseEntity<ErrorModel> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, NativeWebRequest request) {
            BindingResult result = ex.getBindingResult();
            List<String> errorMessages = (List)result.getFieldErrors().stream().map((f) -> {
                String var10000 = f.getField();
                return var10000 + ": " + f.getDefaultMessage();
            }).collect(Collectors.toList());
            ErrorModel errorModel = new ErrorModel(HttpStatus.BAD_REQUEST.value(), errorMessages);
            return new ResponseEntity(errorModel, this.header(), HttpStatus.BAD_REQUEST);
            }
        }
   ```
   - With more complex logic, we create a custom validator class for validate and use them in the service, in this situation we must throw an UnprocessableEntityException 
   ```java
    @Component
    public class UserValidator {
    
        public boolean isUserEligibleForPromotion(User user) {
            // Business logic to check if the user is eligible for promotion
            // ...
            return true; // Return true if the user is eligible, false otherwise
        }
    }
   ``` 
   Then use exception handler to resolve it
    ```java
    public class ControllerAdvisor {
        @ExceptionHandler(UnprocessableEntityException.class)
        @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
        public ResponseEntity<String> handleUnprocessableEntityException(UnprocessableEntityException ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }   
    }
    ```

       
### Package Structure
1. Client 
    - This package is using for communicate with other system or other service by using feign client
    - Each system( or microservice ) will be put in a subdomain package of this package
    - [TODO] More details will be added when carefully consider and research for feign client
2. Config 
   - This wil hold any configuration the project need, e.g : 
     + Config for feign client
     + Config for connect like : mail service, database, kafka, etc
     + Config for object mapper
3. Controller
    - Normal controller in spring boot application
4. Converter
   - Use as model mapper to transfer object from dto, entities and domain
     + Use MapStruct for Straightforward Mappings
     + Custom Converter for Complex Mappings
5. Domain
   - Domain class, temporary objects used within the service layer to hold and process data
6. dto
   - DTOs are used to transfer data between different layers of your application or between the application and external systems. They are used to define the data contract for the API, allowing you to control what data is exposed to the clients
   - Separate model between request and response are in subdomain
7. Entity
   - Entities represent your persistent data structures and are usually mapped to database tables. They reflect the database schema and contain the data access logic.
8. Enum
   - Define enumeration type
9. Exception
   - Declaration : Define custom exception use in this application
   - Handler : Define centralize exception handlers use in application
10. Filter 
    - Intercept requests and responses before they reach the controller layer
    - Filters are usually used for tasks like authentication, logging, CORS handling, or request/response modification.
    - Every filter use in app must be defined and set order to control how many filter we use, in which order, with what purpose
11. Interceptor
    - Interceptors are commonly used for tasks like logging, adding common attributes to the model, or enforcing authorization rules.
    - Interceptors use in this application for some common use case like 
      + Intercept before and after handle request for rest server
      + Intercept before and after send request by feign client
      + Intercept before and after handle kafka message
      + Intercept before and after handle schedule task
12. Repository
    - Use to connect to database
    - Three component of repository:
        + Primary: Interface for write database
        + Secondary : Interface for read database
        + Impl : Implement access method to communicate with database
13. Service
    - Hold business logic
    - Two component: 
        + Interface : Every logic service want to expose 
        + Impl : Implement of method in interface and some private method as a helper to implement method in interface
14. Utils
    - Hold common function
    - Mostly use static method
    - MUST NOT: 
      + Never create bean of an util class
      + Check collection null or empty :
        package org.springframework.util;
        public abstract class CollectionUtils
      + Check String null or empty :
       package org.springframework.util;
       public abstract class StringUtils {
### Config Structure
1. This project use
   [Spring Profile](https://mbalinsight.atlassian.net/wiki/spaces/SA/pages/298647996/Guideline+Backend+Spring+profile) to config profile for application
2. In yaml profile, we define at least 4 section for 4 enviroment : 
    - Local (default)
    - Dev
    - Uat
    - Production
   ```
    ---
    # ============================================================
    # DEV
    spring:
      config:
        activate:
          on-profile: dev
   ```
3. Local environment is set as default and all environment is set so developer can run easy on local
    ```
   spring:
     application:
       name: spring-template-service
     profiles:
       default: local
       active: local
   ``` 
4. When running on dev, uat, or prod, some properties must be overridden, so in application.yaml, we define that variable as empty and comment to ensure application cannot run without override it
    ```
   ---
    # ============================================================
    # UAT
    spring:
      config:
        activate:
          on-profile: uat

    datasource:
      url: #provide at runtime
      username: #provide at runtime
      password: #provide at runtime
    sentry:
      environment: uat
      dsn: #provide at runtime
   ```
