package pl.java.scalatech.session;

import org.hibernate.cfg.Configuration;
@FunctionalInterface
public interface ClassMapper {
    Configuration createCfgClassMapper(Configuration cfg);
}
