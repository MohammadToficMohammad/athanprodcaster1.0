 del /F/Q/S output\*  
rmdir /S /Q output
cd ..
cd ..
 del /F/Q/S AuthorizationServiceApiClient\src\main\java\com\*
rmdir /S /Q AuthorizationServiceApiClient\src\main\java\com
cd build\java\
curl http://localhost:8080/v3/api-docs.yaml --output ./apiclient.yaml
REM -g spring for server ,for config https://gist.github.com/appkr/fa2ed27d51563d983bb3942b49d145ea java -jar modules/openapi-generator-cli/target/openapi-generator-cli.jar config-help -g php  ,put them as json file
java -jar ./openapi-generator-cli.jar generate -g java -i   ./apiclient.yaml -o ./output -c AuthSeviceApiClient.json 
cd ..
cd ..
xcopy /E/F/S build\java\output\src\main\java AuthorizationServiceApiClient\src\main\java
