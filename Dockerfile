FROM eclipse-temurin:21-jdk-jammy

COPY target/mcp-client-0.0.1.jar /home/

#ENV OLLAMA_URL="http://host.docker.internal:11434"
ENV VLLM_URL="http://host.docker.internal:8000"
ENV MCP_SERVER_URL="http://host.docker.internal:9091"

CMD ["java", "-jar", "/home/mcp-client-0.0.1.jar"]
#CMD ["sleep", "1000"]
EXPOSE 8080