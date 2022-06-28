package com.icrown.gameapi.commons.configs;

public enum EventTypeData {
    MAINTAIN_EVENT(10),
    EVENT_EVENT(20);

    private int eventType;

    EventTypeData(int eventType) {
        this.eventType = eventType;
    }

    public int getEventType() {
        return eventType;
    }
}
