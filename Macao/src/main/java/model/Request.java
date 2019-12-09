package model;

import java.util.Objects;

/**
 * The type Request.
 */
public class Request {
    private String method;
    private String uri;

    /**
     * Instantiates a new Request.
     *
     * @param method the method type
     * @param uri    the uri
     */
    public Request(String method, String uri) {
        this.method = method;
        this.uri = uri;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets uri.
     *
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets uri.
     *
     * @param uri the uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        return method.equals(request.method) &&
                uri.equals(request.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri);
    }
}
