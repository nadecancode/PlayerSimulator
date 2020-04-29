package me.allen.playersimulator.util.command.param;

import lombok.Getter;

public final class ParameterData {

    @Getter
    private final String name;
    @Getter
    private final boolean wildcard;
    @Getter
    private final String defaultValue;
    @Getter
    private final String[] tabCompleteFlags;
    @Getter
    private final Class<?> parameterClass;

    public ParameterData(Parameter parameterAnnotation, Class<?> parameterClass) {
        this.name = parameterAnnotation.name();
        this.wildcard = parameterAnnotation.wildcard();
        this.defaultValue = parameterAnnotation.defaultValue();
        this.tabCompleteFlags = parameterAnnotation.tabCompleteFlags();
        this.parameterClass = parameterClass;
    }

}