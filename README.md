## Overview

Development of an API to produce message queues in RabbitMQ and a microservice to consume the produced messages, also creating a <code>lib</code> to standardize and serialize the messages model.

## Execution

Tools:
<li> Java 11 </li>
<li> SpringBoot 2.7.13 </li>
<li> Docker </li>
<li> RabbitMQ </li>
<br>
<strong>Back-end: </strong>
Import the project to an IDE of your choice, the IDE used in the development was the Netbeans IDE,
so just build the application to download the dependencies which are managed by Maven in the three projects,
but first, Docker must be installed and the container images encoded in the <strong>docker-compose.yml</strong> file initialized,
with the command <code>docker-compose up -d</code>, and when the application is running, just access the link http://localhost:8080/swagger-ui/index.html to analyze the application's endpoints.

