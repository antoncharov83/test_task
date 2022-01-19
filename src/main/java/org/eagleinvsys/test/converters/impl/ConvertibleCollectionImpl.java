package org.eagleinvsys.test.converters.impl;

import lombok.NonNull;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.util.Collection;

public class ConvertibleCollectionImpl implements ConvertibleCollection {
    private final Collection<String> headers;
    private final Iterable<ConvertibleMessage> records;

    public ConvertibleCollectionImpl(@NonNull Collection<String> headers, @NonNull Iterable<ConvertibleMessage> records) {
        this.headers = headers;
        this.records = records;
    }

    @Override
    public Collection<String> getHeaders() {
        return headers;
    }

    @Override
    public Iterable<ConvertibleMessage> getRecords() {
        return records;
    }
}
