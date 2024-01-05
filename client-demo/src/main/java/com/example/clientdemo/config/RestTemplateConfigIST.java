//package cn.com.agree.ab.a5.runtime.http.config;
//
//import cn.com.agree.ab.a5.runtime.http.constants.IRestTemplateConstant;
//import cn.com.agree.ab.a5.runtime.interfaces.HttpInterceptorHandleStrategy;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.http.client.HttpClient;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.TrustStrategy;
//import org.apache.http.impl.NoConnectionReuseStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.client.DefaultResponseErrorHandler;
//import org.springframework.web.client.RestTemplate;
//
//import javax.net.ssl.SSLContext;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author wuqianqian
// */
//@Configuration
//public class RestTemplateConfig {
//    private static List<HttpInterceptorHandleStrategy> httpInterceptorHandleStrategies;
//    private static final Log logger = LogFactory.getLog(RestTemplateConfig.class);
//
//    @Autowired
//    public RestTemplateConfig(List<HttpInterceptorHandleStrategy> httpInterceptorHandleStrategies) {
//        httpInterceptorHandleStrategies.sort((first, second) -> {
//            if (first.getOrder() < second.getOrder()) {
//                return -1;
//            } else if (first.getOrder() > second.getOrder()) {
//                return 1;
//            } else {
//                return 0;
//            }
//        });
//        RestTemplateConfig.httpInterceptorHandleStrategies = httpInterceptorHandleStrategies;
//    }
//
//    public static class RestTemplateConfigFields {
//
//        private int connectTimeout = 15000;
//        private int readTimeout = 60000;
//        private int requestTimeout = 15000;
//
//        public void setConnectTimeout(int connectTimeout) {
//            this.connectTimeout = connectTimeout;
//        }
//
//        public void setReadTimeout(int readTimeout) {
//            this.readTimeout = readTimeout;
//        }
//
//        public void setRequestTimeout(int requestTimeout) {
//            this.requestTimeout = requestTimeout;
//        }
//
//    }
//
//    /**
//     * 当负载均衡开启，则使用此RestTemplate实例
//     */
//    @Configuration
//    @ConditionalOnProperty(value = "cloud.discovery.enabled", matchIfMissing = true)
//    @ConfigurationProperties(prefix = "agree.runtime.rest-template.maybe-balanced")
//    public static class BalancedRestTemplateConfig extends RestTemplateConfigFields {
//
//        @Primary
//        @Bean(IRestTemplateConstant.MAYBE_BALANCED_REST_TEMPLATE)
//        @LoadBalanced
//        public RestTemplate restTemplate() {
//            return customRestTemplate(this);
//        }
//
//    }
//
//    /**
//     * 当负载均衡关闭，则使用此RestTemplate实例
//     */
//    @Configuration
//    @ConditionalOnProperty(value = "cloud.discovery.enabled", havingValue = "false")
//    @ConfigurationProperties(prefix = "agree.runtime.rest-template.maybe-balanced")
//    public static class BalancedRestTemplateWhenFalse extends RestTemplateConfigFields {
//
//        @Primary
//        @Bean(IRestTemplateConstant.MAYBE_BALANCED_REST_TEMPLATE)
//        public RestTemplate restTemplate() {
//            return customRestTemplate(this);
//        }
//
//    }
//
//    @Configuration
//    @ConfigurationProperties(prefix = "agree.runtime.rest-template.simple")
//    public static class SimpleRestTemplateConfig extends RestTemplateConfigFields {
//
//        @Bean(IRestTemplateConstant.SIMPLE_REST_TEMPLATE)
//        public RestTemplate restTemplate() {
//            return customRestTemplate(this);
//        }
//
//    }
//
//    @Configuration
//    @ConfigurationProperties(prefix = "agree.runtime.rest-template.https")
//    public static class HttpsRestTemplateConfig extends RestTemplateConfigFields {
//
//        @Bean(IRestTemplateConstant.HTTPS_REST_TEMPLATE)
//        public RestTemplate restTemplate() {
//            return httpsRestTemplateConfig(this);
//        }
//
//    }
//
//    private static RestTemplate customRestTemplate(RestTemplateConfigFields configFields) {
//        PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager();
//        pollingConnectionManager.setMaxTotal(200);
//        pollingConnectionManager.setDefaultMaxPerRoute(200);
//
//        HttpClientBuilder httpClientBuilder = HttpClients.custom();
//        httpClientBuilder.setConnectionManager(pollingConnectionManager);
//        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
//        // never re-uses a connection
//        httpClientBuilder.setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE);
//        HttpClient httpClient = httpClientBuilder.build();
//        return configureTemplate(httpClient, configFields);
//    }
//
//    public static RestTemplate httpsRestTemplateConfig(RestTemplateConfigFields configFields) {
//        try {
//            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (TrustStrategy) (arg0, arg1) -> true).build();
//
//            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext,
//                    new String[]{"TLSv1.2"},
//                    null,
//                    NoopHostnameVerifier.INSTANCE);
//
//            PoolingHttpClientConnectionManager pollingConnectionManager = new PoolingHttpClientConnectionManager(
//                    RegistryBuilder
//                            .<ConnectionSocketFactory>create()
//                            .register("http", PlainConnectionSocketFactory.INSTANCE)
//                            .register("https", csf)
//                            .build()
//            );
//            pollingConnectionManager.setMaxTotal(200);
//            pollingConnectionManager.setDefaultMaxPerRoute(200);
//
//            CloseableHttpClient httpClient = HttpClients.custom()
////                    .setSSLSocketFactory(csf)
//                    .setConnectionManager(pollingConnectionManager)
//                    .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
//                    .setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE)
//                    .build();
//            return configureTemplate(httpClient, configFields);
//        } catch (Exception e) {
//            logger.error("配置https出现异常：" + e.getMessage(), e);
//            throw new RuntimeException("配置https出现异常", e.getCause());
//        }
//    }
//
//    /**
//     * update by maleyi@agree.com.cn
//     * 超时时间以毫秒为单位
//     * @param httpClient
//     * @param fields
//     * @return
//     */
//    private static RestTemplate configureTemplate(HttpClient httpClient, RestTemplateConfigFields fields) {
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
//                httpClient);
//        clientHttpRequestFactory.setConnectTimeout(fields.connectTimeout);
//        clientHttpRequestFactory.setReadTimeout(fields.readTimeout);
//        clientHttpRequestFactory.setConnectionRequestTimeout(fields.requestTimeout);
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(clientHttpRequestFactory);
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
//        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//        interceptors.add(new CustomClientHttpRequestInterceptor());
//        restTemplate.setInterceptors(interceptors);
//
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        messageConverters.add(new FastJsonHttpMessageConverter());
//        return restTemplate;
//    }
//
//    private static class CustomClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
//
//        @Override
//        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//            ClientHttpResponse response;
//            httpInterceptorHandleStrategies.forEach((preHandle) -> preHandle.preRequestHandle(request));
//            response = execution.execute(request, body);
//            httpInterceptorHandleStrategies.forEach(postHandle -> postHandle.postResponseHandle(request, response));
//            return response;
//        }
//    }
//
//}