FROM eclipse-temurin:17-jdk-jammy

COPY target/mcp.article-0.0.1.jar /home/

ENV OLLAMA_URL="http://host.docker.internal:11434"

CMD ["java", "-jar", "/home/mcp.article-0.0.1.jar"]
#CMD ["sleep", "1000"]
EXPOSE 8080