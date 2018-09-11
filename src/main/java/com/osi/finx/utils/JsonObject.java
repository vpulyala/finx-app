package com.osi.finx.utils;

import java.io.Serializable;
import java.util.Objects;

public class JsonObject implements Serializable {

private static final long serialVersionUID = 1L;
private String method;

public String getMethod() {
    return method;
}

public void setMethod(String method) {
    this.method= method;
}

@Override
public boolean equals(Object obj) {

    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    final JsonObject other = (JsonObject) obj;
    return Objects.equals(this.method, other.method);

}

@Override
public int hashCode() {

    return Objects.hash(this.method);

}
}
