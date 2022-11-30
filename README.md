Build the project using 'mvn clean package' command. 
Make sure the ping-app-serverless-0.1.jar is built inside the target folder.

Once the jar is ready, go to AWS Console and follow the steps to deploy the Jar to Lambda:

1. Create a Lambda Function named 'PingLambda' with Runtime 'Java 8 on Amazon Linux 1'
2. Upload the jar
3. Under Runtime Settings, edit Handler value to: com.verisk.tutorial.serverless.PingLambda::handleRequest

Then go to API Gateway and follow the steps to build and deploy an API Gateway:

1. Create a new REST API Gateway with name 'Ping-API'
2. Under resources, create '/ping' resources
3. Then, create a GET method under it. Select Lambda function, check 'Use Lambda Proxy Integration' and select the above created Lambda function.
4. Test the method
5. Repeat the same for /hello resource.
6. Deploy the API on 'sbox' stage

