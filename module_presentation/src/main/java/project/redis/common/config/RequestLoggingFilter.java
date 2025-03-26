package project.redis.common.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    jakarta.servlet.http.HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // 원격 IP 주소
        String remoteIp = request.getRemoteAddr();
        // 요청 헤더
        String headersJson = convertHeadersToJson(request);
        // 요청 파라미터
        String parametersJson = convertParametersToJson(request);

        log.info("Request: Remote IP: {}, Headers: {}, Method: {}, URI: {}, Parameter: {}",
                remoteIp, headersJson, request.getMethod(), request.getRequestURI(), parametersJson);

        filterChain.doFilter(request, response);
    }

    private String convertHeadersToJson(HttpServletRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headersMap.put(headerName, request.getHeader(headerName));
        }

        return convertToJson(headersMap);
    }

    private String convertParametersToJson(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        return convertToJson(parameterMap);
    }

    private String convertToJson(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return "{}"; // 변환 실패 시 빈 JSON 반환
        }
    }
}
