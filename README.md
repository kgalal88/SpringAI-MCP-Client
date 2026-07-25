# SpringAI Ollama RAG

A minimal **Retrieval-Augmented Generation (RAG)** example built with **Spring Boot**, **Spring AI**, and **Ollama**. This project demonstrates how to:

* Run a local LLM using **Ollama** (e.g., Llama, Mistral, Gemma)
* Index documents using embeddings
* Retrieve relevant context from a vector store
* Augment a model prompt with retrieved context
* Provide an API for answering user questions over your data

---

## 🚀 Features

* **Spring Boot 3+** application using Spring AI
* **Ollama** as the local LLM backend
* **RAG pipeline** (Embeddings → Vector Store → Retrieval → LLM)
* **REST endpoints** to query your documents
* **Dockerfile** included for containerization
* Lightweight, easy to extend

---

## 📦 Project Structure

```
SpringAI-Ollama-RAG/
├── src/main/java/...       # Spring Boot source code
├── src/main/resources/     # Configuration, application.yml
├── pom.xml                  # Maven dependencies
├── Dockerfile               # Container build
├── setup.txt                # Setup notes / instructions
└── README.md                # Project documentation
```

---

## 🧰 Prerequisites

* **Java 17+**
* **Maven 3.9+**
* **Ollama** installed locally → [https://ollama.ai](https://ollama.ai)
* (Optional) **Docker**

---

## 🔧 Setup Instructions

1. **Install Ollama**

```bash
curl -fsSL https://ollama.ai/install.sh | sh
```

2. **Pull an LLM Model** (example: llama3)

```bash
ollama pull llama3
```

3. **Run the Model**

```bash
ollama run llama3
```

4. **Build the Project**

```bash
mvn clean package -DskipTests
```

5. **Run the Spring Boot Application**

```bash
java -jar target/springai-ollama-rag.jar
```

---

## 📚 API Endpoints

### **POST /api/rag/query**

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
  "answer": "This project contains a Spring Boot RAG example..."
}
```

---

## 📘 How RAG Works in This Project

1. **Documents** are loaded from `/resources/data` or another location
2. **Embeddings** are generated using the model via Spring AI
3. Embeddings are stored in a **vector store** (in-memory or persistent)
4. For every user query:

   * Similar documents are retrieved using cosine similarity
   * Retrieved context is injected into the model prompt
   * Ollama generates an answer

---

## 🐳 Docker Support

To build the container:

```bash
docker build -t chat-rag-ollama:latest .
```

To run:

```bash
docker run -d -p 9092:8080 --name my-ai-rag-ollama-app --net elastic chat-rag-ollama:latest
```

> Ensure that the container can reach your **local Ollama instance**. You may need to expose Ollama with `OLLAMA_HOST=0.0.0.0`.

---

## 🧪 Testing the RAG Flow

You can test via Postman, curl, or any HTTP tool:

```bash
curl -X POST http://localhost:8080/api/rag/query \
  -H "Content-Type: application/json" \
  -d '{"query": "Explain the RAG architecture."}'
```

---

## 🛠 Configuration

Edit `application.yml` to modify:

* Ollama host
* Model name
* Vector store type
* Embedding model
* Logging & performance

---

## 🌱 Future Enhancements

* File upload endpoint for dynamic ingestion
* Support for PostgreSQL/Redis vector stores
* Chunking strategies
* Metadata filtering
* Streaming responses

---

## 📄 License

This project is open-source under the **Apache-2.0 License**.

---

## 👤 Author

**Khalid Galal**

**https://www.linkedin.com/in/khalidgalal**
# SpringAI-MCP-Client
