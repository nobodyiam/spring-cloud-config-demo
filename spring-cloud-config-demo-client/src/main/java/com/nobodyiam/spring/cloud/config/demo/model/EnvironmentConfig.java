package com.nobodyiam.spring.cloud.config.demo.model;

/**
 * Created by Jason on 2/25/16.
 */
public class EnvironmentConfig {
    private final String application;
    private final String profiles;
    private final String label;
    private final String serverUri;

    public EnvironmentConfig(String application, String profiles, String label, String serverUri) {
        this.application = application;
        this.profiles = profiles;
        this.label = label;
        this.serverUri = serverUri;
    }

    public static EnvironmentConfigBuilder builder() {
        return new EnvironmentConfigBuilder();
    }

    public String getApplication() {
        return application;
    }

    public String getProfiles() {
        return profiles;
    }

    public String getLabel() {
        return label;
    }

    public String getServerUri() {
        return serverUri;
    }

    public static class EnvironmentConfigBuilder {
        private String application;
        private String profiles;
        private String label;
        private String serverUri;

        public EnvironmentConfigBuilder application(String application) {
            this.application = application;
            return this;
        }

        public EnvironmentConfigBuilder profiles(String profiles) {
            this.profiles = profiles;
            return this;
        }

        public EnvironmentConfigBuilder label(String label) {
            this.label = label;
            return this;
        }

        public EnvironmentConfigBuilder serverUri(String serverUri) {
            this.serverUri = serverUri;
            return this;
        }

        public EnvironmentConfig build() {
            return new EnvironmentConfig(application,profiles,label,serverUri);
        }
    }

}
