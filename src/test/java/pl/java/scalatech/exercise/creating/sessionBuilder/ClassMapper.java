package pl.java.scalatech.exercise.creating.sessionBuilder;

import org.hibernate.cfg.Configuration;
@FunctionalInterface
public interface ClassMapper {
    Configuration createCfgClassMapper(Configuration cfg);
}
