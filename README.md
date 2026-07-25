# SpringAI Ollama MCP Client

A minimal **Model Context Protocol (MCP) Client** example built with **Spring Boot**, **Spring AI**, and **Ollama**. This project demonstrates how to:
 
* Run a local LLM using **Ollama** (e.g., Llama, Mistral, Gemma)
* Retrieve relevant context from a MCP Server (refer to this MCP Server repo: https://github.com/kgalal88/SpringAI-MCP-Server)
* Provide an API for answering user questions over your data

---

## 🚀 Features

* **Spring Boot 3+** application using Spring AI
* **Ollama** as the local LLM backend
* **REST endpoints** to query your documents
* **Dockerfile** included for containerization
* Lightweight, easy to extend

---

## 📦 Project Structure

```
SpringAI-Ollama-MCP-Client/
├── src/main/java/...       # Spring Boot source code
├── src/main/resources/     # Configuration, application.yml
├── pom.xml                  # Maven dependencies
├── Dockerfile               # Container build
├── setup.txt                # Setup notes / instructions
└── README.md                # Project documentation
```

---

## 🧰 Prerequisites

* **Java 21+**
* **Maven 3.9+**
* **Ollama** installed locally → [https://ollama.ai](https://ollama.ai)
* Run the MCP Server in this repo: https://github.com/kgalal88/SpringAI-MCP-Server
* (Optional) **Docker**

---

## 🔧 Setup Instructions

1. **Run the MCP Server**

Please refer to this repo: https://github.com/kgalal88/SpringAI-MCP-Server

2. **Install Ollama**

```bash
curl -fsSL https://ollama.ai/install.sh | sh
```

3. **Pull an LLM Model** (example: llama3)

```bash
ollama pull llama3
```

4. **Run the Model**

```bash
ollama run llama3
```

5. **Build the Project**

```bash
mvn clean package -DskipTests
```

6. **Run the Spring Boot Application**

```bash
java -jar target/springai-ollama-mcp.jar
```

---

## 📚 API Endpoints

### **POST /api/mcp/query**

Send a question and receive an answer augmented with indexed context.

Example Request:

```json
{
  "query": "What is in the repository?"
}
```

Example Response:

```json
{
  "answer": "This project contains a Spring Boot MCP example..."
}
```

---

## 🐳 Docker Support

To build the container:

```bash
docker build -t chat-mcp-ollama:latest .
```

To run:

```bash
docker run -d -p 9092:8080 --name my-ai-mcp-ollama-app chat-mcp-ollama:latest
```

> Ensure that the container can reach your **local Ollama instance**. You may need to expose Ollama with `OLLAMA_HOST=0.0.0.0`.

---

## 🧪 Testing the MCP Client Flow

You can test via Postman, curl, or any HTTP tool:

```bash
curl -X POST http://localhost:8080/api/mcp/query \
  -H "Content-Type: application/json" \
  -d '{"query": "get all user profiles"}'
```
<img width="649" height="665" alt="image" src="https://github.com/user-attachments/assets/c3641a6f-3016-432b-8389-5fccbd25a2eb" />

---

```bash
curl -X POST http://localhost:8080/api/mcp/query \
  -H "Content-Type: application/json" \
  -d '{"query": "get all user activities for U001"}'
```
<img width="760" height="588" alt="image" src="https://github.com/user-attachments/assets/0d789abd-1822-49df-9c12-a33f45f9943a" />


---

## 🛠 Configuration

Edit `application.yml` to modify:

* Ollama host
* Model name
* MCP Server config
* Logging & performance

---

## 📄 License

This project is open-source under the **Apache-2.0 License**.

---

## 👤 Author

**Khalid Galal**

**https://www.linkedin.com/in/khalidgalal**
