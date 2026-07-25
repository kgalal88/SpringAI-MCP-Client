package demo.mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class MCPService {

    private static final Logger log = LoggerFactory.getLogger(MCPService.class);

    private ChatClient chatClient;
    private final ToolCallbackProvider toolCallbackProvider;

    public MCPService(ChatClient.Builder clientBuilder, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = clientBuilder.build();
        this.toolCallbackProvider = toolCallbackProvider;
    }

    public String queryLLM(String question) {

        String prompt = question;

        // Calling the chat model with the question
        String response = chatClient.prompt()
            .user(prompt)
//            .tools(mcpClient.listTools())
            .toolCallbacks(toolCallbackProvider)
            .call()
            .content();


        return response;
    }
}
