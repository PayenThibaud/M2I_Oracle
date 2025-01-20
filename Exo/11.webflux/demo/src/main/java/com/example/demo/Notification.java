package com.example.demo;

import java.util.Objects;

public class Notification {

    private String id;
    private String message;
    private boolean urgent;

    // Constructeur avec tous les champs
    public Notification(String id, String message, boolean urgent) {
        this.id = id;
        this.message = message;
        this.urgent = urgent;
    }

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    // Méthode toString pour un affichage utile
    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", urgent=" + urgent +
                '}';
    }

    // Méthodes equals et hashCode pour une meilleure gestion des comparaisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return urgent == that.urgent &&
                Objects.equals(id, that.id) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, urgent);
    }
}
