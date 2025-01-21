package org.example.services.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        // Log request details
        logRequest(requestSpec);

        // Proceed with the next filter in the chain
        Response response = ctx.next(requestSpec, responseSpec);

        // Log response details
        logResponse(response);

        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        if (requestSpec != null) {
            logger.info("Request URI: " + requestSpec.getURI());
            logger.info("Request Method: " + requestSpec.getMethod());
            logger.info("Request Headers: " + requestSpec.getHeaders());

            if (requestSpec.getBody() != null) {
                logger.info("Request Body: " + requestSpec.getBody());
            }
        }
    }

    private void logResponse(Response response) {
        if (response != null) {
            logger.info("Response Status Code: " + response.getStatusCode());
            logger.info("Response Headers: " + response.getHeaders());

            if (response.getBody() != null) {
                logger.info("Response Body: " + response.getBody().asPrettyString());
            }
        }
    }
}
