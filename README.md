This is derived from Katalon sample project for WEB APIs 
Added test cases for all six opetations i.e:
  1. Create Post
  2. Get Post by ID
  3. Create comment on a post
  4. See comments on a post by post ID
  5. Create profile
  6. Get Profile

Test cases are written over google sheets and you can find a link here : https://docs.google.com/spreadsheets/d/1zL4WbtsNnxyl2glivVafdXh4aqMlrpeyZ0anxObrtmk/edit#gid=0

Tool used: Katalon Studio
Language: Java 8
Approach: I used helper classes (Keywords) for code reusability.
Object Repository has all the API calls availables
While assertions and Verify statements are available in test cases which validate that API call is valid and response has all the changes available after API call execution. 
Verified new added posts and comments by using GET calls and assert calls are present. 

Test Data feature is also available to get data from files. 
and Environments can also be set up to run code accross multiple environments.


GET and POST methods are used only yet according to requirements
 
