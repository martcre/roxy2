package de.martcre.roxy.roxy2.autocomplete.lang;

public class SelectItem extends Item {

    public SelectItem(String value) {
        super(value);
    }

    @Override
    public boolean isAllowedPrefix(Item otherItem) {
        return (otherItem == null || otherItem instanceof ChainOperator);
    }

    @Override
    public boolean isAllowedSuffix(Item otherItem) {
        return (otherItem == null || otherItem instanceof Operator);
    }
}
