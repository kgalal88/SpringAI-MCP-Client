
package demo.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.http.HttpClient;

@SpringBootApplication
public class SpringAIMCPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAIMCPApplication.class, args);
	}

	@Component
	public class RestClientCustomizer {
		@Bean
		@Primary
		public RestClient.Builder customRestClientBuilder() {
			HttpClient httpClient = HttpClient.newBuilder()
					.version(HttpClient.Version.HTTP_1_1)
					.build();
			return RestClient.builder()
					.requestFactory(new JdkClientHttpRequestFactory(httpClient));
		}
	}
}
