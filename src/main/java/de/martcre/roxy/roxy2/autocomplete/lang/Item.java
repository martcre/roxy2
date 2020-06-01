package de.martcre.roxy.roxy2.autocomplete.lang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents an Item to be used for auto completion.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Item {
    private String value;

    /**
     * Checks if otherItem is allowed to prefix this item.
     * @param otherItem
     * @return true if otherItem is allowed as prefix item
     */
    public abstract boolean isAllowedPrefix(Item otherItem);

    /**
     * Checks if otherItem is allowed to suffix this item.
     * @param otherItem
     * @return true if otherItem is allowed as suffix item
     */
    public abstract boolean isAllowedSuffix(Item otherItem);
}
