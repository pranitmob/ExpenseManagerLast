# ExpenseManagerLast
Following application is simple backend for Expense Manager App 

use cases:-

1.User can register and login with email and password:
  1.1 http://localhost:8080/user/register :- after hitting this URL with post by following body content :-   
     "firstName": "pranit",
    "lastName": "sakunde",
    "emailId": "pranit@gmail.com",
    "password": "*******",
    "confirmPassword": "*******"
    user will be registered.
    
   1.2 http://localhost:8080/user/loginUser :- after hitting this URL with post by following body content:-
    "emailId": "pranit@gmail.com",
    "password": "*******"
     it will return user details as a payload :-
    "firstName": "pranit",
    "lastName": "sakunde",
    "email": "pranit@gmail.com",
    "password": null,
    "confirmPassword": null
     
      
      
