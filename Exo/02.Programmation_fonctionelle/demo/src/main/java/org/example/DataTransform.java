package org.example;

@FunctionalInterface
public interface DataTransform<T> {
    T transform (T input);
}
