package org.kirylSam.driver;

public enum DriverFactory {
    CHROME {
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
