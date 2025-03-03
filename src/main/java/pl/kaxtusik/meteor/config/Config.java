package pl.kaxtusik.meteor.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Header;

@Header({"KX-METEORS CONFIG","MADE BY: kaxtusik"})
public class Config extends OkaeriConfig {
    public String noPermissionMessage = "&4❌ &fNie masz uprawnień do użycia tej komendy!";
}
