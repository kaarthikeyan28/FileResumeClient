package com.company.filetask.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

import java.io.IOException;
import java.io.OutputStream;

public class ProgressEntityWrapper extends HttpEntityWrapper {
    private ProgressListener listener;

    public ProgressEntityWrapper(HttpEntity entity, ProgressListener listener) {
        super(entity);
        this.listener = listener;
    }

    @Override
    public void writeTo(OutputStream outstream) throws IOException {
        super.writeTo(new CountingOutputStream(outstream, listener, getContentLength()));
    }
}