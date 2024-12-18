package com.solvd.example.web.automationwebpage.constants;

public enum LinkNames {
    PRODUCTS("/products"),
    HOME("/"),
    LOGIN("/login");

    private final String href;

    LinkNames(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}
