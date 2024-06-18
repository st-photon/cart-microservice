package com.photon.infrastructure;

import lombok.Getter;

import java.util.UUID;

@Getter
public final class Response {

    private Object id;

    private Response() {

    }

    private Response(Long id) {
        this.id = id;
    }

    private Response(UUID id) {
        this.id = id;
    }

    public static Response of(Long id) {
        return new Response(id);
    }

    public static Response of(UUID id) {
        return new Response(id);
    }
}
