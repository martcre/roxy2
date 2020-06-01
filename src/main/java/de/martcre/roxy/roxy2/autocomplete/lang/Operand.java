package de.martcre.roxy.roxy2.autocomplete.lang;

public class Operand extends Item {

    public Operand(String value) {
        super(value);
    }

    @Override
    public boolean isAllowedPrefix(Item otherItem) {
        return (otherItem instanceof Operator);
    }

    @Override
    public boolean isAllowedSuffix(Item otherItem) {
        return (otherItem == null || otherItem instanceof ChainOperator);
    }
}
