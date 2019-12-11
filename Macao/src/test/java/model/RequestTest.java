package model;

import org.junit.jupiter.api.Test;

/**
 * The type Request test.
 */
class RequestTest {

    /**
     * Gets method test method.
     */
    @Test
    void getMethod() {
        String method = "POST";
        Request request = new Request(method, "test");
        assert request.getMethod() == method;
    }

    /**
     * Sets method test method.
     */
    @Test
    void setMethod() {
        String method = "POST";
        Request request = new Request("GET", "test");
        request.setMethod("POST");
        assert request.getMethod() == method;
    }

    /**
     * Gets uri test method.
     */
    @Test
    void getUri() {
        String uri = "test";
        Request request = new Request("GET", uri);
        assert request.getUri() == uri;
    }

    /**
     * Sets uri test method.
     */
    @Test
    void setUri() {
        String uri = "test";
        Request request = new Request("GET", uri);
        request.setUri(uri);
        assert request.getUri() == uri;
    }

    /**
     * Test equals test method.
     */
    @Test
    void testEquals() {
        String firstUri = "POST";
        String secondUri = "GET";
        assert !firstUri.equals(secondUri);
    }

    /**
     * Test hash code test method.
     */
    @Test
    void testHashCode() {
        String firstUri = "POST";
        String secondUri = "GET";
        assert firstUri.hashCode() != secondUri.hashCode();
    }
}