package amdb.com.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springdoc.core.AbstractSwaggerUiConfigProperties;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final DiscoveryClient discoveryClient;

    @GetMapping("/v3/api-docs/swagger-config")
    public Map<String, Object> swaggerConfig(ServerHttpRequest serverHttpRequest) throws URISyntaxException {

        URI uri = serverHttpRequest.getURI();
        String url = new URI(uri.getScheme(), uri.getAuthority(), null, null, null).toString();
        Map<String, Object> swaggerConfig = new LinkedHashMap<>();
        List<AbstractSwaggerUiConfigProperties.SwaggerUrl> swaggerUrls = new LinkedList<>();

        discoveryClient.getServices().forEach(serviceName -> {
            if (!serviceName.equals("api-gateway")) {
                String newUrl = url + "/" + serviceName + "/v3/api-docs";
                AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl = new AbstractSwaggerUiConfigProperties.SwaggerUrl();
                swaggerUrl.setName(serviceName);
                swaggerUrl.setDisplayName(serviceName);
                swaggerUrl.setUrl(newUrl);
                swaggerUrls.add(swaggerUrl);
            }
        });
        swaggerConfig.put("urls", swaggerUrls);
        return swaggerConfig;
    }
}