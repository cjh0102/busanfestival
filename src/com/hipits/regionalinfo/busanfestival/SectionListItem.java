package com.hipits.regionalinfo.busanfestival;

/**
 * Item definition including the section.
 */
public class SectionListItem {
    public Object item;
    public String section;

    public SectionListItem(final Object item, final String section) {
        this.item = item;
        this.section = section;
    }

    @Override
    public String toString() {
        return item.toString();
    }

}
