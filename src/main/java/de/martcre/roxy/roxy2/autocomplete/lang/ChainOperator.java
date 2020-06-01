package de.martcre.roxy.roxy2.autocomplete.lang;

public class ChainOperator extends Item {

    public static final ChainOperator[] CHAIN_OPERATORS = new ChainOperator[] {
            new ChainOperator("AND"),
            new ChainOperator("OR")
    };

    public ChainOperator(String value) {
        super(value);
    }

    @Override
    public boolean isAllowedPrefix(Item otherItem) {
        return (otherItem instanceof Operand);
    }

    @Override
    public boolean isAllowedSuffix(Item otherItem) {
        return (otherItem instanceof SelectItem);
    }
}
