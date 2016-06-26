package pl.java.scalatech.exercise.creating.sessionBuilder;

import org.hibernate.cfg.Configuration;
@FunctionalInterface
interface ClassMapper {
    Configuration createCfgClassMapper(Configuration cfg);
}
