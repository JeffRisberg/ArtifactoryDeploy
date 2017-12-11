package com.company;

import com.company.common.base.binding.MySQL;
import com.company.common.base.config.DatabaseConfig;
import com.company.common.base.services.config.EnvironmentBasedAppConfig;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.company.common.base.config.AppConfig;
import com.company.common.base.services.config.EnvironmentBasedMySQLConfiguration;
import com.company.services.*;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public class MainModule extends ServletModule {

    @Override
    protected void configureServlets() {

        //configs
        bind(DatabaseConfig.class).annotatedWith(MySQL.class).to(EnvironmentBasedMySQLConfiguration.class).in(Scopes.SINGLETON);
        bind(AppConfig.class).to(EnvironmentBasedAppConfig.class).in(Scopes.SINGLETON);

        bind(UserService.class).to(DefaultUserService.class).in(Scopes.SINGLETON);
        bind(IncidentService.class).to(DefaultIncidentService.class).in(Scopes.SINGLETON);
        bind(MessageService.class).to(DefaultMessageService.class).in(Scopes.SINGLETON);
    }
}