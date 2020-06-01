package de.martcre.roxy.roxy2.autocomplete.lang;

public class Operator extends Item {

    public static final Operator[] OPERATORS = new Operator[] {
            new Operator("EQUALS_TO"),
            new Operator("DIFFERENT_FROM"),
            new Operator("LIKE"),
            new Operator("NOT_LIKE"),
            new Operator("GREATER_THAN"),
            new Operator("GREATER_THAN_OR_EQUAL"),
            new Operator("LESS_THAN"),
            new Operator("LESS_THAN_OR_EQUAL"),
            new Operator("IN"),
            new Operator("NOT_IN")
    };

    public Operator(String value) {
        super(value);
    }

    @Override
    public boolean isAllowedPrefix(Item otherItem) {
        return (otherItem instanceof SelectItem);
    }

    @Override
    public boolean isAllowedSuffix(Item otherItem) {
        return (otherItem instanceof Operand);
    }
}
