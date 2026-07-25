package demo.elastic.rag;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.modelcontextprotocol.client.McpSyncClient;

import java.util.List;

@Configuration
public class McpClientConfig {

    @Bean
    public ToolCallbackProvider toolCallbackProvider(
            List<McpSyncClient> mcpClients) {

        return new SyncMcpToolCallbackProvider(mcpClients);
    }
}