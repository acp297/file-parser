# Steps to run.

1. Clone this repo : https://github.com/acp297/file-parser.git

2. Navigate to the repository.

3. Run the command in your terminal : ```mvn clean install```

Main Class : com.demo.parser.driver.App

## Below are the command line argument for respective jobs :

### READ & WRITE
```--sourcePath src/main/resources/employee.xml --sourceType xml --targetPath src/main/resources/UpdatedEmployee.xml --targetType xml --jobType read ```

### ADD
```--sourcePath src/main/resources/employee.xml --sourceType xml --targetPath src/main/resources/UpdatedEmployee.xml --targetType xml --jobType update --updateType add --updateSourcePath src/main/resources/edit-employee.xml```

### DELETE
```--sourcePath src/main/resources/employee.xml --sourceType xml --targetPath src/main/resources/UpdatedEmployee.xml --targetType xml --jobType update --updateType delete --updateSourcePath src/main/resources/edit-employee.xml```

### MODIFY
```--sourcePath src/main/resources/employee.xml --sourceType xml --targetPath src/main/resources/UpdatedEmployee.xml --targetType xml --jobType update --updateType modify --updateSourcePath src/main/resources/edit-employee.xml```
