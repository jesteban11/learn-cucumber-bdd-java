# Commands to run the project
## List of useful commands in this project
### Run all tests
```mvn test```
### Run in a specific cucumber tag
```mvn test -Dcucumber.filter.tags="@PlaceOrder"```
### Run using specific test class
```mvn test -Dtest="FailedTestRunner"```
### Run in specific browser
```mvn test -Dbrowser=firefox```
### Run locally
```mvn test -DrunMode=local```
### Run remote in selenium standalone
```mvn test -DrunMode=remote```

