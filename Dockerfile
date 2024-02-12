# Use a base image with Java8 installed
FROM adoptopenjdk:8-jrehotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the Jar into the container
Copy target/mft-0.0.1-SNAPSHOT.jar /app/app.jar

#Expose the port your springboot app runs on (default is 8080)
#Expose 8080

#Command to run application when container starts
CMD ["java", "-jar", "mft-0.0.1-SNAPSHOT.jar"]
