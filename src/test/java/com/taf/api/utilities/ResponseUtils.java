package com.taf.api.utilities;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;

/**
 * The Class ResponseUtils.
 */
public class ResponseUtils {

    /** The request payload. */
    public static String requestPayload;

    /** The response. */
    public static Response response;
    
    /** The request. */
    public static RequestSpecification request;

    /**
     * Gets the data from response using json path.
     *
     * @param jsonPath
     *            the json path
     * @return the data from response using json path
     */
    public static String getDataFromResponseUsingJsonPath(String jsonPath) {
        return response.then().extract().jsonPath().getString(jsonPath);
    }

    public static int getIntDataFromResponseUsingJsonPath(String jsonPath) {
        return response.then().extract().jsonPath().getInt(jsonPath);
    }

    /**
     * Assert response status.
     *
     * @param expectedStatusCode
     *            the expected status code
     */
	public static void assertResponseStatus(int expectedStatusCode) {
		response.then().statusCode(expectedStatusCode);
	}

    public static String readResponseJsonSchema(String jsonSchema) {
        try {
            URL file = Resources
                    .getResource("config/json/ResponseJsonSchema/"
                            + jsonSchema + ".json");
            String jsonString = Resources.toString(file, Charsets.UTF_8);
            return jsonString;
        } catch (Exception e) {

            System.out.println("Error while altering json : " + e);
            return null;
        }
    }

    // Here just pass the JSON schema from your step definition
    // It will validate the JSON Schema With The Response

    public static void validateJsonSchema(String schema) {
        response.then().assertThat().body(JsonSchemaValidator
                .matchesJsonSchema(ResponseUtils.readResponseJsonSchema(schema)));

    }


}
